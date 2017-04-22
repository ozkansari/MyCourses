package tr.edu.medipol.odev2.g2.beyzaodeyen;


public class Ogrenci {
	private String name;
	private String type;
	private String department;

	public Ogrenci(String name, String type, String department) {
		this.name = name;
		this.type = type;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String toString() {
		return this.name + " - " + this.type + " - " + this.department;
	}
}
