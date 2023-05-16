package com.singh.solid.dependencyinversion;

public class Machine {

    // much better!
    private final Keyboard keyboard;
    private final Monitor monitor;

    public Machine(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}
