package tr.edu.medipol.ilerijava.ders02.ornek1;

public class Teacher extends Person {

	public Teacher(String name) {
		super(name);
	}

	@Override
	public String info() {
		return "Ogretmen : " + " - " +  getName();
	}

}
