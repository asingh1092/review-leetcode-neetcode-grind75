package com.singh.solid.interfacesegregation;

public interface BearKeeper {

    // Too many concerns, thus we should probably segregate each to smaller interfaces
    void washTheBear();
    void feedTheBear();
    void petTheBear();
}
