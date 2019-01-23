package spark.template.freemarker.tahakeskin.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class VeriTabaniClass {
	
//---------------------VERI-TABANI-OLUSTRUMA-----------------------------	
	private static Statement veritabaniStatement;
	
	public static Statement veritabaniAyarla()  {
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			
			Connection veritabaniBaglantisi = DriverManager.getConnection(
				"jdbc:derby:"
				 + ".\\.veritabaniTK\\" 
				//+ "./.veritabaniDers7/" mac ortami icin
				+ ";create=true;"
				);
			
			veritabaniStatement = veritabaniBaglantisi.createStatement();
			
		} catch (Exception e) {
			System.out.println("Veritabani baglanti hatasi" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
		
	public static boolean tablolariOlustur() {
		
		//-------------------KULLANICILAR-TABLOSU--------------------
		try  {
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "kullanicilar ("
								+ "kullanici_adi varchar(40), "
								+ "kullanici_tipi varchar(15), "
								+ "yas int, "
								+ "cinsiyet varchar(1),"
								+ "sifre varchar(25)"
						+ ")"
			);
		} catch(Exception e) {
			System.out.println("Kullanicilar tablosu zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
		}
		
		//---------------------URUNLER-TABLOSU------------------------
		
		try  {
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "urunler ("
								+ "urun_id int primary key, "
								+ "urun_adi varchar(40),"
								+ "urun_kategori varchar(20),"
								+ "fiyat double"
							+ ")"
			);
		} catch(Exception e) {
			System.out.println("urunler tablosu zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
		}
		
		//-----------------------SIPARISLER-TABLOSU-----------------------
		
		try  {
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "siparisler ("
								+ "siparis_id int primary key, "
								+ "kullanici_adi varchar(20),"
								+ "urun_idler varchar(50),"
								+ "toplam_ucret double"
							+ ")"
			);
		} catch(Exception e) {
			System.out.println("siparisler tablosu zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
		}
		return true;
	}
	
	
//------------------------------VERI-EKLEME--------------------------------------
	
	//------------------------------KULLANICI-EKLEME----------------------------- 
	public static void kullaniciEkle(String kullanici_adi, String kullanici_tipi, int yas, 
			String cinsiyet, String sifre) {

		try  {
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( "
					+ "'" + kullanici_adi + "','"+kullanici_tipi +"'," + yas +",'"+ cinsiyet +"', '"+ sifre+"'"
					+ ")");

			System.out.println("ekleme basarýlý");
		} catch(Exception e) {
			System.out.println("Ayni isim'li kayit olusturulamaz :" + e.getMessage());
		}
	}
	
	//------------------------------URUNLER-EKLEME-----------------------------
	public static void urunEkle( String urun_adi, String urun_kategori, int fiyat) {
		
		int urun_id = urunlerfindMaxId() + 1;
		try  {
			veritabaniStatement.executeUpdate("INSERT INTO urunler VALUES ( "
					+ urun_id + " , '" + urun_adi + "' , '" + urun_kategori + "'," + fiyat
					+ ")");
				
		} catch(Exception e) {
			System.out.println("Ayni urun ad'li kayit olusturulamaz :" + e.getMessage());
		}
	}
	
	//------------------------------SIPARISLER-EKLEME-----------------------------
	public static void siparisEkle( String kullanici_adi, String urun_idler, int toplam_ucret) {
			
			int siparis_id = siparislerfindMaxId() + 1;
			try  {
				veritabaniStatement.executeUpdate("INSERT INTO siparisler VALUES ( "
						+ siparis_id + " , '" + kullanici_adi + "' , '" + urun_idler + "'," + urun_idler
						+ ")");
			} catch(Exception e) {
				System.out.println("Ayni isim'li kayit olusturulamaz :" + e.getMessage());
			}
		}
		
//--------------------------------MAXID--------------------------------------
		//--------------------------------MAXID(urunler)--------------------------------------
		public static int urunlerfindMaxId() {
			
			int maxid = 0;
			try {
				ResultSet sonuclarMaxId = veritabaniStatement.executeQuery("SELECT max(urun_id) maxid FROM urunler");
				while(sonuclarMaxId.next()) {
					maxid = sonuclarMaxId.getInt("maxid");
				}
			} catch (SQLException e) {
				System.out.println("urunler Maxid sorgu hatasi" + e.getMessage());
				e.printStackTrace();
			}
			return maxid;
		}
		//--------------------------------MAXID(siparisler)--------------------------------------
		public static int siparislerfindMaxId() {
			
			int maxid = 0;
			try {
				ResultSet sonuclarMaxId = veritabaniStatement.executeQuery("SELECT max(siparis_id) maxid FROM siparisler");
				while(sonuclarMaxId.next()) {
					maxid = sonuclarMaxId.getInt("maxid");
				}
			} catch (SQLException e) {
				System.out.println("siparisler Maxid sorgu hatasi" + e.getMessage());
				e.printStackTrace();
			}
			return maxid;
		}
		
//------------------------------VERI-SILME-kullanicilar--------------------------------------
		public static void silmetod(String kullanici_adi ) {
			try {
				veritabaniStatement.executeUpdate("DELETE FROM kullanicilar WHERE kullanici_adi ='" + kullanici_adi + "'");
				System.out.println("silindi");
			} catch (SQLException e) {
				System.out.println("veriYukle sorgu hatasi" + e.getMessage());
				e.printStackTrace();
			}
		}
		
//--------------------------------SORGULAR-----------------------------------
		//---------------------------------------KullanciSorgula-----------------------------------------------
		 public static Kullanici kullaniciSorgula(String kullaniciAdi) {
				
				try  {
					ResultSet sonuclar = veritabaniStatement.executeQuery(
							"SELECT * FROM kullanicilar WHERE kullanici_adi = '" + kullaniciAdi + "'"
					);
					while(sonuclar.next()) {
						String kullaniciTipi = sonuclar.getString("kullanici_tipi");
						int yas = sonuclar.getInt("yas");
						String cinsiyet = sonuclar.getString("cinsiyet");
						String sifre = sonuclar.getString("sifre");
						return new Kullanici(kullaniciAdi, kullaniciTipi, yas, cinsiyet, sifre);
					}
				} catch(Exception e) {
					System.out.println("Kullanici sorgu hata" + e.getMessage());
				}
				return null;
			}
		
	
		//---------------------------------------urunlerSýralama-----------------------------------------------
		 public static List<String> urunListesi = new ArrayList<>();
		
		 
		 public static void urunlerSýralama() {
				
				try  {
					ResultSet sonuclar = veritabaniStatement.executeQuery(
							"SELECT * FROM urunler ");
					urunListesi.clear();
					while(sonuclar.next()) {
						
						String urun = sonuclar.getString("urun_adi");
						String kategori = sonuclar.getString("urun_kategori");
						String fiyat = sonuclar.getString("fiyat");
						
						urunListesi.add(urun +" " + kategori +" "+ fiyat);
					}
				} catch(Exception e) {
					System.out.println("Kullanici sorgu hata" + e.getMessage());
				}
			}
				
		//---------------------kullaniciSirala---------------------------------
		 public static List<String> kullaniciListesi = new ArrayList<>();
		
		 
		 public static void kullaniciSýralama() {
				
				try  {
					ResultSet sonuclar = veritabaniStatement.executeQuery(
							"SELECT kullanici_adi FROM kullanicilar ");
					kullaniciListesi.clear();
					while(sonuclar.next()) {
						
						String kullaniciAdi = sonuclar.getString("kullanici_adi");
						
						kullaniciListesi.add(kullaniciAdi);
					}
				} catch(Exception e) {
					System.out.println("Kullanici sorgu hata" + e.getMessage());
				}
			}
		 
		//---------------------siparisSirala---------------------------------
		 public static List<String> siparisListesi = new ArrayList<>();
		 
		 public static void siparisSýralama() {
				
				try  {
					ResultSet sonuclar = veritabaniStatement.executeQuery(
							"SELECT siparis_id, kullanici_adi FROM siparisler ");
					siparisListesi.clear();
					while(sonuclar.next()) {
						
						String kullaniciAdi = sonuclar.getString("kullanici_adi");
						String siparisno = sonuclar.getString("siparisListesi");
						
						siparisListesi.add(kullaniciAdi + " " + siparisno);
					}
				} catch(Exception e) {
					System.out.println("Kullanici sorgu hata" + e.getMessage());
				}
			}
				
}
