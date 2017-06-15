package spark.template.freemarker.filizdagdeviren;

public class Ders {
	public String ders;
	public int dersKredi;
	public int dersId;
		
		public Ders(String ders,
				int dersKredi, 
				int dersId
				){
			this.ders = ders;
			this.dersKredi = dersKredi;
			this.dersId = dersId;
		}
		
		public String dersBilgileriAl() {
			return this.ders + " - " + this.dersKredi;
		};
		
		public String dersBilgileriAl(boolean ekstraBilgi) {
			return "";
		}

}
