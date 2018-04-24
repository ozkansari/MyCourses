package tr.edu.medipol.vizeproje.burak_karatepe;
import java.io.*;
import java.util.ArrayList;

public class db {
	private static ArrayList<Yayinevi> yayinevleri = new ArrayList<Yayinevi>();
	private static ArrayList<Kitap> kitaplar = new ArrayList<Kitap>();
	private static boolean loaddata=false;
	private final String dosyayolu=".\\config\\";
	db(){
		if(!loaddata) {
			this.readYayinevi();
			this.readKitap();
		}
	}
	public ArrayList<Yayinevi> getYayinevleri() {
		return yayinevleri;
	}
	public void setYayinevleri(ArrayList<Yayinevi> yayinevleri) {
		this.yayinevleri = yayinevleri;
	}
	public ArrayList<Kitap> getKitaplar() {
		return kitaplar;
	}
	public void setKitaplar(ArrayList<Kitap> kitaplar) {
		this.kitaplar = kitaplar;
	}
	public void addKitap(Kitap k) {
		kitaplar.add(k);
	}
	public void addYayinevi(Yayinevi y) {
		yayinevleri.add(y);
	}
	void saveKitap() {
		ArrayList<String> txt=new ArrayList<String>();
		for(Kitap item:kitaplar) {
			String str = (item.getAdi()+"#;"+item.getSayfa()+"#;"+item.getYazar()+"#;"+item.getYayinevi().getEposta()+"#;\n");
			txt.add(str);
		}
		// OZKANS DUZELTME: this.yaz(txt, "kitaplar.txt");
		/* OZKANS DUZELTME: */ this.yaz(txt, "kitaplar.txt");
	}
	void readKitap() {
		// OZKANS DUZELTME: ArrayList<String> txt=this.oku("kitaplar.txt");
		/* OZKANS DUZELTME: */  ArrayList<String> txt=this.oku("kitaplar.txt");
		ArrayList<Kitap> okunanlar=new ArrayList<Kitap>();
		for(String item:txt) {
			String[] parcala=item.split("#;");
			Kitap yeni=new Kitap();
			yeni.setAdi(parcala[0]);
			yeni.setSayfa(Integer.parseInt((parcala[1])));
			yeni.setYazar(parcala[2]);
			yeni.setYayinevi(new Yayinevi());
			for(Yayinevi value : yayinevleri) {
			    if (value.getEposta().equals(parcala[3])) {
			        yeni.setYayinevi(value);
			        break;
			    }
			}
			okunanlar.add(yeni);
		}
		kitaplar=okunanlar;
	}
	void saveYayinevi() {
		ArrayList<String> txt=new ArrayList<String>();
		for(Yayinevi item:yayinevleri) {
			txt.add(item.getAd()+"#;"+item.getEposta()+"#;\n");
		}
		// OZKANS DUZELTME: this.yaz(txt, "yayinevi.txt");
		/* OZKANS DUZELTME: */ this.yaz(txt, "yayinevi.txt");
	}
	void readYayinevi() {
		this.loaddata=true;
		// OZKANS DUZELTME:  ArrayList<String> txt=this.oku("yayinevi.txt");
		/* OZKANS DUZELTME: */ ArrayList<String> txt=this.oku("yayinevi.txt");
		ArrayList<Yayinevi> okunanlar=new ArrayList<Yayinevi>();
		for(String item:txt) {
			String[] parcala=item.split("#;");
			Yayinevi yeni=new Yayinevi();
			yeni.setAd(parcala[0]);
			yeni.setEposta(parcala[1]);
			okunanlar.add(yeni);
		}
		yayinevleri=okunanlar;
	}
	private ArrayList<String> oku(String fileName) {
		ArrayList<String> icerik=new ArrayList<String>();
		 String line = null;
		 try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(dosyayolu+fileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {
	               icerik.add(line);
	            }   

	            // Always close files.
	            bufferedReader.close();   
	           
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
		return icerik;
	}
	private void yaz(ArrayList<String> veri,String fileName) {
	        try {
	            // Assume default encoding.
	            FileWriter fileWriter =
	                new FileWriter(dosyayolu+fileName);

	            // Always wrap FileWriter in BufferedWriter.
	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);

	            // Note that write() does not automatically
	            // append a newline character.
	            for(String item:veri) {
	            	  bufferedWriter.write(item);
	            }
	          
	            // Always close files.
	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error writing to file '"
	                + fileName + "'");
	            // Or we could just do this:
	            // ex.printStackTrace();
	        }
	}
}
