package com.ayush.Prefix_Sum;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static com.ayush.Prefix_Sum.MaxValAfterRangeIncrementOperations.findMax;
import static com.ayush.Prefix_Sum.MaxValAfterRangeIncrementOperations.findMaxOptimized;
import static org.junit.jupiter.api.Assertions.*;

public class MaxValAfterRangeIncrementOperationsTest {

    @Test
    public void Test_FindMax_Function_01(){
        int n = 5;
        int[] l = {0, 1, 2};
        int[] r = {1, 4, 3};
        // value of k to be added at each operation
        int[] k = {100, 100, 100};
        int res =  findMax(n, l, r, k);
        Assertions.assertEquals(200, res);
    }
    @Test
    public void Test_FindMax_Function_02(){
        int n = 4;
        int[] l = {1, 0, 3};
        int[] r = {2, 0, 3};
        // value of k to be added at each operation
        int[] k = {603, 286, 882};
        int res =  findMax(n, l, r, k);
        Assertions.assertEquals(882, res);
    }
    @Test
    public void Test_FindMaxOptimized_Function_01(){
        int n = 5;
        int[] l = {0, 1, 2};
        int[] r = {1, 4, 3};
        // value of k to be added at each operation
        int[] k = {100, 100, 100};
        int res =  findMaxOptimized(n, l, r, k);
        Assertions.assertEquals(200, res);
    }
    @Test
    public void Test_FindMaxOptimized_Function_02(){
        int n = 4;
        int[] l = {1, 0, 3};
        int[] r = {2, 0, 3};
        // value of k to be added at each operation
        int[] k = {603, 286, 882};
        int res =  findMaxOptimized(n, l, r, k);
        Assertions.assertEquals(882, res);
    }
}