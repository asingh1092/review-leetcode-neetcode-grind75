package com.singh.leetcodedaily;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {

    List<Integer> stream;

    public ProductOfTheLastKNumbers() {
        stream = new ArrayList<>();
    }

    public void add(int num) {
        stream.add(num);

    }

    public int getProduct(int k) {
        int product = 1;
        int pos = stream.size() - 1;
        for (int i = k; i > 0; i--) {
            product *= stream.get(pos);
            pos = pos - 1;
        }
        return product;
    }

    public static void main(String[] args) {
        ProductOfTheLastKNumbers p = new ProductOfTheLastKNumbers();
        p.add(3);
        p.add(0);
        p.add(2);
        p.add(5);
        p.add(4);
        System.out.println(p.getProduct(2));
    }
}
