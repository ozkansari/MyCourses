package tr.edu.medipol.ilerijava.ders01.ornek2;

public class Teacher extends Person {

	public Teacher(String name) {
		super(name);
	}

	@Override
	public String info() {
		return "Ogretmen : " + " - " +  getName();
	}

}
