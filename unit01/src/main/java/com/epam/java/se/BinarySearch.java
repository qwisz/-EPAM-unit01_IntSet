package com.epam.java.se;

/**
 * Created by Anton on 06.02.2017.
 */
public class BinarySearch {
    private int[] array;

    public BinarySearch() {
        this.array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i - 49;
        }
    }

    public BinarySearch(int... array) {
        this.array = array;
    }

    public int search(int key) {
        int left = -1;
        int right = array.length;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < key)
                left = mid;
            else
                right = mid;
        }
        System.out.println("right = " + right);
        if (right >= array.length || array[right] != key)
            return -right - 1;
        return right;
    }

    public int recSearch(int key) {
        return recSearchHelp(key, 0, array.length);
    }

    private int recSearchHelp(int key, int fromInclusive, int toExclusive) {
        int mid = fromInclusive + (toExclusive - fromInclusive) / 2;

        if (fromInclusive > toExclusive - 1)
            return -fromInclusive - 1;

        if (array[mid] < key)
            return recSearchHelp(key, mid + 1, toExclusive);
        else if (array[mid] > key)
            return recSearchHelp(key, fromInclusive, mid);
        else if (array[mid] == key)
            return mid;
        return -fromInclusive - 1;
    }
}
