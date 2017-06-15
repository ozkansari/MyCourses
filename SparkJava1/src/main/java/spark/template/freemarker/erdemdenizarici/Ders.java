package spark.template.freemarker.erdemdenizarici;

public class Ders {
	public String dersAdi;
    public String bolum;
    public String dersNo;
    public String dersTipi;

    public Ders(String dersAdi,
                   String dersTipi,
                   String bolum,
                   String dersNo){
        this.dersAdi = dersAdi;
        this.dersTipi = dersTipi;
        this.bolum = bolum;
        this.dersNo=dersNo;
    }

    public String dersBilgi(){
    return this.dersNo + "- " + this.dersAdi;
    }
    public String dersBilgileriAl() {
       return this.dersTipi  +" - "+ this.bolum ;
    };

    public String dersBilgileriAl(boolean ekstraBilgi) {
        return "";
    }
}
