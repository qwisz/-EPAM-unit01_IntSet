package com.epam.java.se;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Anton on 06.02.2017.
 */
public class BinarySearchTest {
    @Test
    public void search() throws Exception {
        BinarySearch bs1 = new BinarySearch(1, 2, 3, 4, 6, 7, 8);
        BinarySearch bs2 = new BinarySearch(-5, -4, -1, 0, 3, 5, 9);

        assertEquals(2, bs1.search(3));
        assertEquals(3, bs1.search(4));
        assertEquals(5, bs1.search(7));
        assertEquals(0, bs1.search(1));
        assertEquals(-1, bs1.search(-1));
        assertEquals(-1, bs1.search(0));
        assertEquals(-5, bs1.search(5));
        assertEquals(-8, bs1.search(10));

        assertEquals(0, bs2.search(-5));
        assertEquals(-3, bs2.search(-3));
        assertEquals(3, bs2.search(0));
        assertEquals(2, bs2.search(-1));
        assertEquals(-7, bs2.search(7));
    }

    @Test
    public void recSearch() throws Exception {
        BinarySearch bs1 = new BinarySearch(1, 2, 3, 4, 6, 7, 8);
        BinarySearch bs2 = new BinarySearch(-5, -4, -1, 0, 3, 5, 9);

        assertEquals(2, bs1.recSearch(3));
        assertEquals(3, bs1.recSearch(4));
        assertEquals(5, bs1.recSearch(7));
        assertEquals(0, bs1.recSearch(1));
        assertEquals(-1, bs1.recSearch(-1));
        assertEquals(-8, bs1.recSearch(10));
        assertEquals(-1, bs1.recSearch(0));
        assertEquals(-5, bs1.recSearch(5));

        assertEquals(0, bs2.recSearch(-5));
        assertEquals(-3, bs2.recSearch(-3));
        assertEquals(-1, bs2.recSearch(-6));
        assertEquals(3, bs2.recSearch(0));
        assertEquals(2, bs2.recSearch(-1));
        assertEquals(-7, bs2.recSearch(7));
        assertEquals(-8, bs2.recSearch(10));
    }

}