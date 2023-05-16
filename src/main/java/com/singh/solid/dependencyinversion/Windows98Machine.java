package com.singh.solid.dependencyinversion;

public class Windows98Machine {

    // By declaring the StandardKeyboard and Monitor with the new keyword,
    // we've tightly coupled these three classes together.
    public final StandardKeyboard keyboard;
    public final Monitor monitor;

    public Windows98Machine() {
        monitor = new Monitor();
        keyboard = new StandardKeyboard();
    }
}
