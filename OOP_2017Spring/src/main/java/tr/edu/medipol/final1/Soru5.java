package tr.edu.medipol.final1;

abstract class Kayit<TYPE> {
  protected TYPE kayit;
  public abstract void ekranaBas();
}

public class Soru5 {
  public static void main(String[] args) {
    Kayit<String> s = new StrKayit("Defter");
    s.ekranaBas();
  }
}


class StrKayit extends Kayit<String> {
  public StrKayit(String k) {
    this.kayit = k;
  }
  public void ekranaBas() {
    System.out.println(kayit);
  }
}
