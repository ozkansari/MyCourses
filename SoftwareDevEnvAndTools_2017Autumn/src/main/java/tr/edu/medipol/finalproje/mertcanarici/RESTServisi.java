package com.medipol.SpringBootProje;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTServisi {

	private static final List<Haber> HABERLER = new ArrayList<Haber>();

	@RequestMapping("/haber/ekle")
	public Haber haberOlustur(String haberbaslik, String habericerik) {
		Haber Haber = new Haber(haberbaslik, habericerik);
		HABERLER.add(Haber);
		return Haber;
	}

	@RequestMapping("/haber/listele")
	public List<Haber> haberListele() {
		return HABERLER;
	}

	@RequestMapping("/haber/sil")
	public String haberSil(int index) {
		HABERLER.remove(index);
		return "İlk Haber Silindi.";

	}

	@RequestMapping("/haber/temizle")
    public String haberTemizle(){
            HABERLER.clear();
            return "Haberler Silindi.";
        }
}