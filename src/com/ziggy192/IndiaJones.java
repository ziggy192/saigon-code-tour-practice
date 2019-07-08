package com.ziggy192;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IndiaJones {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner("6 3\n" +
//				"1 2 3 4 3 1");
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();

		int count = 0;

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			if (queue.size() < m) {
				queue.add(value);
				continue;
			}
			if (!queue.contains(value)) {
				queue.remove();
				queue.add(value);

				count++;
			}
		}
		System.out.println(count);
	}

}
