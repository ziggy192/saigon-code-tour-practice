package com.ziggy192;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// doc deo ky de, cai gi if truoc if sau cungx deo biet

public class IndiaJones {
    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner("6 3\n" +
//                "1 2 3 4 3 1");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            if (!queue.contains(value)) {

                if (queue.size() >= m) {

                    queue.remove();
                    count++;
                }
                queue.add(value);

            }
        }
        System.out.println(count);
    }

}
