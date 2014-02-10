package com.stiderspace;

import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Opdracht1 {
    public static void main(String [] args)
    {
        Behavior b1 = new Forward();
        Behavior b2 = new SpeedUp(SensorPort.S1);
        Behavior b3 =new WallTurn(SensorPort.S2);
        Behavior [] bArray = {b1, b2, b3};
        Arbitrator arby = new Arbitrator(bArray);
        arby.start();
        
    }
    
}

