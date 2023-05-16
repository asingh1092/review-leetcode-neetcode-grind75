package com.singh.solid.liskovsubstitution;

public class ElectricCar implements Car {

    // By throwing car without an engine into the mix, we are changing the behavior of our program thus
    // VIOLATING Liskov's substitution. We can fix this by reworking the Car interface to take into account
    // the engine-less state of car.
    public void turnOnEngine() {
        throw new AssertionError("I don't have an engine!");
    }

    public void accelerate() {
        //this acceleration is crazy!
    }
}
