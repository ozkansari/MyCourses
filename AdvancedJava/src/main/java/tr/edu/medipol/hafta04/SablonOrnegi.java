package tr.edu.medipol.hafta04;

import java.util.regex.*;

public class SablonOrnegi {

	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
	
	public static void main(String args[]) {

        // String mailSablonu = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        String mailSablonu = "^[a-zA-Z[öçğışü]]+@medipol.edu.tr$";
        // String mailSablonu = "^[A-Z0-9]+@[A-Z]+\\.[A-Z]+\\.[A-Z]{2,3}$";
        //String mailSablonu = "^\\w+@\\w+\\.\\w+\\.[A-Z]{2}$";
        
        // ^ Satır basi
        // $ Satir sonu
        
        Pattern sablonNesnesi = Pattern.compile(mailSablonu, Pattern.CASE_INSENSITIVE); 
        
        String mailAdresi = "mçşı@medipol.edu.tr"; // kullanicidan input
        
        Matcher eslestirici = sablonNesnesi.matcher(mailAdresi);
        boolean eslestiMi = eslestirici.find();
        
        System.out.println("EslestiMi? " + eslestiMi);
        
        if (eslestiMi) {
            System.out.println("Found:" + eslestirici.group());
        }
        
        // Yontem 2
        System.out.println("EslestiMi? " + Pattern.matches(mailSablonu, mailAdresi));
        
    }
}
