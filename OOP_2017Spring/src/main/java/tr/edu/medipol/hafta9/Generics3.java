package tr.edu.medipol.hafta9;

public class Generics3 {

	public static void main(String[] args) {
		MesajKutusu<Integer> sayisalMesaj = new MesajKutusu<Integer>();
		MesajKutusu<String> metinMesaji = new MesajKutusu<String>();

		// T mutlaka komplex veri tipi olmali (Ornegin int degil Integer)
		sayisalMesaj.ekle(new Integer(10));
		metinMesaji.ekle(new String("Merhaba Medipol!"));

		System.out.printf("Sayisal mesaj :%d\n\n", sayisalMesaj.oku());
		System.out.printf("Metin mesaji :%s\n", metinMesaji.oku());
	}

}

class MesajKutusu<T> {
	private T mesaj;

	public void ekle(T mesaj) {
		this.mesaj = mesaj;
	}

	public T oku() {
		return mesaj;
	}
}
