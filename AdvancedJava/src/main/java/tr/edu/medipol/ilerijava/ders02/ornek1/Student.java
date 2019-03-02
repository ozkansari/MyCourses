package tr.edu.medipol.ilerijava.ders02.ornek1;

public class Student extends Person {

	private static int LAST_STUDENT_NUMBER = 2019010001;
	
	private Integer no;
	private String department;
	
	public Student(String firstName, String lastName) {
		super(firstName + " " + lastName);
		no = LAST_STUDENT_NUMBER++;
		department = "MYO Bilgisayar Programciligi";
	}
	
	public String info() {
		return "Ogrenci : " + no + " - " + department + " - " +  getName();
	}
}
