# ILERI JAVA UYGULAMALARI - 2018 2019 BAHAR (Subat 2019 - Haziran 2019)

Dersler Cumartesi 09:00-10:00 ve 10:15-11:30 arasinda iki oturum halinde yapilacaktir.
Derse mazeretiniz yoksa devam zorunludur. Derse devam ve derse katilimdan not verilecektir.

https://classroom.google.com/c/MzA3Mzk2Mjg3NDVa
Kod: ar5vql

## DUYURULAR

Final yazili sinav olacaktir. Mebisde duyurulan tarihte.

Ek olarak asagidaki "Proje Final" odevini yapip Final tarihine  kadar teslim etmeniz gerekecektir.

------------------------------------------------------------

## PROJE FINAL - SparkJava ile Web Projesi

Teslim Tarihi: Final tarihineden 1 gün öncesine kadar classroom üzerinden sadece kod dosyalarinizi gonderiniz. Gec gonderim kabul edilmeyecektir.

### Onemli Noktalar

* Spark JAVA 1.1.1 ve Apache Derby 10.11.1.1 versiyonlari kullanilmali. Derste ogretilenler disinda bir teknoloji kullanilmamali.
* Butunleme zamani kodunuzu aciklamaniz istenecektir. Eger aciklayamazsaniz, projeyi sizin yapmadiginiz dusunulecektir.
* Proje maven projesi olmali.
* Kodlariniz (java ve html) src/main altinda "spark/template/freemarker/ad_soyadiniz" paketi icerisinde bulunmali.
* Sayfa adlari "/ad_soyadiniz/sayfa_adi" seklinde eslestirilmeli.
* Her bir sayfa icin ayri java sinifi olusturulmali. Tum bu ayri java siniflari, main metodu iceren ana bir Program sinifindan cagrilmali.
* Uygulamanizda tek bir main metodu bulunmali.
* Kodunuz okunakli, duzgun formatlanmis ve anlasilir olmali. Degisken, metod, class vb yerlerde turkce karakter kullanilmamali.

### Veritabani Tablolari

#### "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre

* kullanici_adi: Ayni kullanici adina sahip iki kullanici bulunamaz. (Silme islemleri kullanici_adi uzerinden yapilabilir)
* kullanici_tipi: Ekrandan girilmemeli, "2. Kullanici Olusturma Sayfasi"ndan girislerde "NORMAL" degeri atanmali. Uygulamada iki tip kullanici olacak: NORMAL ve ADMIN. ADMIN kullanici uygulama acilirken java kodu ile bir defaya mahsus tabloya eklenecek (insert). Yani zaten admin kullanici varsa tabloya kayit olarak eklenmemeli. 
* yas: yanlizca sayi girisine izin verilmeli.
* cinsiyet: K ya da E degerleri alabilir.
* sifre: Harf ve rakam girilebilir. kullanici_adi ve sifre birlikte giris islemlerinde kullanilacak.

### Proje Odevi Aciklamasi

#### 1. Giris Sayfasi:

    Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/giris_sayfasi"

Burada standart bir giris ekrani yapmanizi istiyorum. 
* "Kullanici Adi" ve "sifre" girisi yapildiktan sonra, kullanici "Giris" butonuna bastiginda, java kodu tarafinda kullanici ve sifre bilgileri kontrol edilecek.
* "Kullanici Adi" ve "sifre" bilgileri veritabanindaki "kullanicilar" tablosundaki kayitlardan kontrol edilmeli.
* Eger girilen "Kullanici Adi" ve "sifre" bilgileri, veritabanindaki "kullanicilar" tablosundaki her hangi bir kayit ile eslesiyorsa, sayfa "3. Normal Kullanici Anasayfa"sina yonlendirilmeli. Aksi durumda, ayni sayfaya bir hata mesajiyla geri donulmeli.
* "Kullanici Olustur" baglantisina tiklandiginda ise "2. Kullanici Olusturma Sayfasi"na yonlendirilmeli.
* Eger islemlerde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    (Hata mesaji varsa burada goruntulensin)
    
    Kullanici Adi: |_________________________| (Bos girise izin verme)
    
    sifre:         |_________________________| (Bos girise izin verme)
    
    << Giris >> (Submit button)
    
    << Kullanici Olustur >> (Kullanici Olusturma Sayfasina baglanti)
    
     / - - - - - - - - - - - - - - - - - - - - - - - - - - /

