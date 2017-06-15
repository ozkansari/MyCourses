package spark.template.freemarker.huseyinsirtikara;

public class Ders {
    public String ders;

    public Ders(String ders) {
        this.ders = ders;
    }
    public String dersBilgi(){
        return "DERS :"+ this.ders;
    }

}
