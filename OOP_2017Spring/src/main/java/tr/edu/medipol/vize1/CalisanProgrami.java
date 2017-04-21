package tr.edu.medipol.vize1;

public class CalisanProgrami {
  public static void main(String[] args) {
    Mudur c1 = new Mudur("Ali");
    Personel c2 = new Isci("Ozkan",c1);
    System.out.println(c2.bilgi());
  }
}
class Mudur extends Personel {
  public Mudur(String ad) {
    super(ad);
  }
  @Override
  public String bilgi() {
    return "Mudur - " + getAd();
  }
}
class Isci extends Personel {
  public Isci(String ad, Mudur m) {
    super(ad, m);
  }
  @Override
  public String bilgi() {
    return "Isci - " + getAd();
  }
}
//Eksik Personel sinifini yaziniz.

abstract class Personel {
  
  private Mudur mudur;
  private String ad;

  public Personel(String ad) {
    this.ad = ad;
    this.mudur = null;
  }
  
  public Personel(String ad,Mudur mudur) {
    this.ad = ad;
    this.mudur = mudur;
  }

  protected String getAd() {
    return ad;
  }
  
  public abstract String bilgi();
}
