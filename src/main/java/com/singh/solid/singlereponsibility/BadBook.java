package com.singh.solid.singlereponsibility;

public class BadBook {

    /*
        This method should not be a part of the Book class! Delegate it to another class called BookPrinter instead
     */
    void printTextToConsole() {
        // our code for formatting and printing the Text
    }
}
