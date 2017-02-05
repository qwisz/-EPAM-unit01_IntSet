package com.epam.java.se;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Anton on 05.02.2017.
 */
public class IntSetTest {
    @Test
    public void add() throws Exception {

        final IntSet set = new IntSet();

        assertFalse(set.contains(0));

        set.add(0);

        assertTrue(set.contains(0));

        assertFalse(set.contains(15));

        set.add(15);
        set.add(15);

        assertTrue(set.contains(15));

        set.add(-1);
        assertTrue(set.contains(-1));
        set.add(64);
        assertTrue(set.contains(64));

        set.add(-232121);
        set.add(-392);
        set.add(-3312);
        assertTrue(set.contains(-232121));
        assertTrue(set.contains(-392));
        assertTrue(set.contains(-3312));
        assertFalse(set.contains(-41));
        assertFalse(set.contains(Integer.MIN_VALUE));
        set.add(Integer.MIN_VALUE);
        assertTrue(set.contains(Integer.MIN_VALUE));

        assertFalse(set.contains(3212121));
        set.add(3212121);
        assertFalse(set.contains(64392));
        set.add(64392);
        set.add(5312);
        assertTrue(set.contains(3212121));
        assertTrue(set.contains(64392));
        assertTrue(set.contains(5312));
        assertFalse(set.contains(Integer.MAX_VALUE));
        set.add(Integer.MAX_VALUE);
        assertTrue(set.contains(Integer.MAX_VALUE));
    }

    @Test
    public void remove() throws Exception {
        final IntSet set = new IntSet();
        assertFalse(set.contains(0));
        set.add(0);
        assertTrue(set.contains(0));
        set.add(0);
        set.remove(0);
        assertFalse(set.contains(0));

        assertFalse(set.contains(Integer.MIN_VALUE));
        set.add(Integer.MIN_VALUE);
        assertTrue(set.contains(Integer.MIN_VALUE));
        set.add(Integer.MIN_VALUE);
        assertTrue(set.contains(Integer.MIN_VALUE));
        set.remove(Integer.MIN_VALUE);
        assertFalse(set.contains(Integer.MIN_VALUE));

        assertFalse(set.contains(Integer.MAX_VALUE));
        set.add(Integer.MAX_VALUE);
        assertTrue(set.contains(Integer.MAX_VALUE));
        set.add(Integer.MAX_VALUE);
        set.remove(Integer.MAX_VALUE);
        assertFalse(set.contains(Integer.MAX_VALUE));

        assertFalse(set.contains(-5));
        assertFalse(set.contains(5));
        assertFalse(set.contains(155551));
        assertFalse(set.contains(-555515));
        set.add(-5);
        set.add(5);
        assertTrue(set.contains(-5));
        assertTrue(set.contains(5));
        set.add(155551);
        set.add(-555515);
        assertTrue(set.contains(155551));
        assertTrue(set.contains(-555515));
        set.remove(-5);
        set.remove(5);
        set.remove(155551);
        assertFalse(set.contains(-5));
        assertFalse(set.contains(5));
        assertFalse(set.contains(155551));
        set.remove(-555515);
        assertFalse(set.contains(-555515));
    }

    @Test
    public void contains() throws Exception {
        final IntSet set = new IntSet();
        for (int i = -2048; i < 2048; i++) {
            assertFalse(set.contains(i));
        }

        set.add(-4000);
        set.add(-3500);
        set.add(-3000);
        set.add(-2500);
        set.add(-2000);
        set.add(-1500);
        set.add(-1000);
        set.add(-500);
        set.add(0);
        set.add(500);
        set.add(1000);
        set.add(1500);
        set.add(2000);
        set.add(2500);
        set.add(3000);
        set.add(3500);
        set.add(4000);

        assertFalse(set.contains(-753));
        assertFalse(set.contains(-915313));
        assertFalse(set.contains(-318));
        assertFalse(set.contains(321313));
        assertFalse(set.contains(1337));

        for (int i = -4096; i < 4096; i++) {
            if (i % 500 == 0) {
                assertTrue(set.contains(i));
            } else {
                assertFalse("At index " + i, set.contains(i));
            }
        }
    }

