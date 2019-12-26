# ILERI JAVA UYGULAMALARI : 2019 - 2020 GUZ (Ekim 2019 - Ocak 2020)

Dersler Persembe 17:30-19:30 arasinda blok halde yapilacaktir.

Derse mazeretiniz yoksa devam zorunludur. Derse devam ve derse katilimdan not verilecektir.

Notlandirma: Derse Katilim + Mini Sinavlar + Lab Calismasi + Odevler + Projeler + Yazili Sinav

https://classroom.google.com/c/Mzg0MTU5OTk5MDBa

Kod: x2haxxq (Okul hesabi ile degil, kisisel hesabinizi kullanininiz)

## DUYURULAR

Google Clasrooma kayit yaptiriniz ve github hesabi olusturunuz.

---


## DERSLER

### Vize Ders 1 - Java Tekrari

Java Tekrari

Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders01/ornek1

Inheritance

Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders01/ornek2

### Vize Ders 2 - Thread

https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders02/lab


### Vize Ders 3 - Socket Programlama

https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders03/lab1

https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/_archive/00a_NetworkUygulamalari.pdf

### Vize Ders 4 - Socket Programlama & Thread

https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders04/lab


### Vize Ders 5 - Java Swing GUI

https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/_archive/06a_JavaGUI.pdf
https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/_archive/07a_JavaGUI_1.pdf
https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/_archive/07b_JavaGUI_2.pdf



### VIZE PROJE

#### Teslim Tarihi: 20 Kasım 2019 Cuma 23:59:59'a kadar class room uzerinden sadece kod dosyalarinizi gonderiniz. Gec teslim kabul edilmeyecektir.

Projelerinizi Derste Sunmaniz istenebilir. Sunum yapmayanlardan uan eksiltilerek not verilecektir.
*Ayni ve benzer proje teslimlerini kopya olarak degerlendirilecektir*

Uygulama kodlarinizi tr/edu/medipol/ilerijava/proje/<<ad_soyad>>/ paketinde bulunmali <<ad_soyad>> yerine kendi ad ve soyadinizi yazmalisiniz.

#### Aciklama: 

Java ile Sunucu/Istemci (**Socket**) mimarisinde coklu akisi (Multi Thread) destekleyen bir hesaplama uygulamasi yapmanizi bekliyorum.
Sunucu ve Istemci(ler) iki ayri uygulama seklinde calismali. Bir **sunucuya birden fazla istemcinin TCP socket ile baglanmasi desteklenmeli**.

Sunucu tarafinda Java Swing GUI ile **giden gelen mesajlar** ve **bagli istemcilerin listesi** goruntulenmeli.

Istemci tarafinda ise Java Swing GUI ile istemciden **iki ayri sayi** ve **yapilacak islem tipi** ( +,-,/,* ) girdi olarak alinacak ve **GONDER butonu**na basildiginda sunucuya hesaplama islemi **tcp socket iletisimle mesaj olarak** gonderilecektir. Ornegin "2 * 55" gibi bir mesaj istemciden sunucuya gonderilecek.

Bu mesaji alan sunucu ise gelen mesajdaki hesaplama istegini algilayip, sonucu hesaplayacak ve istekte bulunan istemciye sonucu donecektir.

