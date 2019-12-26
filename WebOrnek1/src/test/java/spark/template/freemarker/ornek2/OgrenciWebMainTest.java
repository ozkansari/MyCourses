package spark.template.freemarker.ornek2;

import org.junit.Assert;
import org.junit.Test;

public class OgrenciWebMainTest {

	@Test
	public void testOgrenciSil() {
		
		int beforeSize = OgrenciWebMain.getOgrenciListesi().size();

		OgrenciWebMain.ogrenciSil("0");
		
		int afterSize = OgrenciWebMain.getOgrenciListesi().size();
		
		Assert.assertEquals(beforeSize,afterSize+1);
	}

}
