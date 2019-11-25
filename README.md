# Raspberry-Camera-Gimbal

Raspberry Pi API project that provides two video streaming options and stepper motor movement 360° rotation.</br>

**Youtube video:**

[![Raspberry pi camera gimbal](http://img.youtube.com/vi/GQbLwBo25KM/0.jpg)](http://www.youtube.com/watch?v=GQbLwBo25KM "Raspberry pi camera gimbal")

The main API endpoints for this projects are for camera movement and video stream </br>

**/api/stepper** with query params </br>

- move = up
- move = down
- move = right
- move = down
- move = stop

**/stream.mjpg**  </br>
This endpoint is used for video streaming.

But we also have another option for video streaming that is more faster/better video quality </br>
In stream_server (https://github.com/ManolescuSebastian/Raspberry-Camera-Gimbal/tree/master/CameraGimbal/stream_server) we have the a standalone server that requires to run on a **different port**. </br>
More information here: https://picamera.readthedocs.io/en/release-1.10/recipes1.html

### How to start
In order to start the server first we need to add a **base URL** in MainApp.py (or CameraStream.py if you are using the streaming server). <br>
To find out your Raspberry Pi IP open a terminal and type ifconfig (192.168.1.X)<br>
Add rapspberry IP to MainApp.py in the last code line (e.q. app.run(debug=True, port=5050, **host='192.168.1. todo'**,threaded=True)) or/and if you are using CameraStream.py add it to  address = (**'192.168.1.todo'**, 5020) <br>

**Note:** You can add any port you want (5050, 5020) was a personal choice.<br>

After the steps above are completed open a terminal and type<br>
**python MainApp.py** or/and **python CameraStream.py** <br>

### Libraries required in order to run this project
Flask (https://pypi.org/project/Flask/)

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

</br></br>

### Schematic
</br>
<img src="https://github.com/ManolescuSebastian/Raspberry-Camera-Gimbal/blob/master/images/camera_gimbal_schematic_bb_50.jpg" width="500">
</br>

[Schematic created using Fritzing](http://fritzing.org/home/ "http://fritzing.org")

    Copyright 2019

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


