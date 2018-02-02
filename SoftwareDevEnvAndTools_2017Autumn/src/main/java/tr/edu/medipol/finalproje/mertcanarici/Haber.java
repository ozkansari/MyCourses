package com.medipol.SpringBootProje;

public class Haber {
	private static int COUNT = 0;
	public int id;
	public String haberbaslik;
	public String habericerik;

	public Haber(String haberbaslik, String habericerik) {
		this.id = ++COUNT;
		this.haberbaslik = haberbaslik;
		this.habericerik = habericerik;
	}

	public String gethaberbaslik() {
		return haberbaslik;
	}

	public String gethabericerik() {
		return habericerik;
	}
}
