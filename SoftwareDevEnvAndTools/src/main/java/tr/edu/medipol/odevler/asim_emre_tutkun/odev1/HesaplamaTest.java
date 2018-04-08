package tr.edu.medipol.odevler.asim_emre_tutkun.odev1;
import org.junit.Assert;
import org.junit.Test;


public class HesaplamaTest {
	@Test
	public void testKareAlma() {
		Assert.assertEquals(100,hesaplama.kareAlma(10));
		
	}
		@Test
	public void testToplama() {
		Assert.assertEquals(100,hesaplama.toplama(10,10));
		
	}
		@Test
	public void testCarpma() {
		Assert.assertEquals(100,hesaplama.carpma(10,5));
		
	}
		@Test
	public void testCikarma() {
		Assert.assertEquals(100,hesaplama.cikarma(10,2));
		
	}
		@Test
	public void testOrtalama() {
		Assert.assertEquals(100,hesaplama.ortalama(10,8));
		
	}
		
	// HATALI TEST
	@Test
	public void testBolme() {
		//duzeltme :Assert.assertEquals(100,hesaplama.kareAlma(10,2));
		Assert.assertEquals(100,hesaplama.kareAlma(10));
	}
		@Test
	public void testussuAlma() {
		Assert.assertEquals(100,hesaplama.ussuAlma(2,6));
		
	}
		@Test
	public void testkareKok() {
		Assert.assertEquals(100,hesaplama.kareKok(100));
		
	}
		@Test
	public void testKareAlan() {
		Assert.assertEquals(100,hesaplama.kareAlan(10));
		
	}
		@Test
	public void testKareCevre() {
		Assert.assertEquals(100,hesaplama.kareCevre(10));
		
	}
	

}
