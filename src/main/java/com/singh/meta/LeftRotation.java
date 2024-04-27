package com.singh.meta;

import java.util.*;
public class LeftRotation {

    /*
        1 2 3 4 5        4
        0 1 2 3 4
        ^       ^
        h       t
        4 % 5 = 1

     */
    public List<Integer> rotate(List<Integer> a, int d) {
        int size = a.size();
        if (size == 0 || size == 1) {
            return a;
        }
        d = d % size;
        while (d-- > 0) {
            rotateLeft(a);
        }
        return a;
    }

    private void rotateLeft(List<Integer> a) {
        int size = a.size();
        int temp = a.get(0);
        for (int i = 0; i < size - 1; i++) {
            a.set(i, a.get(i + 1));
        }
        a.set(size - 1, temp);
    }

    public List<Integer> crazySolution(List<Integer> a, int d) {
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<Integer> a = List.of(1,2,3,4,5);
        int d = 4;
        int t = a.size();
        while (d >= t) {
            d = d % t;
        }
    }
}
