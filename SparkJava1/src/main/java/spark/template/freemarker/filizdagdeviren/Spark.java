package spark.template.freemarker.filizdagdeviren;

public class Spark {
	public static void main(String[] args) {

		
		
	}
		static class Ogrenci {
			private String ad;
			private String bolum;
			private String tip;
			public Ogrenci(String ad, String bolum,String tip){
				this.ad =ad;
				this.bolum =bolum;
				this.tip =tip;
				
			}
		}
		
		static class Ders {
			private String ders;
			private int kredi;
			public Ders(String ders,int kredi){
				this.ders =ders;
				this.kredi =kredi;
			}
		}
		

}
