package tr.edu.medipol.ogrenciler.ismailsahin.odev3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main (String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		Scanner get = new Scanner(System.in);
		while (true) {
			System.out.println("Please enter student name:");
			String name = get.next();
			if (!(name.equals("-"))) { // !(name.equals(" ")) �eklinde de denedim ama konsoldan null? bo� de�er alamad�m...
				name=name.substring(0,1).toUpperCase()+name.substring(1);
				System.out.println("Please enter student exam:");
				int exam = get.nextInt();
				studentList.add(new Student(name, exam));
			} else {
				System.out.println("You entered an empty value...");
				for (int i = 0; i < studentList.size(); i++) {
					System.out.println((i + 1) + "." + studentList.get(i).studentName+ ": " + studentList.get(i).exam);
				}
				break;
			}
		}
	}
}
