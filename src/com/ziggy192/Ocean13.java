package com.ziggy192;

import java.util.Scanner;

public class Ocean13 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner("10 6 5\n1 2 3 6 7 9 11 22 44 50\n3 4 10 20 40 60\n");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        scanner.nextLine();
        int[] mems = new int[n];
        for (int i = 0; i < n; i++) {
            mems[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int[] floors = new int[m];
        for (int i = 0; i < m; i++) {
            floors[i] = scanner.nextInt();
        }

        System.out.println(findMin(mems, floors, p));

    }

    private static int findMin(int[] mems, int[] floors, int p) {
        int n = mems.length;
        int m = floors.length;
        int[][][] fMin = new int[n][m][p];


        for (int k = 0; k < p; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    fMin[i][j][k] = Integer.MAX_VALUE;

                    if (i < k || j < k) {
                        continue;
                    }

                    int addingValue = 0;
                    if (i > 0) {
                        int minCur = Integer.MAX_VALUE;
                        if (j > 0 && k > 0) {
                            for (int j1 = 0; j1 <= (j - 1); j1++) {
                                if (minCur > fMin[i][j1][k - 1]) {
                                    minCur = fMin[i][j1][k - 1];
                                }
                            }

                        }
                        addingValue = Math.min(fMin[i - 1][j][k], minCur);
//                        if (addingValue > fMin[i - 1][j][k]) {
//                            addingValue = fMin[i - 1][j][k];
//                        }
                    }
                    addingValue += Math.abs(mems[i] - floors[j]);
                    fMin[i][j][k] = addingValue;

                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            if (result > fMin[n - 1][j][p - 1]) {
                result = fMin[n - 1][j][p - 1];
            }

        }
        return result;


    }

}
