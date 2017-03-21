package tr.edu.medipol.hafta5;

interface IX0 {
    void foo();
}

interface IX1 {
    void foo(int val);
}

interface IX2 {
    int op(int a, int b);
}

public class LambdaOrnek2 {

	public static void main(String[] args) {
		
		// PARAMETRESIZ INTERFACE
		IX0 ix0 = () -> System.out.println("foo");
        ix0.foo();

        // 1 PARAMETRELI INTERFACE
		IX1 ix1 = val -> System.out.println(val);
        ix1.foo(20);
        ix1 = a -> System.out.println(a * a);
        ix1.foo(30);
        
        // 2 PARAMETRELI INTERFACE
        IX2 ix2 = (a, b) -> (int) Math.pow(a, b);
        System.out.println(ix2.op(2, 3));
	}

}
