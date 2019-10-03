package tr.edu.medipol.ilerijava.ders01.ornek2;

public abstract class Person {

	private final String name;
	
	public abstract String info();
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/* --
	// Sadece constructor uzerinden deger vermek icin
	// setter yazmiyorum
	public void setName(String name) {
		this.name = name;
	}
	*/
}
