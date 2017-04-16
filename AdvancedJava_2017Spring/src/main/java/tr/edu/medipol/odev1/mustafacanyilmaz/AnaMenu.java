package tr.edu.medipol.odev1.mustafacanyilmaz;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

Menu: 5/5
Ogrenci Islemleri: 10/15 (Sinirsiz ogrenci girebilmeli)
Polimorphism: 15/15
Dosyadan Okuma: 0/25
Dosyaya Yazma:  25/25
Genel Program: 15/15
Derste Yapýlan Ornegi farklilastirma/Eklentiler: Bonus 20/20

 */

public class AnaMenu {
	public static int ogrenciGirmeSayim;
	public static String [] denemeListe;
	public static ArrayList<String> list = new ArrayList<>();
	public static int kacAdetOgrenciGireceksin;
	public static String gir;
    public static List<Ogrenci> ogrenciListesi = new ArrayList<>();
    public static Scanner verileriAl = new Scanner(System.in);
	
    // ozkans Bu kontrolu yapmanin cok manasi yok
    public  static void DosyaKontrol() {
		String dosyaminYolu = ".\\Dosyam\\Verilerim.txt";
		File veriDosyasi = new File(dosyaminYolu);
		System.out.println("Dosya Dizini  = " + veriDosyasi.getAbsolutePath());
		if(veriDosyasi.exists()){
			System.out.println("Dosya Kontrolü Yapýldý, Dosya Yazýlmaya Hazýr. DOSYA ADI  = " + veriDosyasi.getName());
		}else{
			System.out.println("Dosya YOK ! ");
		}
    }
    

