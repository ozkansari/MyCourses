package tr.edu.medipol.vize1.recepsezeraydogan_atakantalay_cemhanoglu;

import java.io.IOException;

public interface DosyaIslemleri {
     void Oku(String dosyaYolu);
     void TabloEkle(String dosyaYolu) throws IOException;
     void TabloSil(String dosyayolu);

}
