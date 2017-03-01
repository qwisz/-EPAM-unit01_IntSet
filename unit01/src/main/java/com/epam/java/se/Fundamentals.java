package com.epam.java.se;

/**
 * Created by Anton on 08.02.2017.
 */
public class Fundamentals {

    public static void main(String[] args) {
        Fundamentals fund = new Fundamentals();
//        fund.task2(20, 0.003);
//        fund.task3(-5, 5, 0.5);
//        fund.task5(7);
        int[] data = {1, 2, 3, 4, 10, 6, 8, 10};
        fund.task4(data);
    }

    public void task2(int n, double eps) {
        double[] data = new double[n];
        double result = -1.0;
        for (int i = 0; i < n; i++) {
            data[i] = 1.0 / ((i + 2) * (i + 2));
            System.out.format("%.4f ", data[i]);
            if (result == -1 && data[i] < eps)
                result = data[i];
        }
        System.out.println();
        System.out.format("result = %.4f \n", result);
    }

    public void task3(double start, double end, double step) {
        while (start <= end) {
            double result = Math.tan(2 * start) - 3;
            System.out.print(" " + start + "\t\t");
            System.out.println(result);
            start += step;
        }
    }

    public void task4(int[] data) {
        if (data.length % 2 != 0) {
            System.out.println("Коичество элементов должно быть четным");
        }
        else {
            int n = data.length / 2;
            int max = data[0] + data[2 * n - 1];
            for (int i = 1; i < n; i++) {
                int temp = data[i] + data[2 * n - i - 1];
                if (max < temp)
                    max = temp;
            }

            System.out.println("max = " + max);
        }
    }

    public void task5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || j + i + 1 == n)
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println();
        }
    }
}
