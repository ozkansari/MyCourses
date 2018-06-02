package spark.template.freemarker.ismailsahin;


import java.util.HashMap;

/**
 * Siparis bilgisini ve fonskiyonlar� sa�lar..
 * @author bilgisayar
 *
 */
public class Siparis {
	int id;
	HashMap<Integer, Integer> urunList;
	String adres = "";
	
	public Siparis() {
		urunList = new HashMap<Integer, Integer>();
		System.out.println("Sipari� olu�turuldu..");
	}
	
	public void urunEkle(Kitap kitap) {
		if (urunList.containsKey(kitap.getId()) == false) {
			urunList.put(kitap.getId(), 1);
			System.out.println("Yeni kitap eklendi: " + kitap.getKitapAdi() + "\nKitap id: " + kitap.getId());
		}
		else {
			int adet = urunList.get(kitap.getId());
			urunList.put(kitap.getId(), (adet+1));
			System.out.println(kitap.getKitapAdi() + ": " + adet);
		}
	}
	
	public void urunEkle(int id) {
		if (urunList.containsKey(id) == false) {
			urunList.put(id, 1);
		}
		else {
			int adet = urunList.get(id);
			urunList.put(id, (adet+1));
		}
	}
	
	public String getKitapAdi(int id) {
		VeriTabani veriTabani = new VeriTabani();
		String kitapAdi = "";
		try {
			System.out.println("inside getKitapAdi");
			kitapAdi += veriTabani.getKitapAdi(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kitapAdi;
	}
	
	public int getAdet(int id) {
		return urunList.get(id);
	}
	
	public int getId() {
		return id;
	}
	
	public String deneme() {
		return "deneme";
	}
	
	public HashMap<Integer, Integer> getUrunList() {
		return urunList;
	}
	
	public void setUrunList(HashMap<Integer, Integer> urunlerListe) {
		this.urunList = urunlerListe;
	}
	
	public int getSize(int id) {
		return urunList.size();
	}

	
	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
	
}