    @Test
    public void union() throws Exception {
        IntSet set1 = new IntSet();
        IntSet set2 = new IntSet();

        for (int i = -50; i < 50; i++) {
            if (i % 15 == 0)
                set1.add(i);
            if (i % 20 == 0)
                set2.add(i);
        }

        IntSet set3 = new IntSet();
        set3.add(-45);
        set3.add(-40);
        set3.add(-30);
        set3.add(-20);
        set3.add(-15);
        set3.add(0);
        set3.add(15);
        set3.add(20);
        set3.add(30);
        set3.add(40);
        set3.add(45);

        IntSet res = set1.union(set2);

        assertEquals(set3.getSizeNegative(), res.getSizeNegative());
        assertEquals(set3.getSizePositive(), res.getSizePositive());
        for (int i = 0; i < res.getSizePositive(); i++) {
            assertEquals(res.getDataPositive()[i], set3.getDataPositive()[i]);
        }
        for (int i = 0; i < res.getSizeNegative(); i++) {
            assertEquals(res.getDataNegative()[i], set3.getDataNegative()[i]);
        }
    }

    @Test
    public void intersect() throws Exception {
        IntSet set1 = new IntSet();
        IntSet set2 = new IntSet();

        for (int i = 0; i < 101; i++) {
            if (i % 10 == 0)
                set1.add(i);
            if (i % 20 == 0 && i != 100)
                set2.add(i);
        }

        IntSet set3 = new IntSet();

        set3.add(0);
        set3.add(20);
        set3.add(40);
        set3.add(60);
        set3.add(80);

        IntSet res = set1.intersect(set2);

        assertEquals(set3.getSizeNegative(), res.getSizeNegative());
        assertEquals(set3.getSizePositive(), res.getSizePositive());
        for (int i = 0; i < res.getSizePositive(); i++) {
            assertEquals(res.getDataPositive()[i], set3.getDataPositive()[i]);
        }
        for (int i = 0; i < res.getSizeNegative(); i++) {
            assertEquals(res.getDataNegative()[i], set3.getDataNegative()[i]);
        }
    }

    @Test
    public void difference() throws Exception {

        IntSet set1 = new IntSet();
        IntSet set2 = new IntSet();

        for (int i = -64; i < 65; i++) {
            if (i % 8 == 0)
                set1.add(i);
            if (i % 16 == 0)
                set2.add(i);
        }

        IntSet set3 = new IntSet();
        set3.add(-56);
        set3.add(-40);
        set3.add(-24);
        set3.add(-8);
        set3.add(8);
        set3.add(24);
        set3.add(40);
        set3.add(56);

        // Так как нет уменьшения размера массивов, приходится делать так
        set3.add(64);
        set3.add(-64);
        set3.remove(64);
        set3.remove(-64);

        IntSet res = set1.difference(set2);

        assertEquals(set3.getSizeNegative(), res.getSizeNegative());
        assertEquals(set3.getSizePositive(), res.getSizePositive());
        for (int i = 0; i < res.getSizePositive(); i++) {
            assertEquals(res.getDataPositive()[i], set3.getDataPositive()[i]);
        }
        for (int i = 0; i < res.getSizeNegative(); i++) {
            assertEquals(res.getDataNegative()[i], set3.getDataNegative()[i]);
        }
    }

    @Test
    public void isSubsetOf() throws Exception {
        IntSet set1 = new IntSet();
        IntSet set2 = new IntSet();
        IntSet set3 = new IntSet();

        for (int i = -4096; i < 4097; i++) {
            if (i % 2 == 0)
                set1.add(i);
            if (i % 4 == 0)
                set2.add(i);
            if (i % 8 == 0)
                set3.add(i);
        }

        assertTrue(set1.isSubsetOf(set2));
        assertTrue(set1.isSubsetOf(set3));
        assertTrue(set2.isSubsetOf(set3));
        assertTrue(set1.isSubsetOf(set1));
        assertFalse(set2.isSubsetOf(set1));
        assertFalse(set3.isSubsetOf(set1));
        assertFalse(set3.isSubsetOf(set2));
    }

}