	public static void DosyayaYaz(ArrayList<String> list){
		String dosyaminYolu = ".\\Dosyam\\Verilerim.txt";
		File veriDosyasi = new File(dosyaminYolu);
		try {
				for(int i = 0; i<list.size(); i++){
					BufferedWriter yazici = new BufferedWriter(new FileWriter (veriDosyasi));
					for (String a : list) {
						yazici.write(a);
						yazici.newLine();
						
					}
					//i++;
					yazici.close();	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) throws FileNotFoundException {
    	DosyaKontrol();
    	//gidilecekYer:
        while(true) {
            ekranaMenuyuBas();
            System.out.println("Lütfen Bir Seçim Yapýnýz  : ");
            Scanner kullanicininGirdigiDegerAl = new Scanner(System.in);
            int kullanicininGirdigiDeger = kullanicininGirdigiDegerAl.nextInt();
            System.out.println(kullanicininGirdigiDeger + ". Menüyü Seçtiniz");
            
            if(kullanicininGirdigiDeger == 1){
            	System.out.println("Kaç adet ogrenci gireceksiniz ? "); // ozkans sinirsiz ogrenci girebilmeli
				Scanner ogrenciGirmeSayimiAl = new Scanner(System.in);
				
				ogrenciGirmeSayim = ogrenciGirmeSayimiAl.nextInt();
				denemeListe = new String[ogrenciGirmeSayim];
				
				for(int i =0; i<denemeListe.length; i++){
					System.out.println(i+1+ ". Öðrenciyi Giriniz ");
					Scanner ogrenciAdiGireniAl = new Scanner(System.in);
					String [] denemeListe2 = new String[ogrenciGirmeSayim];
					denemeListe2[i] = ogrenciAdiGireniAl.nextLine();
					System.out.print("Ogrenci Tip Giriniz ( YL  yada Doktora Giriniz) : "); //
			        String ogrenciTipi = verileriAl.nextLine();

			        System.out.print("Ogrenci Bolum Giriniz (Eczacýlýk, Hemþirelik Vb. Giriniz ) : ");
			        String bolum = verileriAl.nextLine();
			        
			        Ogrenci yeniOgrenci = null;
			        if (ogrenciTipi.equals("YL")) {
			            yeniOgrenci = new YuksekLisansOgrencisi("Mustafa", denemeListe2[i], bolum);
			        } 
			        else if (ogrenciTipi.equals("yl")) {
			            yeniOgrenci = new YuksekLisansOgrencisi("Mustafa", denemeListe2[i], bolum);
			        } 
			        else if (ogrenciTipi.equals("DOKTORA")) {
			            yeniOgrenci = new DoktoraOgrencisi(denemeListe2[i], bolum);
			        }
			        else if (ogrenciTipi.equals("Doktora")) {
			            yeniOgrenci = new DoktoraOgrencisi(denemeListe2[i], bolum);
			        }
			        if (yeniOgrenci != null) {
			            ogrenciListesi.add(yeniOgrenci);
			            System.out.println(denemeListe2[i] + " isimli ogrenci eklendi.");
			        } else {
			            System.out.println("Lütfen Büyük Küçük Harfe Duyarlý Giriþ Yapýnýz");
			        }
			        
			    	   list.add(i+1 + ". Öðrencinin Adý : " +  denemeListe2[i] +  " Ögrencinin Tipi : " + ogrenciTipi + " Öðrencinin Bölümü : " + bolum);
			    	   
				}
				System.out.println("Tebrikler Listeye Baþarýyla Öðrenci Eklediniz ");
				DosyayaYaz(list);
 
            }
            else if(kullanicininGirdigiDeger == 2){
            	OgrencileriListele();
				System.out.println("Silmek Ýstediðiniz Öðrencinin Satýrýný (Kopyalayýp) Giriniz");	
				Scanner silinecekOgrenciAdiAl = new Scanner(System.in);
				String silinecekOgrenciAdi = silinecekOgrenciAdiAl.nextLine();
				DosyadanSil(list , silinecekOgrenciAdi);
            }
     
            else if(kullanicininGirdigiDeger == 3){
            	OgrencileriListele();
            }  
            else if(kullanicininGirdigiDeger == 4){
            	/* 			
				System.out.println("Çýkmak Ýstediðinize Emin Misiniz ? ( Y ) / ( N ) ");
				Scanner girilenYesOrNoAlma = new Scanner(System.in);
				String girilenYesOrNo = girilenYesOrNoAlma.nextLine();
				
				if(girilenYesOrNo == "Y" || girilenYesOrNo == "y" ){
					System.out.println("Çýktýnýz");
					System.exit(0);
				}
				else if (girilenYesOrNo == "N" || girilenYesOrNo == "n" ){
					System.out.println("Tekrar Hoþgeldiniz :) ");
					continue gidilecekYer;
				}*/
				  
            	System.out.println("Çýkýþ Baþarýlý");
            	System.exit(0);
            }
            else{
            	System.out.println("Yanlýþ Bir Deðer Girdiniz, Tekrar Deneyiniz ");
            }
        }
    }
    public static void OgrencileriListele() throws FileNotFoundException{
		String dosyaminYolu = ".\\Dosyam\\Verilerim.txt";
		File veriDosyasi = new File(dosyaminYolu);
		Scanner fileScanner = new Scanner(veriDosyasi);
		System.out.println("Öðrenci Listenizdeki Öðrenciler Sýrasýyla");
		while(fileScanner.hasNextLine()){
			System.out.println(fileScanner.nextLine());
			/*
			for(int i =0; i<denemeListe.length; i++){
				//System.out.println(i+1+  ". Öðrenci  = "+ fileScanner.nextLine());
			}
			*/
		}
	}
    
    public static void DosyadanSil(ArrayList<String> list, String silinecekVeri){
		System.out.println("Silinmeden Önceki Dosyanýn Durumu : \n" + list);
		for(int i = 0; i<list.size(); i++){
			if(list.get(i).equals(silinecekVeri)){
				list.remove(i);
				DosyayaYaz(list);
			}	
		}
		System.out.println("Silindikten Sonraki Dosyanýn Durumu \n" + list);
	}
    
    private static void ekranaMenuyuBas() {
        System.out.println("-----------------------");
        System.out.println("MENU");
        System.out.println("(1) Ogrenci Ekle");
        System.out.println("(2) Ogrenci Sil");
        System.out.println("(3) Ogrencileri Listele");
        System.out.println("(4) Cikis");
        System.out.println("-----------------------");
    }
}
