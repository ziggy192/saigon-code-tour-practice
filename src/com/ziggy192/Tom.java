package com.ziggy192;

import java.math.BigDecimal;
import java.util.Scanner;

public class Tom {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner("2\n" +
//				"6 4 5\n" +
//				"2 2\n" +
//				"1 -1\n" +
//				"6 4 4\n" +
//				"2 2\n" +
//				"1 -1");
		int tests = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < tests; i++) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			scanner.nextLine();

			int x = scanner.nextInt();
			int y = scanner.nextInt();

			scanner.nextLine();

			int dx = scanner.nextInt();
			int dy = scanner.nextInt();

			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}

			double time = calculateTime(k, m, n, new BigDecimal(x), new BigDecimal(y), new BigDecimal(dx), new BigDecimal(dy));
			System.out.println(String.format("%.6f", time));
		}

	}

	private static double calculateTime(int k, int m, int n, BigDecimal x, BigDecimal y, BigDecimal dx, BigDecimal dy) {

		int point = 0;


		BigDecimal sumTime = new BigDecimal(0);
		// TODO: 7/7/19 nextBounceBack
		// TODO: 7/7/19 x


		while (point < k) {


			BigDecimal timeX;

			if (dx.compareTo(new BigDecimal(0))<0) {
				timeX = x.divide(dx).abs();


			} else {
				timeX = new BigDecimal(m).subtract(x).divide(dx);

			}

			BigDecimal timeY;
			if (dy.compareTo(new BigDecimal(0))<0) {
				timeY = y.divide(dy).abs();

			} else {
				timeY = new BigDecimal(n).subtract(y).divide(dy);

			}

			BigDecimal nextTime;



			if (timeX.compareTo(timeY) < 0) {
				nextTime = timeX;

			} else {
				nextTime = timeY;
			}


			x = x.add(dx.multiply(nextTime));
			y = y.add(dy.multiply(nextTime));

			sumTime = sumTime.add(nextTime);
			if (timeX.compareTo(timeY) == 0) {

				point += 2;
				dx = dx.multiply(new BigDecimal(-1));
				dy = dy.multiply(new BigDecimal(-1));
			} else {

				point += 1;
				if (timeX.compareTo(timeY) < 0) {
					dx = dx.multiply(new BigDecimal(-1));

				} else {
					dy = dy.multiply(new BigDecimal(-1));
				}

			}

		}
		return sumTime.doubleValue();
	}

	private static boolean compare(double x, double y) {
		BigDecimal a = new BigDecimal(x);
		BigDecimal b = new BigDecimal(y);

		return a.compareTo(b) == 0;
	}
}
