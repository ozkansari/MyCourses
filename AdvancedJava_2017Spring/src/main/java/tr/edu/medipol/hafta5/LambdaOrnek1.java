package tr.edu.medipol.hafta5;

interface IFunction {
	int op(int a, int b);
}

// IFunction'i implement eden bir sinif tanimi
class FunctionImpl implements IFunction {
	@Override
	public int op(int a, int b) {
		return (int) Math.pow(a, b);
	}
}

public class LambdaOrnek1 {

	public static void main(String[] args) {

		// Normal sinif kullanimi
		FunctionImpl powerOp0 = new FunctionImpl();
		System.out.println(powerOp0.op(2, 3));
		
		// Anonim sinif kullanimi
		IFunction powerOp1 = new IFunction() {
			@Override
			public int op(int a, int b) {
				return (int) Math.pow(a, b);
			}
		};
		System.out.println(powerOp1.op(2, 3));
		
		// Lambda ifadesi kullanimi
		IFunction powerOp = (a, b) -> (int) Math.pow(a, b);
		System.out.println(powerOp.op(2, 3));

	}

}


