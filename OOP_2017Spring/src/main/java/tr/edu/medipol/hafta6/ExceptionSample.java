package tr.edu.medipol.hafta6;
import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class ExceptionSample
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    try {
    	OtherClass nesne = new OtherClass("deneme");
    } catch(NullPointerException hata) {
    	System.out.println("Kullanici hatasi olustu");
        throw new KullaniciGirisHatasi(hata);
    } catch(Exception hata) {
    	System.out.println("Bilinmeyen hata olustu olustu");
        throw hata;
    } 
  }
}

// Kendi exceptionlarimizi tanimlayabiliriz
class KullaniciGirisHatasi extends RuntimeException {
  public KullaniciGirisHatasi(Throwable hata) {
  	super(hata);
  }
}



// you can add other public classes to this editor in any order
class OtherClass
{
  private String message;
  private boolean answer = false;
  public OtherClass(String input)
  {
    message = "Why, " + input + " Isn't this something?";
    Integer x = null;
    x.toString();
  }
  
  public String toString()
  {
    return message;
  }
}
