package com.ayush.Two_Pointer;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;
        Arrays.sort(arr);

        // Call the twoSum function and print the result
        if (twoSum(arr, target)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        System.out.println(Arrays.toString(returnTwoSumIndices(arr,target)));

    }

    private static boolean twoSum(int[] arr, int target) {

        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int sum = arr[l] + arr[r];
            if(sum ==target)
                return true;
            else if(sum <target)
                l++;
            else
                r--;
        }
        return false;
    }
    private static int[] returnTwoSumIndices(int[] arr, int target) {

        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int sum = arr[l] + arr[r];
            if(sum ==target)
                return new int[]{l,r};
            else if(sum <target)
                l++;
            else
                r--;
        }
        return null;
    }
}
