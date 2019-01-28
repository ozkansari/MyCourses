package spark.template.freemarker.efkanic.finalproje;

public class Urun {
	private String urunadi;

	public Urun(String urunadi) {
		this.urunadi = urunadi;
	}

	public String getUrunadi() {
		return urunadi;
	}

	public void setUrunadi(String urunadi) {
		this.urunadi = urunadi;
	}

	@Override
	public String toString() {
		return urunadi + " ";
	}

}
