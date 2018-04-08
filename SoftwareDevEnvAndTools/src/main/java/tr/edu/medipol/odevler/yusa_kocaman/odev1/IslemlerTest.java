package tr.edu.medipol.odevler.yusa_kocaman.odev1;

//importlar eksikdi, eklendi: -10
// derlenmeyen kod: -10

import org.junit.Assert;
import org.junit.Test;

public class IslemlerTest {
	@Test
	public void testTopla() {
		Assert.assertEquals(50, islemler.topla(25, 25))/* ek-> */;
	}

	@Test
	public void testCikar() {
		Assert.assertEquals(10, islemler.cikar(25, 15))/* ek-> */;
	}

	@Test
	public void testCarp() {
		Assert.assertEquals(4, islemler.carp(2, 2))/* ek-> */;
	}

	@Test
	public void testBol() {
		Assert.assertEquals(50, islemler.topla(100, 2))/* ek-> */;
	}

	@Test
	public void testKareAl() {
		Assert.assertEquals(100, islemler.kareal(10))/* ek-> */;
	}

	@Test
	public void testKup() {
		Assert.assertEquals(27, islemler.kup(3))/* ek-> */;
	}

	@Test
	public void testMod() {
		Assert.assertEquals(2, islemler.mod(8, 3))/* ek-> */;
	}

	@Test
	public void testKuvvet() {
		Assert.assertEquals(625, islemler.kuvvet(5, 4))/* ek-> */;
	}

	@Test
	public void testKarekok() {
		Assert.assertEquals(169, islemler.karekok(13))/* ek-> */;
	}

	@Test
	public void testBuyuk() {
		Assert.assertEquals(25, islemler.buyuk(25, 5))/* ek-> */;
	}
}
