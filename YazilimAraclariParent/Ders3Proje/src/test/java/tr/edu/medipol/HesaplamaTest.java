package tr.edu.medipol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HesaplamaTest {

	private static Hesaplama h;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(">>> TESTLER BASLIYOR >>>");
		h = new Hesaplama();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		h = null;
		System.out.println("<<< TESTLER BITIYOR <<<");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Unit test basliyor ....");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Unit test bitiyor ....");
	}

	@Test
	public final void testTopla2Arti2() {
		int sonuc = h.topla(2, 2);
		assertEquals("2 artı 2 = 4 olmali", 4, sonuc);
	}
	
	@Test
	public final void testToplaNegatifSayilar() {
		for (int a = -10000; a < 0; a++) {
			for (int b = -10000; b < 0; b++) {
				int sonuc = h.topla(a, b);
				assertEquals(a+b, sonuc);
				assertEquals(Math.addExact(a, b), sonuc);
			}
			
		}
	}
	
	@Test
	public final void testToplaPozitifSayilar() {
		fail("Not yet implemented");
	}
	
	@Test
	public final void testBol() {
		fail("Not yet implemented");
	}

	@Test
	public final void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public final void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public final void testToString() {
		fail("Not yet implemented");
	}

}
