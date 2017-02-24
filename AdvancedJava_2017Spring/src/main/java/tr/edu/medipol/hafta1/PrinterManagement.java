package tr.edu.medipol.hafta1;

import java.util.Arrays;

public class PrinterManagement {
	
	public static void main(String[] args) {
		// System.out.println("Merhaba " + args[0]);
		Printer [] allPrinters = new Printer[2];
		int index = 0;
		
		Printer hp = new Printer(new String("HP"));
		allPrinters[index++] = hp;
		hp.print("Merhaba " + hp.getMarka());

		Printer dell = new Printer("DELL");
		allPrinters[index++] = dell;
		dell.print("Nasýlsýn ");
		
		// toString() metodu otomatik cagrilir.
		System.out.println(dell);
		
		// OBJE KARSILASTIRMA
		
		if (hp.equals(dell)) {
			System.out.println("Ayni printer");
		} else {
			System.out.println("Ayni degil");
		}
		
		// DONGULER
		
		System.out.println("Yontem 1: ");
		for (Printer printer : allPrinters) {
			System.out.println(printer);
		}
		
		System.out.println("Yontem 2: ");
		for (int i = 0; i < allPrinters.length; i++) {
			System.out.println(allPrinters[i]);
		}
		
		System.out.println("Yontem 3 (Fonksiyonel Programlama): ");
		Arrays.asList(allPrinters).forEach(printer -> System.out.println(printer));
		
	}
}