Istemci ise sonuc mesajini alip ekranda (ornegin labelda ya da disabled textfield'da) gosterecektir.


---




### Final Ders 1

...

------------------------------------------------------------

## PROJE FINAL - SparkJava ile Web Projesi

Teslim Tarihi: 9 OCAK gun sonuna kadar classroom üzerinden sadece kod dosyalarinizi gonderiniz. Gec gonderim kabul edilmeyecektir.

2 OCAK gün sonuna kadar yapılan teslimlere bonus puan verilecektir.

### Onemli Noktalar

* Spark JAVA 1.1.1 ve Apache Derby 10.11.1.1 versiyonlari kullanilmali. Derste ogretilenler disinda bir teknoloji kullanilmamali.
* Final zamani kodunuzu aciklamaniz istenebilir. Eger aciklayamazsaniz, projeyi sizin yapmadiginiz dusunulecektir.
* Proje maven projesi olmali.
* Kodlariniz (java ve html) src/main altinda "spark/template/freemarker/ad_soyadiniz" paketi icerisinde bulunmali.
* Sayfa adlari "/ad_soyadiniz/sayfa_adi" seklinde eslestirilmeli.
* Her bir sayfa icin ayri java sinifi olusturulmali. Tum bu ayri java siniflari, main metodu iceren ana bir Program sinifindan cagrilmali.
* Uygulamanizda tek bir main metodu bulunmali.
* Kodunuz okunakli, duzgun formatlanmis ve anlasilir olmali. Degisken, metod, class vb yerlerde turkce karakter kullanilmamali.

### Veritabani Tablolari

#### "calisanlar" tablosu: calisan_adi, calisan_tipi, yas, cinsiyet, sifre

* calisan_adi: Ayni calisan adina sahip iki calisan bulunamaz. (Silme islemleri calisan_adi uzerinden yapilabilir)
* calisan_tipi: Ekrandan girilmemeli, "2. Calisan Olusturma Sayfasi"ndan girislerde "NORMAL" degeri atanmali. Uygulamada iki tip calisan olacak: NORMAL ve ADMIN. ADMIN calisan uygulama acilirken java kodu ile bir defaya mahsus tabloya eklenecek (insert). Yani zaten admin calisan varsa tabloya kayit olarak eklenmemeli. 
* yas: yanlizca sayi girisine izin verilmeli.
* cinsiyet: K ya da E degerleri alabilir.
* sifre: Harf ve rakam girilebilir. kcalisan_adi ve sifre birlikte giris islemlerinde kullanilacak.

### Proje Odevi Aciklamasi

#### 1. Giris Sayfasi:

    Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/giris_sayfasi"

Burada standart bir giris ekrani yapmanizi istiyorum. 
* "Calisan Adi" ve "sifre" girisi yapildiktan sonra, calisan "Giris" butonuna bastiginda, java kodu tarafinda calisan ve sifre bilgileri kontrol edilecek.
* "Calisan Adi" ve "sifre" bilgileri veritabanindaki "calisanlar" tablosundaki kayitlardan kontrol edilmeli.
* Eger girilen "Calisan Adi" ve "sifre" bilgileri, veritabanindaki "calisanlar" tablosundaki her hangi bir kayit ile eslesiyorsa, sayfa "3. Normal Calisan Anasayfa"sina yonlendirilmeli. Aksi durumda, ayni sayfaya bir hata mesajiyla geri donulmeli.
* "Calisan Olustur" baglantisina tiklandiginda ise "2. Calisan Olusturma Sayfasi"na yonlendirilmeli.
* Eger islemlerde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    (Hata mesaji varsa burada goruntulensin)
    
    Calisan Adi:   |_________________________| (Bos girise izin verme)
    
    sifre:         |_________________________| (Bos girise izin verme)
    
    << Giris >> (Submit button)
    
    << Calisan Olustur >> (Calisan Olusturma Sayfasina baglanti)
    
     / - - - - - - - - - - - - - - - - - - - - - - - - - - /

#### 2. Calisan Olusturma Sayfasi:

    Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/calisan_ekle"

Ekrandan "Calisan Adi", "Yas", "Cinsiyet", "Sifre" girisleri yapildiktan sonra:
* "Uye Ol" butonuna basildiginda, , java kodu tarafinda veritabanindaki "calisanlar" tablosuna ekleme islemi yapilacak. Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.
* "Vazgec" baglantisina tiklandiginda "1. Giris Sayfasi" sayfasina geri donulecek.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    Calisan Adi:   |_________________________| (Bos girise izin verme)
    
    Yas:           |_________________________| (Bos girise izin verme)
    
    Cinsiyet:      |_________________________| (Bos girise izin verme)
    
    Sifre:         |_________________________| (Bos girise izin verme)
    
    << Uye Ol >> (Submit button)
    
    << Vazgec >> (Giris sayfasina geri donecek)
    
     / - - - - - - - - - - - - - - - - - - - - - - - - - - /


#### 3. Normal Calisan Anasayfa: 

    Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/"

Bu sayfanin goruntulenmesine, eger giris yapilmamissa izin verilmemeli.
Eger "1. Giris Sayfasi" uzerinden calisan girisi yapilmadiysa, sayfanin goruntulenmesi engellenecek ve "1. Giris Sayfasi" adresine geri yonlendirilecek.
Sayfa goruntulendiginde, sistemdeki tum calisanlar bilgileriyle tek tek her biri bir kutucuk icinde olmak uzere goruntulenebilmeli.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    / - - - /
    Calisan 1 - 22 yas
    / - - - /
    
    / - - - /
    Calisan 2 - 35 yas
    / - - - /
    
    ....
    
    / - - - - - - - - - - - - - - - - - - - - - - - - - - /

#### 4. ADMIN Calisan Anasayfa: 

    Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/yonetici/"

Bu sayfanin goruntulenmesine, eger giris yapilmamissa ve giris yapan calisan tipi ADMIN degilse izin verilmemeli.
Eger "1. Giris Sayfasi" uzerinden calisan girisi yapilmadiysa, sayfanin goruntulenmesi engellenecek ve "1. Giris Sayfasi" adresine geri yonlendirilecek.
Eger giris yapan calisan tipi ADMIN degilse "5. Hata Sayfasi" ekranina yonlendirilecek.
Sayfa goruntulendiginde, sistemdeki tum calisanlar tablo halinde gosterilmeli ve her bir calisan yaninda sil baglantisi bulunmali.
Sil baglantisina tiklandiginda, java kodu tarafinda calisanlar tablosundan secilen calisanin silme islemi gerceklesmeli ve sonrasinda islem basariliysa mevcut kalan calisanlari gosterecek sekilde ayn sayfaya donulmeli. 
Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.v

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - -  
    CALISAN ADI		ISLEM
    / - - - - - /      / - - - - - /
    Calisan 1        <<sil>>   
    Calisan 2        <<sil>>
    ....
    
    / - - - - - - - - - - - - - - - - - - - - - - - - - - /


#### 5. Hata Sayfasi: 

    Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/hata/"

Normal tipteki bir calisan "4. ADMIN Calisan Anasayfa" ekranna erismeye calisirsa ya da uygulamada bir hata cikarsa, uygun bir mesajla birlikte bu sayfaya yonlendirilecek.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    HATA
    
    (Hata mesaji)
    
    / - - - - - - - - - - - - - - - - - - - - - - - - - - /

------------------------------------------------------------

---

## Notlar

...


---

## TAKVIM

* Hafta 1  - 26 EYLUL : Deprem Nedeniyle Iptal Edildi
* Hafta 2  -  3 EKIM  : Vize Ders 1 - Java Tekrari, Java Inheritance, Abstract Classes
* Hafta 3  - 10 EKIM  : Vize Ders 2 - Threads
* Hafta 4  - 17 EKIM  : Vize Ders 3 - Socket Programlama
* Hafta 5  - 24 EKIM  : Vize Ders 4 - Socket Programlama & Thread
* Hafta 6  - 31 EKIM  : Vize Ders 5 - Java Swing GUI
* Hafta 7  -  7 KASIM : Vize Ders 6 - 
* << ARA SINAVLAR : 09.11.2019	17.11.2019 >>
* Hafta 8  - 21 KASIM  : Final Ders 1 - Veritabani
* Hafta 9  - 28 KASIM  : Final Ders 2 - Veritabani (Devami..)
* Hafta 10 -  5 ARALIK : Final Ders 3 - Web Programlama Giris - TCP IP Socket ile HTTP Sunucusu Yazma
* Hafta 11 - 12 ARALIK : Final Ders 4 - Spark Java ile Web Programlama
* Hafta 12 - 19 ARALIK : Final Ders 5 - Spark Java ile Web Programlama (Devami..)
* Hafta 13 - 26 ARALIK : Final Ders 6 - Spark Java ile Web Programlama (Devami..)
* Hafta 14 -  2 OCAK   : 1 Ocak Yilbasi Tatili Nedeniyle Ders Yapilmayacak 
* << DONEM SONU SINAVLARI : 06.01.2020	16.01.2020 >>
* << BUTUNLEME SINAVLARI : 23.01.2020	26.01.2020 >> 	




