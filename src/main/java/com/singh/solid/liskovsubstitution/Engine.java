package com.singh.solid.liskovsubstitution;

public class Engine {

    public boolean engineOn;
    public int power;

    public void turnOn() {
        if (!engineOn) {
            engineOn = true;
        }
    }

    public void powerOn(int to) {
        power = to;
    }
}
