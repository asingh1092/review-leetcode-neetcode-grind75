package com.singh.old.grind75.week3;

public class FirstBadVersion {

    /*
       0  1  2  3  4  5  6  7  8  9



     */
    private int version = 0;
    private FirstBadVersion() {}
    public FirstBadVersion(int version) {
        this.version = version;
    }
    public int firstBadVersion(int n) {
        if (n < 1) {
            return n;
        }
        int lowest = 0;
        int highest = n;
        while (lowest < highest) {
            int mid = lowest + (highest - lowest) / 2;
            if (isBadVersion(mid)) {
                highest = mid;
            } else {
                lowest = mid + 1;
            }
        }
        return lowest;
    }

    private boolean isBadVersion(int versionToCheck) {
        return this.version == versionToCheck;
    }

    public static void main(String[] args) {
        FirstBadVersion b = new FirstBadVersion(8);
        System.out.println(b.firstBadVersion(9));
    }
}
