package tr.edu.medipol.hafta08.ornek4;

import java.util.ArrayList;
import java.util.List;


public class OrduUygulamasi {
    
    public static void main(String[] args) {
        
        List<Asker> askerler = new ArrayList<>();
        
        Asker er = new Er("Musa Askerovski");
        askerler.add(er);
        
        Asker albay1 = new Albay("Mehmet Albaygil");
        askerler.add(albay1);
        
        Asker yarbay1 = new Yarbay("Fikret Yarbaygil");
        askerler.add(yarbay1);

        for (Asker asker : askerler) {
            System.out.println(asker.isim());
            
            if(asker instanceof Er) { // asker degiskeni Er tipine sahip mi?
                ( (Er) asker).selamVer();
            }
        }

    }
}
