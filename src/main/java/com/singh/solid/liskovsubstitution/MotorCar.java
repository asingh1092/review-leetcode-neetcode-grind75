package com.singh.solid.liskovsubstitution;

public class MotorCar implements Car {

    private Engine engine;

    @Override
    public void turnOnEngine() {
        engine.turnOn();
    }

    @Override
    public void accelerate() {
        engine.powerOn(1000);
    }
}
