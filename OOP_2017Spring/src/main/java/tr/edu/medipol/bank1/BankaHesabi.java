package tr.edu.medipol.bank1;

public class BankaHesabi {
	
	/**
	 * Hesap numarasi
	 */
	private int hesapNo;
	
	/**
	 * Hesapdaki bakiye
	 */
	private int bakiye;

	/**
	 * Yapilandirici (Constructor)
	 * 
	 * @param hesapNo Olusturulacak Hesap numarasi
	 * @param bakiye Hesapdaki baslangic bakiyesi
	 */
	public BankaHesabi(int hesapNo, int bakiye) {
		this.hesapNo = hesapNo;
		this.bakiye = bakiye;
	}

	/**
	 * Belirtilen miktarda para yatir
	 * 
	 * @param miktar Yatirilmak istenen para
	 */
	public void paraYatir(int miktar) {
		bakiye = bakiye + miktar;
	}

	/**
	 * Belirtilen miktarda para cek
	 * 
	 * @param miktar Cekilmek istenen para 
	 * 
	 * @throws BakiyeYetersizHatasi bakiye yetersiz ise bu hata firlatilir
	 */
	public void paraCek(int miktar) throws BakiyeYetersizHatasi {
		if (miktar > bakiye) {
			throw new BakiyeYetersizHatasi(bakiye, miktar);
		} else {
			bakiye = bakiye - miktar;
		}
	}

	/**
	 * 
	 * @return mevcut hesap numarasi
	 */
	public int getHesapNo() {
		return hesapNo;
	}

	/**
	 * 
	 * @return mevcut hesap bakiyesi
	 */
	public int getBakiye() {
		return bakiye;
	}
}
