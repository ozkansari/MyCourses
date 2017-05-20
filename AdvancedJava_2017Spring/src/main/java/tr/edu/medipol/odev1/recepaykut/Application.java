package tr.edu.medipol.odev1.recepaykut;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/** ozkans Degerlendirme

Menu: 4/5 (Menude hata var)
Ogrenci Islemleri: 10/15 (Sinirsiz ogrenci girebilmeli)
Polimorphism: 0/15
Dosyadan Okuma: 20/25 (Tum bilgiler bir satirda okunuyor)
Dosyaya Yazma:  15/25 (Tum bilgiler bir satirda yaziliyor, Eklerken append yapmiyor onceki kayitlar ezilir.)
Genel Program: 10/15 (Java dosyasi olarak gonderilmeli)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 10/20
--------------------------
Sonuc: 70
 */
public class Application {
	
	private static Scanner screenReader = new Scanner(System.in);
	private static String[] students = new String[15];
	private static int i = 0;
	private static String new_record;

	public static void main(String[] args) {
		
		String str = "";
		
		try {

			FileInputStream fStream = new FileInputStream("Students.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));

			while ((str = bReader.readLine()) != null) {
				students[i] = str;
				i++;
			}
			dStream.close();
			
		} catch (Exception e) {
			
			System.err.println("Error: " + e.getMessage());
		}
		

		while (true) {
			
			screenMenu();

			System.out.println("Specify your preference:");
			
			int userChoise = InputInteger();

			if (userChoise == 1) {
				addStudent();
			}
			
			if (userChoise == 2) {
				listStudent();
			}

			if (userChoise == 3) {
				removeStudent();
			}
			if (userChoise == 4) {
				
				System.out.println("You are leaving the program.");		
				System.exit(0);
			}

		}

	}

	private static Integer InputInteger() {
		
		String userLogin = "";
		
		int entry = -1;
		
		try {
			userLogin = screenReader.nextLine();
			
			entry = Integer.valueOf(userLogin);
			
		} catch (Exception e) {
			System.out.println("Invalid sequence entered. Enter new value : "+ userLogin);
		}
		
		return entry;
	}
	
	private static void listStudent () {
		
		System.out.println("Student List/n");
		int j = 0;
		while (students[j] != null) {
			System.out.println("(" + j + ") " + students[j]);
			j++;
		}
	}

	private static void addStudent() {
		System.out.println("Enter Student Name:");
		String name = screenReader.nextLine();
		System.out.println("Enter Student Learning Type: ");
		String type = screenReader.nextLine();
		System.out.println("Enter Student Department: ");
		String department = screenReader.nextLine();
		new_record = name + " " + type + " " + department;

		FileWriter fWriter = null;
		BufferedWriter writer = null;
		
		try {
			
			fWriter = new FileWriter("Students.txt");
			writer = new BufferedWriter(fWriter);
			
			for (int i = 0; i < students.length; i++) {
				writer.write(students[i]);
				writer.newLine();
			}
			
			writer.close();
			screenMenu();
			
		} catch (Exception e) {

		}
		System.out.println("" + new_record + " " + "Student added");

	}

	private static void removeStudent() {
		
		listStudent();
		
		System.out.println("Enter the order of the student you want to delete:");
		Scanner scan = new Scanner(System.in);
		int deleted = scan.nextInt();
		int x = 0;
		while (students[x] != null) {
			x++;
		}

		for (int z = deleted; z < x; z++) {
			students[z] = students[z + 1];
		}

		FileWriter fWriter = null;
		BufferedWriter writer = null;
		
		try {
			fWriter = new FileWriter("Student.txt");
			writer = new BufferedWriter(fWriter);
			
			for (int i = 0; i < (x + 1); i++) {
				writer.write(students[i]);
				writer.newLine();
			}
			
			writer.close();
			screenMenu();
			
		} catch (Exception e) {

		}

		System.out.println("Student remove.");
	}
	
	
	
	private static void screenMenu() {
		
		System.out.println("Welcome to My Project");
		System.out.println("***/***/");
		System.out.println("Menu");
		System.out.println("(1) Add Student");
		System.out.println("(2) List Student");
		System.out.println("(3) Remove Student");
		System.out.println("(0) Exit");
		System.out.println("***/***/");
	}
	
}