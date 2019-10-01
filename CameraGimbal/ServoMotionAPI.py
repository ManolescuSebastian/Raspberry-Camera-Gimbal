import ServoMotion
from time import sleep

from flask import json
from flask import jsonify
from flask import Flask, request, render_template
from flask_restful import Resource, Api
from flask import Response

class ServoMotionAPI(Resource):
    def get(self):
        arg = request.args['move']
        if(arg == "up"):
            ServoMotion.moveUp()
            return jsonify(
                status = 200,
                movement = 'up')
            return response
        elif(arg == "down"):
            ServoMotion.moveDown()
            return jsonify(
                status = 200,
                movement = 'down')
        elif(arg == "left"):
            ServoMotion.moveLeft()
            return jsonify(
                status = 200,
                movement = 'left')
        elif(arg == "right"):
            ServoMotion.moveRight()
            return jsonify(
                status = 200,
                movement = 'right')
        elif(arg == 'stop'):
            ServoMotion.stopMovement()
            return jsonify(
                status = 200,
                movement = 'stop')
        else:
            return jsonify(
                status = 400,
                movement = 'Error')

