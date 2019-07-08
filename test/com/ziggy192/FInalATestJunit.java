package com.ziggy192;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class FInalATestJunit {

	@Test
	void test1() {
		Scanner scanner = new Scanner("\"5\\n\" +\n" +
				"\t\t\t\t\"Di Nam 5\\n\" +\n" +
				"\t\t\t\t\"Co 7 Sau\\n\" +\n" +
				"\t\t\t\t\"Ong Noi 3\\n\" +\n" +
				"\t\t\t\t\"Co 8 0\\n\" +\n" +
				"\t\t\t\t\"Bac Hai 0\\n\"");
		FInal_A.run(scanner);

	}
}