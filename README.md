# Raspberry-Camera-Gimbal

This project contains the code required to move stepper motors and stream video.


![alt text](https://github.com/ManolescuSebastian/Raspberry-Camera-Gimbal/blob/master/images/20190930_135807.jpg)



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


