package com.ziggy192;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


// sort truoc roi chay thi co sao dau, ko chiu ve ra giay xem thu, luc do dau oc chan qua
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

		List<Wrapper> wrappers = IntStream.range(0, a.length)
				.mapToObj(i -> new Wrapper(a[i], i + 1))
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		for (int i = 0; i < q; i++) {

			int l = scanner.nextInt();
			int r = scanner.nextInt();
			int k = scanner.nextInt();


			int result = calculate(wrappers, l, r , k);
			System.out.println(result);

			if (i < q - 1) {

				scanner.nextLine();
			}
		}

	}

	private static class Wrapper implements Comparable<Wrapper>{
		int value ;
		int index;

		public Wrapper(int value, int index) {
			this.value = value;
			this.index = index;
		}



		@Override
		public int compareTo(Wrapper o) {
			return this.value - o.value;
		}

	}
	private static int calculate(List<Wrapper> a, int l, int r, int k) {
		int countK = 0;
		for (Wrapper wrapper : a) {
			if (wrapper.index >= l && wrapper.index <= r) {
				countK++;
			}
			if (countK == k) {
				return wrapper.value;
			}
		}

		return -1;
	}


}
