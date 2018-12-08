package tr.com.medipol.yazilimaraclari.ogrenciyonetimi;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTServisi {

	private List<String> ogrenciler = new ArrayList<>();
	
	@PostMapping("/api/ogrenci/olustur")
	public String ogrenciOlustur(String ogrenciAdSoyad) {
		System.out.println("Request: " + ogrenciAdSoyad);
		ogrenciler.add(ogrenciAdSoyad);
		return ogrenciAdSoyad;
	}
	
	@PostMapping(name="/api/ogrenci/olustur/v2"
		, consumes= {MediaType.APPLICATION_JSON_UTF8_VALUE}
		, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE}
	)
	public ResponseEntity<String> ogrenciOlusturV2(@RequestBody String ogrenciAdSoyad) {
		System.out.println("Request: " + ogrenciAdSoyad);
		ogrenciler.add(ogrenciAdSoyad);
		return new ResponseEntity<String>(ogrenciAdSoyad, HttpStatus.OK);
	}
	
	@RequestMapping("/api/ogrenci/listele")
	public List<String> ogrencileriListele(){
		return ogrenciler;
	}
	
	@GetMapping(
			name="/api/ogrenci/listele/v2"
			, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE}
	)
	@ResponseBody
	public ResponseEntity<List<String>> ogrencileriListeleV2(){
		return new ResponseEntity<>(ogrenciler, HttpStatus.OK);
	}
	
	
}
