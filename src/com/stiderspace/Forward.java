package com.stiderspace;

import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class Forward  implements Behavior {
   private boolean suppressed = false;
   
   public boolean takeControl() {
      return true;
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {
     suppressed = false;
     Motor.B.setSpeed(50);
     Motor.C.setSpeed(50);
     Motor.B.forward();
     Motor.C.forward();
     while( !suppressed )
        Thread.yield();
     Motor.A.stop(); // clean up
     Motor.C.stop();
   }
}