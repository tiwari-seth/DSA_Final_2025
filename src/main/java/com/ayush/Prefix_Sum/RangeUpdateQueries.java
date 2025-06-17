package com.ayush.Prefix_Sum;

import java.util.Arrays;

/*You are given an integer array arr[] and a list of queries. Each query is represented as a list of integers where:

[1, l, r, x]: Adds x to all elements from arr[l] to arr[r] (inclusive).
[2]: Prints the current state of the array.
You need to perform the queries in order.

Examples :

Input: arr[] = [10, 5, 20, 40], queries = [ [1, 0, 1, 10], [2], [1, 1, 3, 20], [1, 2, 2, 30], [2] ]
Output: 20 15 20 40
              20 35 70 60

Explanation:  [1, 0, 1, 10]: Adds 10 to arr[0] and arr[1].
             Array becomes [20, 15, 20, 40].

(2): Prints the array: 20 15 20 40.
[1, 1, 3, 20)]: Adds 20 to arr[1], arr[2], and arr[3].
 Array becomes [20, 35, 40, 60].
[1, 2, 2, 30]: Adds 30 to arr[2].
 Array becomes [20, 35, 70, 60].
(2): Prints the array: 20 35 70 60.*/
public class RangeUpdateQueries {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 20, 40 };
        /// ////////10, -5, 15, 20

        int[][] queries = { { 1, 0, 1, 10 },
                { 2 },
                { 1, 1, 3, 20 },
                { 1, 2, 2, 30 },
                { 2 } };
        for(int subQueries[] : queries){
        if(subQueries[0]==1){
            int l = subQueries[1];
            int r = subQueries[2];
            int x = subQueries[3];
            processQueries(arr, l, r, x);
        }
        else System.out.println(Arrays.toString(arr));

        }
    }

    private static void processQueries(int[] arr, int l, int r, int x) {
        //create difference array from given array
        int[] diffArr = new int[arr.length+1];
        diffArr[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            diffArr[i]=arr[i]-arr[i-1]; //{10, -5, 15, 20, 0}
        }
        //mark query start and end update in diffArr
        diffArr[l] += x;
        diffArr[r+1] -=x;
        // {10, 15, 15, 20, -20}

        //calculate prefixSum of diffArr to rebuild original array but now including with range updates
        arr[0]=diffArr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = diffArr[i] + arr[i-1];
        }
        //arr {10, 25, 40, 60}
    }
}
