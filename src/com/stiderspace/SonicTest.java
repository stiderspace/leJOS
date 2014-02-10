package com.stiderspace;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class SonicTest {
  public static void main(String[] args) throws Exception {
    UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S2);

    while (true) {
        LCD.drawInt(sonic.getDistance(), 0, 3, 0);
        Button.waitForAnyPress();
    }
  }
}