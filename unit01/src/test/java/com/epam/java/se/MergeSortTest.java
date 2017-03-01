package com.epam.java.se;

import org.junit.Test;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Anton on 08.02.2017.
 */
public class MergeSortTest {
    @Test
    public void sort() throws Exception {
        MergeSort ms;
        int[] actual;
        int[] expected;

        for (int i = 1; i < 1000; i++) {
            ms = new MergeSort(i);
            actual = ms.getData();
            expected = new int[i];
            System.arraycopy(actual, 0, expected, 0, i);
            for (int j = 0; j < i; j++) {
                assertEquals(actual[j], expected[j]);
            }
            ms.sort();
            Arrays.sort(expected);
            for (int j = 0; j < i; j++) {
                assertEquals("j = " + j, expected[j], actual[j]);
            }
        }
    }

}