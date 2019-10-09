import StepperMotion
from time import sleep

from flask import json
from flask import jsonify
from flask import Flask, request, render_template
from flask_restful import Resource, Api
from flask import Response

class StepperMotionAPI(Resource):
    def get(self):
        arg = request.args['move']
        if(arg == "up"):
            StepperMotion.moveUp()
            return jsonify(
                status = 200,
                movement = 'up')
            return response
        elif(arg == "down"):
            StepperMotion.moveDown()
            return jsonify(
                status = 200,
                movement = 'down')
        elif(arg == "left"):
            StepperMotion.moveLeft()
            return jsonify(
                status = 200,
                movement = 'left')
        elif(arg == "right"):
            StepperMotion.moveRight()
            return jsonify(
                status = 200,
                movement = 'right')
        elif(arg == 'stop'):
            StepperMotion.stopMovement()
            return jsonify(
                status = 200,
                movement = 'stop')
        else:
            return jsonify(
                status = 400,
                movement = 'Error')

