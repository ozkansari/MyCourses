package tr.edu.medipol.hafta6;
import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class MirasOrnegi
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    BankaHesabi yeniHesap = new MevduatHesabi();
    yeniHesap.paraYatir(500);
    yeniHesap.paraYatir(300);
    System.out.print(yeniHesap.bakiyeGoruntule());
  }
}


interface BankaHesabi {
  double bakiyeGoruntule();
  double paraYatir(double yatirilacak);
}

class MevduatHesabi implements BankaHesabi {
  
  private double bakiye;
  
  public double bakiyeGoruntule() {
    return bakiye;
  }
  
  public double paraYatir(double yatirilacak) {
    bakiye += yatirilacak;
    return bakiye;
  }
}

class DovizHesabi extends MevduatHesabi {
  public double bakiyeGoruntule() {
    return super.bakiyeGoruntule();
  }
}