#### 2. Kullanici Olusturma Sayfasi:

    Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/uye_sayfasi"

Ekrandan "Kullanici Adi", "Yas", "Cinsiyet", "Sifre" girisleri yapildiktan sonra:
* "Uye Ol" butonuna basildiginda, , java kodu tarafinda veritabanindaki "kullanicilar" tablosuna ekleme islemi yapilacak. Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.
* "Vazgec" baglantisina tiklandiginda "1. Giris Sayfasi" sayfasina geri donulecek.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    Kullanici Adi: |_________________________| (Bos girise izin verme)
    
    Yas:           |_________________________| (Bos girise izin verme)
    
    Cinsiyet:      |_________________________| (Bos girise izin verme)
    
    Sifre:         |_________________________| (Bos girise izin verme)
    
    << Uye Ol >> (Submit button)
    
    << Vazgec >> (Giris sayfasina geri donecek)
    
     / - - - - - - - - - - - - - - - - - - - - - - - - - - /


#### 3. Normal Kullanici Anasayfa: 

    Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/"

Bu sayfanin goruntulenmesine, eger giris yapilmamissa izin verilmemeli.
Eger "1. Giris Sayfasi" uzerinden kullanici girisi yapilmadiysa, sayfanin goruntulenmesi engellenecek ve "1. Giris Sayfasi" adresine geri yonlendirilecek.
Sayfa goruntulendiginde, sistemdeki tum kullanicilar bilgileriyle tek tek her biri bir kutucuk icinde olmak uzere goruntulenebilmeli.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    / - - - /
    Kullanici 1
    / - - - /
    
    / - - - /
    Kullanici 2
    / - - - /
    
    ....
    
    / - - - - - - - - - - - - - - - - - - - - - - - - - - /

#### 4. ADMIN Kullanici Anasayfa: 

    Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/yonetici/"

Bu sayfanin goruntulenmesine, eger giris yapilmamissa ve giris yapan kullanici tipi ADMIN degilse izin verilmemeli.
Eger "1. Giris Sayfasi" uzerinden kullanici girisi yapilmadiysa, sayfanin goruntulenmesi engellenecek ve "1. Giris Sayfasi" adresine geri yonlendirilecek.
Eger giris yapan kullanici tipi ADMIN degilse "5. Hata Sayfasi" ekranina yonlendirilecek.
Sayfa goruntulendiginde, sistemdeki tum kullanicilar tablo halinde gosterilmeli ve her bir kullanici yaninda sil baglantisi bulunmali.
Sil baglantisina tiklandiginda, java kodu tarafinda kullanicilar tablosundan secilen kullanicinin silme islemi gerceklesmeli ve sonrasinda islem basariliysa mevcut kalan kullanicilari gosterecek sekilde ayn sayfaya donulmeli. 
Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.v

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - -  
    KULLANICI ADI		ISLEM
    / - - - - - /      / - - - - - /
    Kullanici 1        <<sil>>   
    Kullanici 2        <<sil>>
    ....
    
    / - - - - - - - - - - - - - - - - - - - - - - - - - - /


#### 5. Hata Sayfasi: 

    Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/hata/"

Normal tipteki bir kullanici "4. ADMIN Kullanici Anasayfa" ekranna eirsmeye calisirsa ya da uygulamada bir hata cikarsa, uygun bir mesajla birlikte bu sayfaya yonlendirilecek.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    HATA
    
    (Hata mesaji)
    
    / - - - - - - - - - - - - - - - - - - - - - - - - - - /

------------------------------------------------------------


### PROJE 1 - VIZE

#### Teslim Tarihi: 19 Nisan 2019 Cuma 23:59:59'a kadar class room uzerinden sadece kod dosyalarinizi gonderiniz. Gec teslim kabul edilmeyecektir.

