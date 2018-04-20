package tr.edu.medipol.vizeproje.alican_celik;
import java.io.IOException;

public interface DosyaIslemleri {
     void Oku(String dosyaYolu);
     void TabloEkle(String dosyaYolu) throws IOException;
     void TabloSil(String dosyayolu);

}
