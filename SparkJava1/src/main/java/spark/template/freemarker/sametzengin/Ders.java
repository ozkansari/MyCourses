package spark.template.freemarker.sametzengin;
public class Ders {
    public String dersAdi;
    public String dersId;

    public Ders(String dersAdi, String dersId){
        this.dersAdi = dersAdi;
        this.dersId = dersId;

    }
    public String dersBilgi(){
        return this.dersId + "- " + this.dersAdi;
    }
    public String dersBilgileriAl() {
        return this.dersAdi  +" - "+ this.dersId ;
    };
    public String dersBilgileriAl(boolean ekstraBilgi) {
        return "";
    }
}
