package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev1;


public class Car {
	
	public String marka;
	public String seri;
	public String model;
	public String yakit;
	public String vites;
	public String kasa;
	public String motor;
	public int yil;
	
	public Car(String mrk, String sri, String mdl, 
				String ykt, String vts, String ks, 
				String mtr, int yl) 
	{
		this.marka=mrk;
		this.seri=sri;
		this.model=mdl;
		this.yakit=ykt;
		this.vites=vts;
		this.kasa=ks;
		this.motor=mtr;
		this.yil=yl;
		
		System.out.println(marka+" Markas�nda "
		+model +" Serisinde"
		+" yeni bir araba nesnesi olu�turuldu.\n");
	}
	public String TeknikOzellikler(){
		return 	"Marka:  "+marka
				+"\nSeri: "+seri
				+"\nModel: "+model
				+"\nKasa Tipi: "+kasa
				+"\nYak�t Tipi: "+yakit
				+"\nVites: "+vites
				+"\nMotor Hacmi: "+motor	
				+"\n�retim Y�l�: "+yil+"\n";
	}

}
