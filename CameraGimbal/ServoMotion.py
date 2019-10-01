import RPi.GPIO as GPIO          
import time
from time import sleep

#Hardware
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)

hMotorPins = [21, 20, 16, 12]
vMotorPins = [26, 19, 13, 6]

motorSequence = [
            [1, 0, 0, 1],
            [1, 0, 0, 0],
            [1, 1, 0, 0],
            [0, 1, 0, 0],
            [0, 1, 1, 0],
            [0, 0, 1, 0],
            [0, 0, 1, 1],
            [0, 0, 0, 1]
]

#Set all pins as output
def resetAllPins():
    for pin in hMotorPins:
            GPIO.setup(pin, GPIO.OUT)
            GPIO.output(pin, False)
            
    for pin in vMotorPins:
            GPIO.setup(pin, GPIO.OUT)
            GPIO.output(pin, False)


### Define motion
def moveLeft():
    for i in range(32):
         for halfstep in range(8):
                for pin in range(4):
                        GPIO.output(vMotorPins[pin], motorSequence[halfstep][pin])
                        time.sleep(0.001)
    resetAllPins()
    
def moveRight():
    for i in range(32):
         for halfstep in reversed(range(8)):
                for pin in reversed(range(4)):
                        GPIO.output(vMotorPins[pin], motorSequence[halfstep][pin])
                        time.sleep(0.001)
    resetAllPins()

def moveUp():
    for i in range(32):
         for halfstep in reversed(range(8)):
                for pin in reversed(range(4)):
                        GPIO.output(hMotorPins[pin], motorSequence[halfstep][pin])
                        time.sleep(0.001)
    resetAllPins()

def moveDown():
    for i in range(32):
         for halfstep in range(8):
                for pin in range(4):
                        GPIO.output(hMotorPins[pin], motorSequence[halfstep][pin])
                        time.sleep(0.001)
    resetAllPins()

#We need to reset the pins after each action so that we don't keep the servo motors under load

#Set all pins in default mode
def stopMovement():
    resetAllPins()

#This metod will disable any action regarding GPIO pins
#After this method is called we need to reinitailize the GPIO pins
def close():
    GPIO.cleanup()