package tr.com.medipol.yazilimaraclari.ogrenciyonetimi;

import com.mashape.unirest.http.*;

public class ManualTest {

	public static void main(String[] args) throws Exception {
		
		System.out.println(" ************************************** ");
		System.out.println("OLUSTUR");
		System.out.println(" ************************************** ");
		HttpResponse<String> ogrenciOlusturResponse = Unirest.post("http://localhost:8080/api/ogrenci/olustur/v2")
				  .header("Content-Type", "application/json")
				  .header("cache-control", "no-cache")
				  .header("Postman-Token", "a3a99dc7-56fe-40cd-bb5c-d69ddef939d1")
				  .body("{\"ogrenciAdSoyad\" : \"ogrenci 2\"}")
				  .asString();
		System.out.println(" ************************************** ");
		System.out.println(ogrenciOlusturResponse.getBody());
		System.out.println(" ************************************** ");
		
		System.out.println(" ************************************** ");
		System.out.println("LISTELE");
		System.out.println(" ************************************** ");
		
		HttpResponse<String> ogrenciListeleResponse = Unirest.get("http://localhost:8080/api/ogrenci/listele/v2")
				  .header("cache-control", "no-cache")
				  .header("Postman-Token", "77c933d5-6829-4c73-9997-b1ffeed5604f")
				  .asString();
		
		System.out.println(" ************************************** ");
		System.out.println(ogrenciListeleResponse.getBody());
		System.out.println(" ************************************** ");
	}

}
