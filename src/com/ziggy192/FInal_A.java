package com.ziggy192;

import java.util.Scanner;

public class FInal_A {

	public static void main(String[] args) {
		// write your code here
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner("5\n" +
//				"Di Nam 5\n" +
//				"Co 7 Sau\n" +
//				"Ong Noi 3\n" +
//				"Co 8 0\n" +
//				"Bac Hai 0\n");
//Scanner scanner = new Scanner("5\n" +
//				"Di Nam 5\n" +
//				"Co 7 Sau\n" +
//				"Ong Noi 3\n" +
//				"Co 8 0\n" +
//				"Bac Hai 110\n");

		run(scanner);
	}

	public static void run(Scanner scanner) {
		int n = Integer.parseInt(scanner.nextLine());
		int[] breads = new int[n];
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			String[] split = line.trim().split(" ");
			breads[i] = getNum(split[split.length - 1]);

		}

		calcPrice(breads);
	}


	public static void calcPrice(int[] breads) {
		int countBreads = 0;
		for (int i = 0; i < breads.length; i++) {
			countBreads += breads[i];
		}

		double price = 0;


		if (countBreads > 20) {
			int currBreads = countBreads;
			double i = 1;
			while (currBreads > 0) {
				int curNum = Math.min(7, currBreads);
				price = price + curNum * i;
				currBreads = currBreads - curNum;
				if (Math.round(i*10)/10.0 > 0.5) {
					i = i - 0.1d;
				}
			}

		} else {
			price = countBreads;
		}

		System.out.println(String.format("%d %.1f", countBreads, price));
	}

	public static int getNum(String string) {

		int value = 0;
		try {
			value = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			switch (string.toLowerCase()) {
				case "khong":
					value = 0;
					break;
				case "mot":
					value = 1;

					break;
				case "hai":
					value = 2;

					break;
				case "ba":
					value = 3;

					break;

				case "bon":
					value = 4;

					break;
				case "nam":
					value = 5;

					break;
				case "sau":
					value = 6;

					break;
				case "bay":
					value = 7;

					break;

				case "tam":
					value = 8;

					break;
				case "chin":
					value = 9;

					break;
				case "muoi":
					value = 10;
					break;

			}
		}


		return value;

	}


}
