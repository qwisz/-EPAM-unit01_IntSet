package com.epam.java.se;

/**
 * Created by Anton on 05.02.2017.
 */
public class IntSet {

    private long[] dataPositive;
    private long[] dataNegative;
    private int sizePositive;
    private int sizeNegative;

    public IntSet() {
        this(new long[1], new long[1], 1, 1);
    }

    private IntSet(long[] dataPositive, long[] dataNegative, int sizePositive, int sizeNegative) {
        this.dataPositive = dataPositive;
        this.dataNegative = dataNegative;
        this.sizePositive = sizePositive;
        this.sizeNegative = sizeNegative;
    }

    public long[] getDataPositive() {
        long[] getArray = new long[dataPositive.length];
        System.arraycopy(dataPositive, 0, getArray, 0, dataPositive.length);
        return getArray;
    }

    public long[] getDataNegative() {
        long[] getArray = new long[dataPositive.length];
        System.arraycopy(dataNegative, 0, getArray, 0, dataNegative.length);
        return getArray;
    }

    public int getSizePositive() {
        return sizePositive;
    }

    public int getSizeNegative() {
        return sizeNegative;
    }

    public void add(int value) {
        if (value >= 0) {
            addPositiveNumber(value);
        }
        else {
            addNegativeNumber(value);
        }
    }

    public void remove(int value) {
        if (value >= 0) {
            removePositiveNumber(value);
        } else {
            removeNegativeNumber(value);
        }
    }

    public boolean contains(int value) {
        boolean result = false;
        if (value >= 0) {
            long mask = 1L << value;
            int indexOfValue = getIndexOfValue(value);
            if (indexOfValue > sizePositive - 1)
                return false;
            result = (dataPositive[indexOfValue] & mask) != 0;
        }
        else {
            long mask = 1L << value;
            int indexOfValue = getIndexOfValue(value);
            if (indexOfValue > sizeNegative - 1)
                return false;
            result = (dataNegative[indexOfValue] & mask) != 0;
        }
        return result;
    }

    public IntSet union(IntSet other) {
        int resultSizePos = Math.max(other.getSizePositive(),this.sizePositive);
        int resultSizeNeg = Math.max(other.getSizeNegative(),this.sizeNegative);

        long[] resultDataPos = new long[resultSizePos];
        long[] resultDataNeg = new long[resultSizeNeg];

        int minSizePos = Math.min(other.getSizePositive(),this.sizePositive);
        int minSizeNeg = Math.min(other.getSizeNegative(),this.sizeNegative);

        for (int i = 0; i < minSizePos; i++) {
            resultDataPos[i] = this.getDataPositive()[i] | other.getDataPositive()[i];
        }

        for (int i = 0; i < minSizeNeg; i++) {
            resultDataNeg[i] = this.getDataNegative()[i] | other.getDataNegative()[i];
        }

        if (other.getSizePositive() >= this.getSizePositive()) {
            for (int i = minSizePos; i < resultSizePos; i++) {
                resultDataPos[i] = other.getDataPositive()[i];
            }
        } else {
            for (int i = minSizePos; i < resultSizePos; i++) {
                resultDataPos[i] = this.getDataPositive()[i];
            }
        }

        if (other.getSizeNegative() >= this.getSizeNegative()) {
            for (int i = minSizeNeg; i < resultSizeNeg; i++) {
                resultDataNeg[i] = other.getDataNegative()[i];
            }
        } else {
            for (int i = minSizeNeg; i < resultSizeNeg; i++) {
                resultDataNeg[i] = this.getDataNegative()[i];
            }
        }

        return new IntSet(resultDataPos, resultDataNeg, resultSizePos, resultSizeNeg);
    }

    public IntSet intersect(IntSet other) {
        int resultSizePos = Math.min(other.getSizePositive(),this.sizePositive);
        int resultSizeNeg = Math.min(other.getSizeNegative(),this.sizeNegative);

        long[] resultDataPos = new long[resultSizePos];
        long[] resultDataNeg = new long[resultSizeNeg];

        for (int i = 0; i < resultSizePos; i++) {
            resultDataPos[i] = other.getDataPositive()[i] & this.getDataPositive()[i];
        }

        for (int i = 0; i < resultSizeNeg; i++) {
            resultDataNeg[i] = other.getDataNegative()[i] & this.getDataNegative()[i];
        }

        return new IntSet(resultDataPos, resultDataNeg, resultSizePos, resultSizeNeg);
    }

    public IntSet difference(IntSet other) {
        int resultSizePos = this.sizePositive;
        int resultSizeNeg = this.sizeNegative;

        long[] resultDataPos = dataPositive;
        long[] resultDataNeg = dataNegative;

        int minSizePos = Math.min(other.getSizePositive(),this.sizePositive);
        int minSizeNeg = Math.min(other.getSizeNegative(),this.sizeNegative);

        for (int i = 0; i < minSizePos; i++) {
            resultDataPos[i] = this.dataPositive[i] & (~other.getDataPositive()[i]);
        }

        for (int i = 0; i < minSizeNeg; i++) {
            resultDataNeg[i] = this.dataNegative[i] & (~other.getDataNegative()[i]);
        }

        return new IntSet(resultDataPos, resultDataNeg, resultSizePos, resultSizeNeg);
    }

    public boolean isSubsetOf(IntSet other) {

        int resultSizePos = other.getSizePositive();
        int resultSizeNeg = other.getSizeNegative();

        if (resultSizeNeg > this.sizeNegative || resultSizePos > this.sizePositive)
            return false;

        long[] resultDataPos = other.getDataPositive();
        long[] resultDataNeg = other.getDataNegative();

        for (int i = 0; i < resultSizePos; i++) {
            resultDataPos[i] = other.getDataPositive()[i] & (~this.getDataPositive()[i]);
            if (resultDataPos[i] != 0)
                return false;
        }

        for (int i = 0; i < resultSizeNeg; i++) {
            resultDataNeg[i] = other.getDataNegative()[i] & (~this.getDataNegative()[i]);
            if (resultDataNeg[i] != 0)
                return false;
        }
        return true;
    }

    private void addPositiveNumber(int value) {
        int insertIndex = getIndexOfValue(value);
        if (insertIndex > sizePositive - 1) {
            dataPositive = createNewData(dataPositive, sizePositive, insertIndex + 1);
            sizePositive = dataPositive.length;
        }
        dataPositive[insertIndex] |= 1L << value;
    }

    private void addNegativeNumber(int value) {
        int insertIndex = getIndexOfValue(value);
        if (insertIndex > sizeNegative - 1) {
            dataNegative = createNewData(dataNegative, sizeNegative, insertIndex + 1);
            sizeNegative = dataNegative.length;
        }
        dataNegative[insertIndex] |= 1L << value;
    }

    private void removePositiveNumber(int value) {
        int indexOfValue = getIndexOfValue(value);
        if (indexOfValue > sizePositive - 1)
            return;
        dataPositive[indexOfValue] &= ~(1L << value);
    }

    private void removeNegativeNumber(int value) {
        int indexOfValue = getIndexOfValue(value);
        if (indexOfValue > sizeNegative - 1)
            return;
        dataNegative[indexOfValue] &= ~(1L << value);
    }

    private int getIndexOfValue(int value) {
        return Math.abs(value / 64);
    }

    private long[] createNewData(long[] data, int oldSize, int newSize) {
        long[] newData = new long[newSize];
        System.arraycopy(data, 0, newData, 0, oldSize);
        return newData;
    }
}