Projelerinizi Derste Sunmaniz istenebilir. Sunum yapmayanlardan uan eksiltilerek not verilecektir.
*Ayni ve benzer proje teslimlerini kopya olarak degerlendirilecektir*

Uygulama kodlarinizi tr/edu/medipol/ilerijava/proje1/<<ad_soyad>>/ paketinde bulunmali <<ad_soyad>> yerine kendi ad ve soyadinizi yazmalisiniz.

#### Aciklama: 

Java ile Sunucu/Istemci (**Socket**) mimarisinde coklu akisi (Multi Thread) destekleyen bir hesaplama uygulamasi yapmanizi bekliyorum.
Sunucu ve Istemci(ler) iki ayri uygulama seklinde calismali. Bir **sunucuya birden fazla istemcinin TCP socket ile baglanmasi desteklenmeli**.

Sunucu tarafinda Java Swing GUI ile **giden gelen mesajlar** ve **bagli istemcilerin listesi** goruntulenmeli.

Istemci tarafinda ise Java Swing GUI ile istemciden **iki ayri sayi** ve **yapilacak islem tipi** ( +,-,/,* ) girdi olarak alinacak ve **GONDER butonu**na basildiginda sunucuya hesaplama islemi **tcp socket iletisimle mesaj olarak** gonderilecektir. Ornegin "2 * 55" gibi bir mesaj istemciden sunucuya gonderilecek.

Bu mesaji alan sunucu ise gelen mesajdaki hesaplama istegini algilayip, sonucu hesaplayacak ve istekte bulunan istemciye sonucu donecektir.

Istemci ise sonuc mesajini alip ekranda (ornegin labelda ya da disabled textfield'da) gosterecektir.

## DERSLER

### Vize Ders 1
Java Tekrari
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders01

### Vize Ders 2
Inheritance
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders02

### Vize Ders 3
Threads
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders03

### Vize Ders 4
Socket Programlama
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders04

### Vize Ders 5
Socket Programlama
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders05

### Vize Ders 6
Java GUI
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders06

### Vize Ders 7
Java GUI + Socket Programlama
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders07

---

### Final Ders 2
TCP IP Socket ile HTTP Sunucusu Yazma - Web Programlama 
https://github.com/ozkansari/MyCourses/tree/master/JavaHTTPServer

### Final Ders 3
Spark Java ile Web Programlama

1-) Maven Proje Olusturun (Eclipse'de File>New>Other>Maven Project) - Create a simple project secili olmali
* group id : spark.template.freemarker.medipol
* artifactid: OgrenciWeb

2-) pom. xml dependency'lerine spark java kutuphanelerini ekleyin.

pom.xml dosyasinda dependencies tagi icine:

```xml
<!-- Spark Java Web programlama yapmamizi saglayan kutuphane -->
	<dependency>
	    <groupId>com.sparkjava</groupId>
	    <artifactId>spark-core</artifactId>
	    <version>1.1.1</version>
	</dependency>
	<!-- HTML olusturmak icin freemarker kullaniminda gerekli -->
	<dependency>
	    <groupId>com.sparkjava</groupId>
	    <artifactId>spark-template-freemarker</artifactId>
	    <version>1.0</version>
	</dependency>
	<!--
	<dependency>
	    <groupId>org.freemarker</groupId>
	    <artifactId>freemarker</artifactId>
	    <version>2.3.28</version>
	</dependency>
	-->
	<!-- Ekstra spark loglarini acmak icin. Hata incelemede faydali. -->
	<dependency>
		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-simple</artifactId>
		<version>1.7.21</version>
	</dependency>
```

pom. xml'in son hali:


