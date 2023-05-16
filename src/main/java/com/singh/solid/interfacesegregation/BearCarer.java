package com.singh.solid.interfacesegregation;

public class BearCarer implements BearCleaner, BearFeeder {

    @Override
    public void washTheBear() {
        // wash wash wash
    }

    @Override
    public void feedTheBear() {
        // feed feed feed
    }
}
