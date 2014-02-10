package com.stiderspace;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

public class SpeedUp implements Behavior {
    private LightSensor light;
    private boolean suppressed = false;
    
    public SpeedUp(SensorPort s1) {
         light = new LightSensor(s1);
    }

    public boolean takeControl() {
       
        return light.getNormalizedLightValue() <= 310;
    }
    
    public void suppress() {
        suppressed = true;

    }


    public void action() {
        suppressed = false;
        Motor.B.setSpeed(100);
        Motor.C.setSpeed(100);
        Motor.B.forward();
        Motor.C.forward();
        while( !suppressed )
            Thread.yield();
         Motor.A.stop(); // clean up
         Motor.C.stop();
    }

   
}
