package tr.edu.medipol.odevler.aysenur_yildiz.odev1;

// Eksik import : -10
//Tum siniflarda: @Test annotation yok -20

import org.junit.Assert;
import org.junit.Test;


public class HesaplamaTest {
	@Test
	public void KareAlma() {
		Assert.assertEquals(100,Hesaplama.KareAlma(10));
	}
	public void Toplama() {
		int sonuc=Hesaplama.Toplama(15, 10);
		Assert.assertEquals(25,sonuc);
	}
	public void Cikarma() {
		int sonuc=Hesaplama.Cikarma(15, 10);
		Assert.assertEquals(5,sonuc);
	}
	public void Carpma() {
		int sonuc=Hesaplama.Carpma(15, 10);
		Assert.assertEquals(150,sonuc);
	}
	public void Bolme() {
		int sonuc=Hesaplama.Bolme(18, 3);
		Assert.assertEquals(6,sonuc);
	}
	public void KupAlma() {
		Assert.assertEquals(100,Hesaplama.KupAlma(10));
	}
	public void MinSayi() {
		int sonuc=Hesaplama.MinSayi(15,10);
		Assert.assertEquals(10,sonuc);
	}
	public void MutlakDeger() {
		int sonuc=Hesaplama.MutlakDeger( 10);
		Assert.assertEquals(10,sonuc);
	}
	public void KokAlma() {
		double sonuc=Hesaplama.KokAlma(7);
		Assert.assertEquals(2,64,sonuc);
	}
	

}
