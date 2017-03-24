package tr.edu.medipol.hafta5.ornek;

interface IX0 {
    void foo();
}
interface IX1 {
    void foo(int val);
}
interface IX2 {
    int op(int a, int b);
}
interface IX3 {
    int op(int a);
}
public class LambdaOrnek2 {
	public static void main(String[] args) {
		// PARAMETRESIZ INTERFACE
		IX0 ix0 = () -> System.out.println("foo");
        ix0.foo();
        // 1 PARAMETRELI INTERFACE
		IX1 ix1 = x -> System.out.println(x);
        ix1.foo(20);
        ix1 = a -> {
        	int karekok = (int) Math.sqrt(a);
        	System.out.println(karekok);
        	
        	int sonuc = a*a;
        	System.out.println(sonuc);
        };
        ix1.foo(30);
        // 2 PARAMETRELI INTERFACE
        IX2 ix2 = (a, b) -> (int) Math.pow(a, b);
        System.out.println(ix2.op(2, 3));
        
        
        IX3 ix3 = (a) -> (int) Math.sqrt(a);
        /*
        interface IX3 {
		    int op(int a);
		}
         */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
	}

}




