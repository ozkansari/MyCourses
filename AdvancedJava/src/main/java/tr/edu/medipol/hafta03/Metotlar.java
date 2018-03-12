package tr.edu.medipol.hafta03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Metotlar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char [] array = karakterBul(scanner.next(), 'c');
	}

	private static char[] karakterBul(String string, char c) {
		String sonuc = "";
		// .........
		return sonuc.toCharArray();
	}
	
	private static void delay() throws InterruptedException {
		TimeUnit.MINUTES.sleep(4);
		Thread.sleep(1000*60*4);
	}
}
