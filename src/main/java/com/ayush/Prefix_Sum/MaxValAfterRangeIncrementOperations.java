package com.ayush.Prefix_Sum;

import java.util.Arrays;

/*Consider an array of size n with all initial values as 0. We need to perform the following m range increment operations.

increment(a, b, k) : Increment values from 'a' to 'b' by 'k'.

After m operations, we need to calculate the maximum of the values in the array.
Input : n = 5 m = 3
           a = 0, b = 1, k = 100
           a = 1, b = 4, k = 100
           a = 2, b = 3, k = 100
Output : 200
Explanation:
Initially array = {0, 0, 0, 0, 0}
After first operation: {100, 100, 0, 0, 0}
After second operation: {100, 200, 100, 100, 100}
After third operation {100, 200, 200, 200, 100}
Maximum element after m operations is 200.

Input : n = 4 m = 3
            a = 1, b = 2, k = 603
            a = 0, b = 0, k = 286
            a = 3, b = 3, k = 882
Output : 882
Explanation:
Initially array = {0, 0, 0, 0}
After first operation: {0, 603, 603, 0}
After second operation: {286, 603, 603, 0}
After third operation: {286, 603, 603, 882}
Maximum element after m operations is 882.*/
public class MaxValAfterRangeIncrementOperations {
    public static void main(String[] args) {
        int n = 5;
        int[] l = {0, 1, 2};
        int[] r = {1, 4, 3};
        // value of k to be added at each operation
        int[] k = {100, 100, 100};
        System.out.println("Maximum value after 'm' operations is " + findMax(n, l, r, k));
    }

    public static int findMax(int n, int[] l, int[] r, int[] k) {
        int[] arr = new int[n];
        //make updates is the array to inculcate all the range updates
        updateArrayWithRangeUpdates(n,l,r,k,arr);

        //calculate prefix sum to construct updated array
        int[] prefixArr = calculatePrefixSumArray(arr);

        //find max element in prefixArr
        int max = calculateMaxElement(prefixArr);

        return max;
    }



    public static int findMaxOptimized(int n, int[] l, int[] r, int[] k) {
        int[] arr = new int[n];
        //make updates is the array to inculcate all the range updates
        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];
            arr[left] += k[i];
            if (right < n-1) {
                arr[right + 1] -= k[i];
            }
        }

        //calculate prefix sum to construct updated array
        int max = Integer.MIN_VALUE;
        int[] prefixArr = new int[n];
        prefixArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixArr[i] = arr[i] + prefixArr[i - 1];
            max = Math.max(max, prefixArr[i]);
        }
        return max;
    }

    private static void updateArrayWithRangeUpdates(int n, int[] l, int[] r, int[] k, int[] arr) {
        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];
            arr[left] += k[i];
            if (right < n-1) {
                arr[right + 1] -= k[i];
            }
        }
    }
    private static int[] calculatePrefixSumArray(int[] arr){
        int[] prefixArr = new int[arr.length];
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixArr[i] = arr[i] + prefixArr[i - 1];
        }
        return prefixArr;
    }
    private static int calculateMaxElement(int[] prefixArr) {
        int max = Integer.MIN_VALUE;
        for (int ele : prefixArr) {
            max = Math.max(max, ele);
        }
        return max;
    }
}
