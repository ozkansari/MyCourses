package tr.edu.medipol.hafta4.arayuz;

public class KomutProgrami {

	public static void main(String[] args) {
		Komut dirKomutu = new DirKomutu();
		// System.out.println(dirKomutu.komutBilgisi());
		calistir(dirKomutu);
		
		Komut mkDirKomutu = new MkdirKomutu();
		// System.out.println(mkDirKomutu.komutBilgisi());
		calistir(mkDirKomutu);
	}
	
	public static void calistir(Komut komut){
		System.out.println(">");
		komut.komutCalistir();
	}
	
	/*
	public static void dirCalistir(DirKomutu komut){
		System.out.println(">");
		komut.komutCalistir();
	}
	
	public static void mkdirCalistir(MkdirKomutu komut){
		System.out.println(">");
		komut.komutCalistir();
	}
	*/
}
