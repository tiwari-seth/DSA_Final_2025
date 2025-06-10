package com.ayush.Prefix_Sum;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/*Input: L[] = {1, 4, 3, 1}, R[] = {15, 8, 5, 4}
Output: 4

Input: L[] = {1, 5, 9, 13, 21}, R[] = {15, 8, 12, 20, 30}
Output: 5
Explanation: Numbers having maximum occurrence i.e 2 are
5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15. The smallest number among all are 5*/
public class MaxOccurringIntegerInGivenRange {
    public static void main(String[] args) {
        int[] L = {1, 4, 9, 13, 21};
        int[] R = {15, 8, 12, 20, 30};
        int n = L.length;
//        findMaxOccurringIntegerInGivenRange(L, R, n);
        int i = maximumOccurredElement(L, R, n);
        System.out.println(i);
    }

    public static int findMaxOccurringIntegerInGivenRange(int[] l, int[] r, int n) {
        Map<Integer, Integer> occurrenceMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = l[i]; j <= r[i]; j++) {
                occurrenceMap.put(j, occurrenceMap.getOrDefault(j, 0) + 1);
            }
        }
        occurrenceMap.forEach((k,v)-> System.out.println(k+","+v));
//        occurrenceMap.entrySet().stream().sorted(Map.Entry.comparingByValue());

        return 0;
    }
    static int MAX = 1000000;

    static int maximumOccurredElement(int[] L, int[] R,
                                      int n)
    {
        // Initialising all element of array to 0.
        int[] arr = new int[MAX];

        // Adding +1 at Li index and
        // subtracting 1 at Ri index.
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            arr[L[i]] += 1;
            arr[R[i] + 1] -= 1;
            if (R[i] > maxi) {
                maxi = R[i];
            }
        }

        // Finding prefix sum and index
        // having maximum prefix sum.
        int msum = arr[0];
        int ind = 0;
        for (int i = 1; i < maxi + 1; i++) {
            arr[i] += arr[i - 1];
            if (msum < arr[i]) {
                msum = arr[i];
                ind = i;
            }
        }

        return ind;
    }
}
