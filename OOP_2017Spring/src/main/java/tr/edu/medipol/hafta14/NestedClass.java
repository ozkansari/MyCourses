package tr.edu.medipol.hafta14;

// http://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
public class NestedClass {

    private static int ORTAK_DEGER = 1;
    
    // Java'da 4 Tip 'Nested Sinif' Vardir:
    // 1-) Static Sinif
    // 2-) Ic (Inner) Sinif
    // 3-) Yerel Ic (Inner) Sinif
    // 4-) Ananim Ic (Inner) Sinif
    
    // tr.edu.medipol.hafta14.NestedClass.StaticClass
    // --> public ise bu sekilde diger siniflardan erisilebilir
    public static class StaticClass {
        // icinde bulundugu sinifin static elemanlarina erisebilir
        public int someMethod(){
            return ORTAK_DEGER;
        }
    }
    
    private class InnerClass {
        
    }
    
    public void metod() {
    	InnerClass i = new InnerClass();
    }
    
    public static void main(String[] args) {
        
    	StaticClass x = new StaticClass();
    	
    	new NestedClass().metod();
    	
        class LocalInnerClass {
            
        }
    }
}

// Nested class disinda tanimli, public, private ya da protected olamaz
class DisSinif {
	
}