```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>spark.template.freemarker.medipol</groupId>
  <artifactId>OgrenciWeb</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>Ornek Web Projesi</name>
  <description>Sparkjava kullanarak ornek web projesi olusturma</description>
  <properties>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.source>1.8</maven.compiler.source>
  </properties>
  <dependencies>
  	<!-- Spark Java Web programlama yapmamizi saglayan kutuphane -->
	<dependency>
	    <groupId>com.sparkjava</groupId>
	    <artifactId>spark-core</artifactId>
	    <version>1.1.1</version>
	</dependency>
	<!-- HTML olusturmak icin freemarker kullaniminda gerekli -->
	<dependency>
	    <groupId>com.sparkjava</groupId>
	    <artifactId>spark-template-freemarker</artifactId>
	    <version>1.0</version>
	</dependency>
	<!--
	<dependency>
	    <groupId>org.freemarker</groupId>
	    <artifactId>freemarker</artifactId>
	    <version>2.3.28</version>
	</dependency>
	-->
	<!-- Ekstra spark loglarini acmak icin. Hata incelemede faydali. -->
	<dependency>
		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-simple</artifactId>
		<version>1.7.21</version>
	</dependency>
  </dependencies>
</project>
```

3-) src/main/java altina "spark.template.freemarker.medipol" paketi olusturun.

4-) Sag tiklayip "Run As>Maven>Install" calistirdiginizda BUILD SUCCESS gormeniz lazim.

NOT: Maven ile ilgili bir sorun olursa Sag tiklayip "Maven>update project" komutunu calistirabilirsiniz.

5-) Artik Spark kutuphanesi kullanarak Web Proejsi yapabiliriz. Spark kutuphanesi kullanirken asagidaki 3 import ifadesini sinifimiza eklememiz gerekir.

```java
import spark.*;
import static spark.Spark.*;
import spark.template.freemarker.*;
```
6-) Basit bir ornek program yazalim:

```java
import spark.*;
import static spark.Spark.*;

public class WebOrnek1 {
	public static void main(String[] args) {
		Route sayfa1 = new Route("/medipol/ornek/sayfa1") {
			@Override
			public Object handle(Request request, Response response) {
				return "sayfa 1";
			}
		};
		get(sayfa1);
	}
}
```

7-) Sonrasinda yazdigimiz sinifa sag tiklayip "Run As Java Application" diyelim.

8-) Tarayici acip "http://localhost:4567/medipol/ornek/sayfa1" adresini girdigimizde, sayfanin acildigini gorebiliriz.

9-) Bootstrap Tasarimi Kullanimi

* https://getbootstrap.com/docs/4.3/getting-started/introduction/
* https://getbootstrap.com/docs/4.3/components/navbar/


---

## Notlar

![NOTLAR](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava/_docs/vize_notlar.PNG?v=1)

---

## TAKVIM

* Hafta 1 - 23 SUBAT : Vize Ders 1 - Java Tekrari
* Hafta 2 -  2 MART  : Vize Ders 2 - Java Inheritance, Abstract Classes
* Hafta 3 -  9 MART  : Vize Ders 3 - Threads
* Hafta 4 - 16 MART  : Vize Ders 4 - Socket Programming
* Hafta 5 - 23 MART  : Vize Ders 5 - Socket Programming
* Hafta 6 - 30 MART  : Vize Ders 6 - Socket Programming + GUI 
* Hafta 7 - 6 NISAN  : Vize Ders 7 - Socket Programming + GUI
* << ARA SINAVLAR : 06.04.2019	14.04.2019 >>
* Hafta 8 - 13 NISAN  : Ders Yapilmayacak
* Hafta 9 - 20 NISAN  : Proje uzerine calisma - 
* Hafta 10 - 27 NISAN  : Final Ders 1
* Hafta 11 - 4 MAYIS  : Final Ders 2
* Hafta 12 - 11 MAYIS  : Final Ders 3
* Hafta 13 - 18 MAYIS  : Final Ders 4
* Hafta 14 - 25 MAYIS  : Final Ders 5
* Hafta 15 - 1 HAZIRAN  : Final Ders 6
* << RAMAZAN BAYRAMI : 03.06.2019	06.06.2019 >>
* Hafta 16 - 8 HAZIRAN  : Final Ders 7 - Tekrar
* << DONEM SONU SINAVLARI : 11.06.2019	23.06.2019 >>


