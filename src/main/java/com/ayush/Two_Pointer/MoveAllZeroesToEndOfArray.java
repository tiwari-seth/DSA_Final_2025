package com.ayush.Two_Pointer;
/*Given an array of integers arr[], the task is to move all the zeros to the end of the array while maintaining
 the relative order of all non-zero elements.

Examples:

Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: arr[] = [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.

Input: arr[] = [10, 20, 30]
Output: arr[] = [10, 20, 30]
Explanation: No change in array as there are no 0s.

Input: arr[] = [0, 0]
Output: arr[] = [0, 0]
Explanation: No change in array as there are all 0s.*/
public class MoveAllZeroesToEndOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);
//        pushZerosToEndInOneTraversal(arr);

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void pushZerosToEnd(int[] arr) {
        int k=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[k]=arr[i];
                k++;
            }
        }
        for (int i = k; i < arr.length; i++) {
            arr[i]=0;
        }
    }
    private static void pushZerosToEndInOneTraversal(int[] arr) {
        int k=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i]=temp;
                k++;
            }
        }
    }
}
