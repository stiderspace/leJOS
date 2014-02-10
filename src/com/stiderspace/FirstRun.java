package com.stiderspace;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class FirstRun {
    
    public static void main(String[] args) throws Exception {
        UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S2);
        if (sonic.getDistance() <= 300){
        Motor.B.forward();
        Motor.C.forward();
      }
    }
}
