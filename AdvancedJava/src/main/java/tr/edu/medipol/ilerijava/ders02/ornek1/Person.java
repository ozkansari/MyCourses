package tr.edu.medipol.ilerijava.ders02.ornek1;

public abstract class Person {

	protected String name;
	
	public abstract String info();
	
	public Person(String name) {
		this.name = name;
	}
}
