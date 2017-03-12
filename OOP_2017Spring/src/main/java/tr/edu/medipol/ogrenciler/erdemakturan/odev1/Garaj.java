package tr.edu.medipol.ogrenciler.erdemakturan.odev1;

public class Garaj {

	public static void main(String[] args) {

		Araba araba1 = new Araba(2001, 40000, "kartal");
		Araba araba2 = new Araba(2015, 500000, "corveete");
		Araba araba3 = new Araba(2012, 45000, "f�at");
		Araba araba4 = new Araba(2012, 800000, "pagan�");
		Araba araba5 = new Araba(2025, 1500000, "bugatt�");
		Araba araba6 = new Araba(2050, 456000, "aud� a8");
		Araba araba7 = new Araba(2011, 800000, "chelovet m4");

		System.out.println(
				"Araba MODEL:" + araba1.markaAlimi() + "Model:" + araba1.modelAlimi() + "�cret:" + araba1.ucretAlimi());
		System.out.println(
				"Araba MODEL:" + araba2.markaAlimi() + "Model:" + araba2.modelAlimi() + "�cret:" + araba2.ucretAlimi());
		System.out.println(
				"Araba MODEL:" + araba3.markaAlimi() + "Model:" + araba3.modelAlimi() + "�cret:" + araba3.ucretAlimi());
		System.out.println(
				"Araba MODEL:" + araba4.markaAlimi() + "Model:" + araba4.modelAlimi() + "�cret:" + araba4.ucretAlimi());
		System.out.println(
				"Araba MODEL:" + araba5.markaAlimi() + "Model:" + araba5.modelAlimi() + "�cret:" + araba5.ucretAlimi());
		System.out.println(
				"Araba MODEL:" + araba6.markaAlimi() + "Model:" + araba6.modelAlimi() + "�cret:" + araba6.ucretAlimi());
		System.out.println(
				"Araba MODEL:" + araba7.markaAlimi() + "Model:" + araba7.modelAlimi() + "�cret:" + araba7.ucretAlimi());

	}
}
