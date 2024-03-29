from time import sleep
from flask import Flask, request, render_template
from flask_restful import Resource, Api
from StepperMotionAPI import StepperMotionAPI
from camera_pi import Camera

app = Flask(__name__)
api = Api(app)

stepperApi = StepperMotionAPI

#default web page
@app.route('/')
def index():
    return render_template('/index.html')

#display camera video feed using the /stream.mjpg endpoint
def gen(camera):
    #"""Video streaming generator function."""
    while True:
        frame = camera.get_frame()
        yield (b'--frame\r\n'
               b'Content-Type: image/jpeg\r\n Content-Length: ' + len(frame) + b'\r\n\r\n' + frame + b'\r\n')

@app.route('/stream.mjpg')
def video_feed():
    #"""Video streaming route. Put this in the src attribute of an img tag."""
    return Response(gen(Camera()),
                    mimetype='multipart/x-mixed-replace; boundary=frame')


#API requests mapping
api.add_resource(stepperApi, '/api/stepper')
                        
if __name__ == '__main__':
    app.run(debug=True, '0.0.0.0', threaded=True)
