package com.epam.java.se;

import java.util.Random;

/**
 * Created by Anton on 07.02.2017.
 */
public class MergeSort {
    private int[] data;

    public MergeSort() {
        this.data = new int[10];
        for (int i = 0; i < 10; i++) {
            this.data[i] = (int)(Math.random() * 10) - 5;
        }
    }

    public MergeSort(int size) {
        this.data = new int[size];
        for (int i = 0; i < size; i++) {
            this.data[i] = (int)(Math.random() * 10000 - 5000);
        }
    }

    public int[] getData() {
        return data;
    }

    public MergeSort(int... data) {
        this.data = data;
    }

    public void sort() {
//        mergeSortRec(this.data, 0, this.data.length, new int[this.data.length]);
        mergeSort(this.data);
    }

    private void mergeSort(int[] array) {
        int size = array.length;
        int[] free = new int[size];
        for (int i = 1; i < size; i *= 2) {
            for (int j = 0; j < size - i; j += 2 * i) {
                merge(array, j, i + j, Math.min(j + 2 * i, size), free);
            }
        }
    }

    private void merge(int[] data, int startInclusive, int mid, int endExclusive, int[] free) {
        System.arraycopy(data, startInclusive, free, startInclusive, endExclusive - startInclusive);

        int i = startInclusive;
        int j = mid;
        for (int k = startInclusive; k < endExclusive; k++)     {
            if (i >= mid) data[k] = free[j++];
            else if (j >= endExclusive) data[k] = free[i++];
            else if (free[i] < free[j]) data[k] = free[i++];
            else data[k] = free[j++];
        }
    }

    private void mergeSortRec(int[] array, int startInclusive, int endExclusive, int[] free) {
        if (startInclusive >= endExclusive - 1)
            return;
        int mid = startInclusive + (endExclusive - startInclusive) / 2;

        mergeSortRec(array, startInclusive, mid, free);
        mergeSortRec(array, mid, endExclusive, free);
        merge(array, startInclusive, mid, endExclusive, free);
    }

    public void print() {
        for (int i : this.data) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        ms.print();
        System.out.println();
        ms.sort();
        ms.print();
    }
}
