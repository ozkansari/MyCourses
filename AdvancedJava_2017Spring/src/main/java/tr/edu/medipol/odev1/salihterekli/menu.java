package tr.edu.medipol.odev1.salihterekli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/** ozkans Degerlendirme

Gecersiz Nurcan Karakulleoglu ile ayni.
Odevi kendisinin yaptigini soyledi.

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 0/15
Dosyadan Okuma: 20/25
Dosyaya Yazma:  20/25
Genel Program: 5/15 (txt gonderim, dizi kullanimi)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20
Benzer Kod Yazma Nedeniyle: -20
-----------------------------------
Sonuc: 45

 */
public class menu {

	private static Scanner ekranOkuyucu = new Scanner(System.in);
	private static String[] ogrenciler = new String[10];

	private static int i = 0;

	public static void main(String[] args) {
		String str = "";
		try {

			FileInputStream fStream = new FileInputStream("Ogrenciler.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(
					dStream));

			while ((str = bReader.readLine()) != null) {
				ogrenciler[i] = str;
				i++;
			}
			dStream.close();
		} catch (Exception e) {
			System.err.println("Hata: " + e.getMessage());
		}

		while (true) {
			ekranaMenuyuBas();

			System.out.print("Secim yapiniz: ");
			int kullaniciSecimi = kullaniciIntegerGirdiAl();

			if (kullaniciSecimi == 1) {
				ogrenciEkle();
			}
			if (kullaniciSecimi == 2) {
				ogrenciSil();
			}

			if (kullaniciSecimi == 3) {
				ogrenciListele();
			}
			if (kullaniciSecimi == 4) {
				System.out.println("Program sonlaniyor.");
				ekranOkuyucu.close();
				System.exit(0);
			}

		}

	}

	private static void ekranaMenuyuBas() {
		System.out.println("************************");
		System.out.println("MENU");
		System.out.println("(1) Ogrenci Ekle");
		System.out.println("(2) Ogrenci Sil");
		System.out.println("(3) Ogrencileri Listele");
		System.out.println("(0) Cikis");
		System.out.println("************************");
	}

	private static Integer kullaniciIntegerGirdiAl() {
		String kullaniciGirisi = "";
		int girdi = -1;
		try {
			kullaniciGirisi = ekranOkuyucu.nextLine();
			girdi = Integer.valueOf(kullaniciGirisi);
		} catch (Exception e) {
			System.out.println("Gecerli bir deger giriniz. Girdiginiz deger: "
					+ kullaniciGirisi);
		}
		return girdi;
	}

	private static void ogrenciListele() {
		System.out.println("��rencilerin Listesi: ");
		int j = 0;
		while (ogrenciler[j] != null) {
			System.out.println("(" + j + ") " + ogrenciler[j]);
			j++;
		}
	}

	private static void ogrenciEkle() {
		System.out.println("��rencinin Ad�n� Giriniz: ");
		String ad = ekranOkuyucu.nextLine();
		System.out.println("Ogrenci Tip Giriniz (YL, Doktora vb.): ");
		String tip = ekranOkuyucu.nextLine();
		System.out.println("Ogrenci Bolum Giriniz (MYO, Isletme vb..) ");
		String bolum = ekranOkuyucu.nextLine();
		String yeni_kayit = ad + " " + tip + " " + bolum;

		int x = 0;
		// Dizinin sonunu bulmak i�in.
		while (ogrenciler[x] != null) {
			x++;
		}
		ogrenciler[x] = yeni_kayit;

		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
			fWriter = new FileWriter("Ogrenciler.txt");
			writer = new BufferedWriter(fWriter);
			for (int i = 0; i < (x + 1); i++) {
				writer.write(ogrenciler[i]);
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {

		}
		System.out.println("��renci eklendi.");

	}

	private static void ogrenciSil() {
		ogrenciListele();
		System.out
				.println("Silmek istedi�iniz ��rencinin index numaras�n� giriniz: ");
		Scanner scan = new Scanner(System.in);
		int silinen = scan.nextInt();
		int x = 0;
		while (ogrenciler[x] != null) {
			x++;
		}

		for (int z = silinen; z < x; z++) {
			ogrenciler[z] = ogrenciler[z + 1];
		}

		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
			fWriter = new FileWriter("Ogrenciler.txt");
			writer = new BufferedWriter(fWriter);
			for (int i = 0; i < (x + 1); i++) {
				writer.write(ogrenciler[i]);
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {

		}

		System.out.println("Se�ti�iniz ��renci silindi.");
	}

}
