package tr.edu.medipol.odevler.can_savut.odev1;
import org.junit.Assert;
import org.junit.Test;


//duzeltme :public class HesaplamaTest {
public class OdevTest {

	//duzeltme :
	Odev hesaplama = new Odev();
	
	public void testKareAlma() {
		Assert.assertEquals(100,hesaplama.kareAlma(10));
		
	}
		
	public void testcikar() {
		Assert.assertEquals(100,hesaplama.cikar(10,5));
		
	}
		
	public void testtopla() {
		Assert.assertEquals(100,hesaplama.topla(10,6));
		
	}
		
	public void testortBulma() {
		Assert.assertEquals(100,hesaplama.ortBulma(10,6));
		
	}
		
	public void testcarp() {
		Assert.assertEquals(100,hesaplama.carp(10,8));
		
	}
		
	public void testkarekokBulma() {
		//duzeltme :Assert.assertEquals(100,hesaplama.karekokBulma(10,6));
		Assert.assertEquals(100,hesaplama.karekokBulma(10));
	}
		
	public void testbol() {
		Assert.assertEquals(100,hesaplama.bol(10,5));
		
	}
		
	public void testussuAlma() {
		Assert.assertEquals(100,hesaplama.ussuAlma(4,2));
		
	}
		
	public void testdikdortgennAlan() {
		Assert.assertEquals(100,hesaplama.dikdortgennAlan(4,8));
		
	}
	
	public void testdikdortgenCevre() {
		Assert.assertEquals(100,hesaplama.dikdortgenCevre(4,8));
		
	}
	
	

}
