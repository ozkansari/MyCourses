package tr.edu.medipol.ilerijava.ders01.lab1;

public class Adres {

	private String mahalle;
	
	private String sokak;

	public Adres(String mahalle, String sokak) {
		super();
		this.mahalle = mahalle;
		this.sokak = sokak;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adres [mahalle=");
		builder.append(mahalle);
		builder.append(", sokak=");
		builder.append(sokak);
		builder.append("]");
		return builder.toString();
	}

	/*--
	@Override
	public String toString() {
		return String.format("Adres [mahalle=%s, sokak=%s]", mahalle, sokak);
	}
	*/

	
	
	
}
