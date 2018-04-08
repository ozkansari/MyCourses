package tr.edu.medipol.odevler.tugba_yildirim.odev1;

import org.junit.Test;
import org.junit.Assert;

public class IslemTest {
	public class IslemlerTest {
		@Test
		public void testTopla() {
			Assert.assertEquals(50, Islem.topla(25, 25));
		}

		@Test
		public void testCikar() {
			Assert.assertEquals(10, Islem.cikar(25, 15));
		}

		@Test
		public void testCarp() {
			Assert.assertEquals(4, Islem.carp(2, 2));
		}

		@Test
		public void testBol() {
			Assert.assertEquals(50, Islem.bol(100, 2));
		}

		@Test
		public void testKareAl() {
			Assert.assertEquals(100, Islem.kareal(10));
		}

		@Test
		public void testTaban() {
			Assert.assertEquals(12, Islem.taban(12.2));
		}

		@Test
		public void testTavan() {
			Assert.assertEquals(9, Islem.tavan(8.3));
		}

		@Test
		public void testKuvvet() {
			Assert.assertEquals(625, Islem.kuvvet(5, 4));
		}

		@Test
		public void testMutlak() {
			Assert.assertEquals(13, Islem.mutlak(-13));
		}

		@Test
		public void testEnKucuk() {
			Assert.assertEquals(5, Islem.enkucuk(25, 5));
		}
	}
}
