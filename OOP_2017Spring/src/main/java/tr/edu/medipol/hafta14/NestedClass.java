package tr.edu.medipol.hafta14;

// http://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
public class NestedClass {

    private static int ORTAK_DEGER = 1;
    
    // Java'da 4 Tip 'Nested Sinif' Vardir:
    // 1-) Static Sinif
    // 2-) Ic (Inner) Sinif
    // 3-) Yerel Ic (Inner) Sinif
    // 4-) Ananom Ic (Inner) Sinif
    
    // tr.edu.medipol.hafta14.NestedClass.StaticClass
    // --> public ise bu sekilde diger siniflardan erisilebilir
    public static class StaticClass {
        // icinde bulundugu sinifin static elemanlarina erisebilir
        public int someMethod(){
            return ORTAK_DEGER;
        }
    }
    
    public class InnerClass {
        
    }
    
    public static void main(String[] args) {
        
        class LocalInnerClass {
            
        }
    }
}
