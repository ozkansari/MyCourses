package tr.edu.medipol.vize1.dogankoc;

public class Personel implements Comparable<String>{

	private String id, pozisyon,ad,soyad,tc;
	public Personel(){};
	public Personel(String id,String pozisyon,String ad,String soyad,String tc){
		this.id=id;  this.pozisyon=pozisyon; this.ad=ad; this.soyad=soyad; this.tc =tc;
	}

	@Override
	public void finalize() {};
	
	
	public String getId(){
		return id;
	}
	public String getPozisyon(){
		return pozisyon;
		
	}
	public String getAd(){
		return ad;
	}
	public String getSoyad(){
		return soyad;
	}
	public String getTc(){
		return tc;
	}
	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return this.compareTo(o);
	}
}
