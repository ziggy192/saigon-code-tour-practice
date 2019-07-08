package com.ziggy192;

import java.util.Scanner;

public class EndGame {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner("6 3\n" +
//				"5 2 4 1 4 2\n" +
//				"1 5 4\n" +
//				"1 4 2\n" +
//				"2 6 5");
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		scanner.nextLine();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		scanner.nextLine();

		for (int i = 0; i < q; i++) {

			int l = scanner.nextInt();
			int r = scanner.nextInt();
			int k = scanner.nextInt();


			calculate(a.clone(), l - 1, r - 1, k);

			if (i < q - 1) {

				scanner.nextLine();
			}
		}

	}

	private static void calculate(int[] a, int l, int r, int k) {

		for (int j = 0; j < k; j++) {
			int max = a[l + j];
			int m = l + j;
			for (int i = l + j; i <= r; i++) {
				if (a[i] > max) {
					max = a[i];
					m = i;
				}
			}

			int temp = a[l + j];
			a[l + j] = a[m];
			a[m] = temp;


		}

		System.out.println(a[l + k - 1]);

	}


}
