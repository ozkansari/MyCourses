package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev3;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		List<Students> stdn = new ArrayList<Students>();
		Scanner screenReader = new Scanner(System.in);

		System.out.println("How many students will you enter?");

		int numberOfStudents = Integer.valueOf(screenReader.nextLine());

		for (int i = 0; i < numberOfStudents; i++) {

			System.out.println("Enter the student's first and last name:");
			String studentName = screenReader.nextLine();

			System.out.println("Enter the student's exam grade:");
			int studentNotes = Integer.valueOf(screenReader.nextLine());

			stdn.add(new Students(studentName, studentNotes));
		}

		for (int i = 0; i < stdn.size(); i++) {
			Students n = stdn.get(i);
			System.out.println("Student Information");
			System.out.println("______________________\n");
			System.out.println("Name Surname: " + n.studentName + "\nNote:" + n.studentNotes);
			System.out.println("\n");
		}

	}
}
