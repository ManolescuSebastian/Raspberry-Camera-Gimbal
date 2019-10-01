# Raspberry-Camera-Gimbal

This project contains the code required to move stepper motors and stream video.

![alt text](https://github.com/ManolescuSebastian/Raspberry-Camera-Gimbal/images/20190930_135807.jpg)

### Required components

- Raspberry pi
- Raspberry pi camera
- 2 stepper motors (28byj-48)
- 2 ULN2003 Motor Driver Board BRD311
- Wire connectors
- M3 screws (M3 * 8 , M3 * 12, M3 * 16)
- M2 screws (M2 * 6 - or M2 * 8)

### Pinout connection
Raspberry pi | ULN2003 Driver Board (1)
------------ | -------------
GPIO21 | IN1
GPIO20 | IN2
GPIO16 | IN3
GPIO12 | IN4
GND | GND
5V | 5V

Raspberry pi | ULN2003 Driver Board (2)
------------ | -------------
GPIO26 | IN1
GPIO19 | IN2
GPIO13 | IN3
GPIO06 | IN4
GND | GND
5V | 5V
