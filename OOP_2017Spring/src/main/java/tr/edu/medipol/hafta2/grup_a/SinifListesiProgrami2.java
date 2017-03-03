package tr.edu.medipol.hafta2.grup_a;

import tr.edu.medipol.hafta2.grup_a.veritipi.Ogrenci;

public class SinifListesiProgrami2 {
	public static void main(String[] args) {
		Ogrenci talha = new Ogrenci(32432, "Talha", "Karakaya");

		Ogrenci beyzanur = new Ogrenci(21312, "Beyzanur", "Yilmaz");
		
		Ogrenci [] ogrenciListesi = new Ogrenci [3];
		ogrenciListesi[0] = talha;
		ogrenciListesi[1] = beyzanur;
		ogrenciListesi[2] = new Ogrenci(21321, "Caner", "Ucar");
		
		for (int i = 0; i < ogrenciListesi.length; i++) {
			Ogrenci ogrenci = ogrenciListesi[i];
			System.out.println(ogrenci.ogrenciIsminiVer());
		}

	}
}
