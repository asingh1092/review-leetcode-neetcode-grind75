package com.singh.neetcode.arrayshashing.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EncodeAndDecodeStrings {

    public String encode(List<String> inputs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputs.size(); i++) {
            if (i == inputs.size() - 1) {
                sb.append(inputs.get(i));
            } else {
                sb.append(inputs.get(i)).append(":;");
            }
        }
        return sb.toString();
    }

    public List<String> decode(String encodedString) {
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedString.length(); i++) {
            if (encodedString.charAt(i) == ':' && encodedString.charAt(i + 1) == ';') {
                ret.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(encodedString.charAt(i));
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        EncodeAndDecodeStrings ed = new EncodeAndDecodeStrings();
        System.out.println(ed.encode(List.of("lint", "code", "love", "you")));
        System.out.println(ed.decode(ed.encode(List.of("lint", "code", "love", "you"))));

        System.out.println(ed.encode(List.of("we", "say", ":", "yes")));
        System.out.println(ed.decode(ed.encode(List.of("we", "say", ":", ";"))));
    }
}
