package com.singh.neetcode.dp;

public class LongestCommonSubsequence {

    /*
        Given two strings text1 and text2, return the length of their longest common subsequence. If no common
        subsequence exists, return 0.

        A subsequence of a string is made by deleting characters in the original string, and keeping the relative
        ordering of characters.

        e.g. text1 = "abcde"                                      1. find shorter string
             text2 = "ace"                               abcde   ace
             ret = 3

                                                   a        []
                                                c    e       c           []
                                              e             e           e
             text1 = "abc"             ace    ae     ce   e
             text2 = "abc"
             ret = 3
                                                            a                               []
                                                  b       c     d     e           c      d      e                  []
                                                c d e    d e    e              d  e      e                        d
                                              d   e     e                    e                                  e                []
                                            e                                                                           e
             text1 = "abc"
             text2 = "def"
             ret = 0
     */
}
