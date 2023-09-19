package com.singh.neetcode.arrayshashing.medium;

import java.util.Arrays;

public class ProductExceptSelf {

    /*
        Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
        of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer

        You must write an algorithm that runs in O(n) time and without using the division operation.

        Input: nums = [1,2,3,4]
        Output:[24, 12, 8, 6]

        [1, 2, 3, 4]
   i=0   ^  ^
         f  b
        [1, 2, 3, 4]
   i=1   ^     ^
         f     b
        [1, 2, 3, 4]
   i=2      ^     ^
            f     b
        [1, 2, 3, 4]
   i=3         ^  ^
               f  b

        Input: nums = [-1, 1, 0, -3, 3]
        Output: [0, 0, 9, 0, 0]
     */


    /*
        With division operator ????

     */
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);
        for (int i = 0; i < nums.length; i++) {
            int forward = 0;
            int backwards = nums.length - 1;
            while (forward != i) {
                answer[forward] *= nums[i];
                forward++;
            }
            while (backwards != i) {
                answer[backwards] *= nums[i];
                backwards--;
            }
        }
        return answer;
    }

    /*
        nums [1,2,3,4]

        pre  [1,1,2,6]

        suf  [24,12,4,1]

        ans [24,12,8,6]
     */
    public int[] productExceptSelfPrefixSuffix(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }

    /*
        nums [1,2,3,4]

        ans  [1,1,1,1]
              1 1 2 6
        cur   6

        ans [1,1,2,6]
             24 12 4 1
        cur  24

       ans  [24,12,8,6]
     */
    public int[] productExceptSelfConstantSpace(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
