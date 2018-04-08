package tr.edu.medipol.odevler.betul_ozdemir.odev1;
import org.junit.*;

// Tum siniflarda: @Test annotation yok -20

public class HesaplamaTest {
	@Test
	public void KupAlma(){
		Assert.assertEquals(1000,MatematikselIslemler.KupAlma(10));
	
	}
	public void Bolme() {
		int sonuc=MatematikselIslemler.Bolme(20, 5);
	    Assert.assertEquals(4,sonuc);
	   
	}
	public void Toplama() {
		int sonuc=MatematikselIslemler.Toplama(10, 10);
		Assert.assertEquals(20,sonuc);
	}
	public void CIkarma() {
		int sonuc=MatematikselIslemler.cikarma(10, 2);
		Assert.assertEquals(8,sonuc);
	}
	public void Carpma() {
		int sonuc=MatematikselIslemler.carpma(5, 2);
		Assert.assertEquals(10,sonuc);
	}
	public void KokAlma() {
		double sonuc=MatematikselIslemler.KokAlma(7);
		Assert.assertEquals(2,64,sonuc);
	}
	public void MutlakDeðer() {
		int sonuc=MatematikselIslemler.MutlakDeger(7);
		Assert.assertEquals(7,sonuc);
	}
	public void MinSayi() {
		int sonuc=MatematikselIslemler.MinSayi(10, 5);
		Assert.assertEquals(5,sonuc);
	}
	public void MaxSayi() {
		int sonuc=MatematikselIslemler.MaxSayi(10, 5);
		Assert.assertEquals(10,sonuc);
	}
	public void ModAlma() {
		int sonuc=MatematikselIslemler.ModAlma(10, 5);
		Assert.assertEquals(0,sonuc);
}
}
