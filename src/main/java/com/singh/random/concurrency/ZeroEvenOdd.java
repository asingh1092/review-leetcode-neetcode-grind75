package com.singh.random.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    /* Given function printNumber(int param) that prints to console

        An instance of ZeroEvenOdd has 3 functions zero(), even(), and odd()
        zero() -> outputs zeros on Thread A
        even() -> outputs evens on Thread B
        odd() -> outputs odds on Thread C

        Modify the class to print the series "010203040506 ... n" where n is number of digits to be printed
     */

    private int n = 0;
    Semaphore s0, sEven, sOdd;
    public ZeroEvenOdd(int n) {
        this.n = n;
        s0 = new Semaphore(1);
        sEven = new Semaphore(0);
        sOdd = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            s0.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                sEven.release();
            } else {
                sOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= this.n; i += 2) {
            sEven.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i += 2) {
            sOdd.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
    }
}
