package tr.edu.medipol.ilerijava.ders02.ornek1;

import java.util.*;

public class Ders2Ornek1 {

	public static void main(String[] args) {
		// Array kullanmadik, cunku boyutu bastan bilmemiz ve newlerken belirtmemiz lazim
		// Person [] personsArray = new Person [2];
		
		List<Person> personsList = new ArrayList<>();
		Person student1 = new Student("Ihsan Ilker", "Pirinc");
		personsList.add(student1);
		Person student2 = new Student("Ahmet Mustafa", "Tavar");
		personsList.add(0, student2);
		
		for(Person p : personsList) {
			System.out.println(p.info());
		}
		
	}

}
