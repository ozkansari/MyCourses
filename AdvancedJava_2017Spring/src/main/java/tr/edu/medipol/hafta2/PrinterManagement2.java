package tr.edu.medipol.hafta2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tr.edu.medipol.hafta1.Printer;

/**
 * List ve Map kompleks veri ornekleri
 * 
 * @author ozkansari
 *
 */
public class PrinterManagement2 {

	public static void main(String[] args) {
		List<Printer> printerListesi = new ArrayList<>();
		Printer samsung = new Printer("Samsung");
		printerListesi.add(samsung);
		Printer samsung2 = new Printer("Samsung 2");
		printerListesi.add(samsung2);
		printerListesi.add(new Printer("Samsung 3"));
		printerListesi.add(new Printer("Samsung 4"));
		
		listeOrnegi(printerListesi);
		
		mapOrnegi(printerListesi);
	}

	/**
	 * @param printerListesi
	 */
	private static void listeOrnegi(List<Printer> p) {
		for (Printer printer : p) {
			System.out.println(printer);
		}
		
		int indexOfSamsung = p.indexOf(new Printer("Samsung 3"));
		Printer current = p.get(indexOfSamsung);
		p.remove(current);
		
		for (Iterator iterator = p.iterator(); iterator.hasNext();) {
			Printer printer = (Printer) iterator.next();
			System.out.println(printer);
		}
	}
	
	/**
	 * @param printerListesi
	 */
	private static void mapOrnegi(List<Printer> printerListesi) {
		Map<String, Printer> markadanNesneye = new HashMap<>();
		for (Printer printer : printerListesi) {
			markadanNesneye.put(printer.getMarka(), printer);
		}
		Collection<Printer> values = markadanNesneye.values();
		Set<String> keySet = markadanNesneye.keySet();  
		Printer samsungRef = markadanNesneye.get("Samsung");
	}


}
