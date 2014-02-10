package com.stiderspace;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class WallTurn implements Behavior {
        private UltrasonicSensor sonar;
        private boolean suppressed = false;
        
        public WallTurn(SensorPort s2 )
        {
           sonar = new UltrasonicSensor( s2 );
        }

        public boolean takeControl() {
           return sonar.getDistance() < 25;
        }

        public void suppress() {
           suppressed = true;
        }

        public void action() {
           suppressed = false;
           Motor.B.rotate(360, true);
           Motor.C.rotate(-360, true);

           while( Motor.C.isMoving() && !suppressed )
             Thread.yield();

           Motor.B.stop();
           Motor.C.stop();
        }
    }