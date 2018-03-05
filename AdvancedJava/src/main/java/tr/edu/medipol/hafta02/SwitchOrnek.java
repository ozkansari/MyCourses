package tr.edu.medipol.hafta02;

import java.util.Scanner;

public class SwitchOrnek {

	public static void main(String args[]) {
		//char grade = args[0].charAt(0);
		// char grade = 'D';
		
		while(true) {
			System.out.println("Bir harf girin A,B,C,D ya da F");
			Scanner kullanicidanal = new Scanner(System.in);
			char grade = kullanicidanal.next().charAt(0);
			
			System.out.println("---------------------");
			System.out.println("Switch ile:");
			switchYazim(grade);
	
			System.out.println("---------------------");
			System.out.println("If-Else ile:");
			ifElseYazimi(grade);
			
			System.out.println("---------------------");
			System.out.println("Your grade is " + grade);
			
			if (grade == ' ') {
				break;
			}
		}
	}

	private static void ifElseYazimi(char grade) {
		if (grade == 'A') {
			System.out.println("Excellent!");
		} else if (grade == 'B' || grade == 'C') {
			System.out.println("Well done");
		} else if (grade == 'D' || grade == 'F') {
			if (grade == 'D') {
				System.out.println("You passed");
			}
			System.out.println("Better try again");
		} else {
			System.out.println("Invalid grade");
		}
	}
	private static void switchYazim(char grade) {
		switch (grade) {
		case 'A':
			System.out.println("Excellent!");
			break;
		case 'B':
		case 'C':
			System.out.println("Well done");
			break;
		case 'D':
			System.out.println("You passed");
		case 'F':
			System.out.println("Better try again");
			break;
		default:
			System.out.println("Invalid grade");
		}
	}
}
