package com.ayush.Prefix_Sum;

import java.util.Arrays;

public class BasicImplementation {
    public static void main(String[] args) {
       int arr[] = {10, 20, 10, 5, 15};
       //Output: 10 30 40 45 60
        int[] output = calculatePrefixSum(arr, arr.length);
        System.out.println(Arrays.toString(output));
    }

    private static int[] calculatePrefixSum(int[] arr, int n) {
        int previousSum=0;
        int[] output = new int[n];
        for (int i = 0; i<n ; i++) {
           output[i] = previousSum += arr[i];
        }
        return output;
    }
}
