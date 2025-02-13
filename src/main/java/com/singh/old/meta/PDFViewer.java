package com.singh.old.meta;

import java.util.*;

public class PDFViewer {

    public int maxHeightOfView(List<Integer> h, String word) {
        int max = 1;
        for (char c : word.toCharArray()) {
            max = Math.max(h.get(c - 'a'), max);
        }
        return max * word.length();
    }


}
