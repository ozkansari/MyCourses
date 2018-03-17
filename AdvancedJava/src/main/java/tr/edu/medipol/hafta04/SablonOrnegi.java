package tr.edu.medipol.hafta04;

import java.util.regex.*;

public class SablonOrnegi {

	public static void main(String args[]) {

        // String mailSablonu = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        String mailSablonu = "^[A-Z]+@medipol.edu.tr$";
        // String mailSablonu = "^[A-Z0-9]+@[A-Z]+\\.[A-Z]+\\.[A-Z]{2,3}$";
        //String mailSablonu = "^\\w+@\\w+\\.\\w+\\.[A-Z]{2}$";
        
        // ^ Satır basi
        // $ Satir sonu
        
        Pattern sablonNesnesi = Pattern.compile(mailSablonu, Pattern.CASE_INSENSITIVE); 
        
        String mailAdresi = "maltepe@medipol.edu.tr"; // kullanicidan input
        
        Matcher eslestirici = sablonNesnesi.matcher(mailAdresi);
        boolean eslestiMi = eslestirici.find();
        
        System.out.println("EslestiMi? " + eslestiMi);

        if (eslestiMi) {
            System.out.println("Found:" + eslestirici.group());
        }
    }
}
