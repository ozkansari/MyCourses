package tr.edu.medipol.odevler.anil_bal.odev1;
import static org.junit.Assert.*;
import org.junit.Test;

public class HesaplamaTest {

	
	@Test
	public void testIslemler() {
		int gercekSonuc = Hesaplama.islemler(10,2);
		assertEquals(5, gercekSonuc);
	}
	
	
	@Test
	public void testTopla() {
		int gercekSonuc = Hesaplama.topla(25, 14);
		assertEquals(39, gercekSonuc);
	}
	
	
	@Test
	public void testCarp() {
		int gercekSonuc = Hesaplama.carpma(10,10);
		assertEquals(100, gercekSonuc);
	}
	
	@Test
	public void testCikar() {
		int gercekSonuc = Hesaplama.cikarma(20,10);
		assertEquals(10, gercekSonuc);
	}
	
	@Test
	public void testBolme() {
		int gercekSonuc = Hesaplama.bolme(20, 10);
		assertEquals(2, gercekSonuc);
	}

	@Test
	public void testMod() {
		int gercekSonuc = Hesaplama.mod(20, 5);
		assertEquals(0, gercekSonuc);
	}

	@Test
	public void testMutlak() {
		// duzeltme:int gercekSonuc = Hesaplama.mutlak(-15);
		// duzeltme:assertEquals(15, gercekSonuc);
	}
	
	@Test
	public void testMinimum() {
		int gercekSonuc = Hesaplama.minimum(50,90);
		assertEquals(50, gercekSonuc);
	}
	
	@Test
	public void testMaksimum() {
		// duzeltme:int gercekSonuc = Hesaplama.maksimum(50. 90);
		// duzeltme:assertEquals(90, gercekSonuc);
	}

	@Test
	public void testYukari() {
		// duzeltme:int gercekSonuc = Hesaplama.yukari_yuvarla(3.162);
		// duzeltme:assertEquals(4, gercekSonuc);
	}

	@Test
	public void testAssagi() {
		// duzeltme:int gercekSonuc = Hesaplama.assagi_yuvarla(3.162);
		// duzeltme:assertEquals(3, gercekSonuc);
	}
	
	

}