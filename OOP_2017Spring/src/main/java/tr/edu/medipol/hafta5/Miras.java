package tr.edu.medipol.hafta5;

public class Miras {

	public static void main(String[] args) {
		Arac bmw = new Araba(2005);
	}
}

abstract class Arac {
	private Motor motor;
	protected int uretimYili;

	abstract protected void calistir();

	public Arac(int uretimYili) {
		this.uretimYili = uretimYili;
		motor = new Motor();
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	public Motor getMotor() {
		return motor;
	}
}

class Araba extends Arac {
	public Araba(int uretimYili) {
		super(uretimYili);
	}
	@Override
	protected void calistir() {
		
	}
}

class Motor {
}

// INTERFACE ORNEGI ------------------------
interface Komut {
	void komutCalistir();
}

class DirKomutu implements Komut {
	public void komutCalistir() {
		// ...
	}
}
