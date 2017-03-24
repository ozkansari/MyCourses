package tr.edu.medipol.hafta5;
interface IFonksiyon {
	int hesapla(int sayi1, int sayi2);
}
class ToplamaFonksiyonu implements IFonksiyon {
	public int hesapla(int sayi1, int sayi2) {
		return sayi1+sayi2;
	}
}
public class LambdaLabOrnek {
	public static void main(String[] args) {
		calistir(new ToplamaFonksiyonu());
		// Anonim tip tanimlama
		IFonksiyon modAlmaFonk = new IFonksiyon() {		
			public int hesapla(int sayi1, int sayi2) {
				return sayi1%sayi2;
			}
		};
		calistir(modAlmaFonk);
		// Lambda ifadesi
		IFonksiyon usAlma = (sayi1,sayi2) -> (int) Math.pow(sayi1, sayi2);
		calistir(usAlma);
	}
	public static void calistir(IFonksiyon fonk) {
		System.out.println(fonk.hesapla(4, 2));
	}
}
























