package tr.edu.medipol.odevler.yucel_ozalp.odev1;
import static org.junit.Assert.*;
import org.junit.Test;

public class HesaplamaTest {

	@Test
	public void testToplaHepsi() {
		
		for (int sayi1=-10000; sayi1<10001; sayi1++) {
			for (int sayi2=-10000;sayi2<10001; sayi2++) {
				int gercekSonuc = Hesaplama.toplama(sayi1, sayi2);
				assertEquals(sayi1+sayi2, gercekSonuc);
			}
		}
		
	}
	
	
	@Test
	public void testToplamaPoz() {
		int OrjReturnIslem = Hesaplama.toplama(635234, 5242);
		assertEquals(640476, OrjReturnIslem);
	}
	
	@Test
	public void testToplamaNeg() {
		int OrjReturnIslem = Hesaplama.toplama(-63, -2);
		assertEquals(-65, OrjReturnIslem);
	}

	@Test
	public void testCikarmaPoz() {
		int OrjReturnIslem = Hesaplama.cikarma(564, 425);
		assertEquals(139, OrjReturnIslem);
	}
	
	@Test
	public void testCikarmaNeg() {
		int OrjReturnIslem = Hesaplama.cikarma(-240, -37);
		assertEquals(-203, OrjReturnIslem);
	}
	
	@Test
	public void testCarpmaPoz() {
		int OrjReturnIslem = Hesaplama.carpma(55, 4);
		assertEquals(220, OrjReturnIslem);
	}
	@Test
	public void testCarpmaNeg() {
		int OrjReturnIslem = Hesaplama.carpma(-240, -5);
		assertEquals(1200, OrjReturnIslem);
	}
	
	@Test
	public void testBolmePoz() {
		int OrjReturnIslem = Hesaplama.bolme(280, 8);
		assertEquals(35, OrjReturnIslem);
	}
	@Test
	public void testBolmeNeg() {
		int OrjReturnIslem = Hesaplama.bolme(-560, -25);
		assertEquals(22, OrjReturnIslem);
	}
	
}
