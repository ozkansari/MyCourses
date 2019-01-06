# ILERI JAVA UYGULAMALARI - 2018 GUZ

Dersler Cumartesi 09:00-10:00 ve 10:15-11:30 arasinda iki oturum halinde yapilacaktir.
Derse mazeretiniz yoksa %80 devam zorunludur. Derse devam ve derse katilimdan not verilecektir.

## DUYURULAR

### FINAL PROJESI


### Onemli Noktalar

* Final projesi sifirdan sade bir sekilde gelistirilmeli. Ornegin, Dersdeki kod ve projeler uzerinden devam ederek proje olustulmamali ve dersteki projeden ilerleyip proje ile alakasiz kodlar gonderilmemeli. Ayni sekilde internetten bulunan alakasiz derste gosterilmeyen kod ve teknolojiler kullanilmamali.
* Spark JAVA 1.1.1 ve Apache Derby 10.11.1.1 (dosya tabanli veritabani) versiyonlari kullanilmali. Derste ogretilenler disinda bir teknoloji kullanilmamali.
* Sinav zamani kodunuzu aciklamaniz istenecektir. Eger aciklayamazsaniz, projeyi sizin yapmadiginiz dusunulecektir.
* Proje maven projesi olmali.
* Kodlariniz (java ve html) src/main altinda "spark/template/freemarker/<<ad_soyadiniz>>/finalproje/" paketi icerisinde bulunmali. (<<ad_soyadiniz>> yerien kendi ad soyadinizi yaziniz)
* Sayfa adlari "/<<ad_soyadiniz>>/sayfa_adi" seklinde eslestirilmeli. (<<ad_soyadiniz>> yerien kendi ad soyadinizi yaziniz)
* Her bir sayfa icin ayri java sinifi olusturulmali. Tum bu ayri java siniflari, main metodu iceren ana bir Program sinifindan cagrilmali.
* Uygulamanizda tek bir main metodu bulunmali.
* Tum kodunuz javadoc ile dokumante edilmis olmali.
* Kodunuz okunakli, duzgun formatlanmis ve anlasilir olmali. Degisken, metod, class vb yerlerde turkce karakter kullanilmamali.

### Veritabani Tablolari

#### "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre

* kullanici_adi: Veritabani tablosunda ayni kullanici adina sahip iki kullanici bulunamaz. (Silme islemleri kullanici_adi uzerinden yapilabilir)
* kullanici_tipi: Ekrandan girilmemeli, "2. Kullanici Olusturma Sayfasi"ndan girislerde "NORMAL" degeri atanmali. Uygulamada iki tip kullanici olacak: NORMAL ve ADMIN. ADMIN kullanici uygulama acilirken java kodu ile bir defaya mahsus tabloya eklenecek (insert). Yani zaten admin kullanici varsa tabloya kayit olarak eklenmemeli. 
* yas: yanlizca sayi girisine izin verilmeli.
* cinsiyet: K ya da E degerleri alabilir.
* sifre: Harf ve rakam girilebilir. kullanici_adi ve sifre birlikte giris islemlerinde kullanilacak.

#### "urunler" tablosu: urun_id, urun_adi, urun_kategori, fiyat

* urun_id : Sistem tarafindan atanan essiz bir id. Veritabani tablosunda ayni urun_idye sahip iki kayit olamaz.
* urun_adi : Urun adi.
* urun_kategori: Urun kategorisi.
* fiyat : Numerik TL olarak urun fiyati.

### Proje Odevi Aciklamasi

#### 1. Giris Sayfasi:

    Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/giris_sayfasi"

Burada standart bir giris ekrani yapmanizi istiyorum. 
* "Kullanici Adi" ve "sifre" girisi yapildiktan sonra, kullanici "Giris" butonuna bastiginda, java kodu tarafinda kullanici ve sifre bilgileri kontrol edilecek.
* "Kullanici Adi" ve "sifre" bilgileri veritabanindaki "kullanicilar" tablosundaki kayitlardan kontrol edilmeli.
* Eger girilen "Kullanici Adi" ve "sifre" bilgileri, veritabanindaki "kullanicilar" tablosundaki hicbir kayit ile *eslesmiyorsa* ayni sayfaya hata mesajiyla geri donulmeli. 
* Eger girilen "Kullanici Adi" ve "sifre" bilgileri, veritabanindaki "kullanicilar" tablosundaki herhangi *bir kayit ile eslesiyorsa* , once kullanicinin tipine bakilir. Eger kullanici tipi "NORMAL" ise, sayfa "3. Normal Kullanici Anasayfa"sina yonlendirilmeli.  Eger kullanici tipi "ADMIN" ise, sayfa "4. ADMIN Kullanici Anasayfa"sina yonlendirilmeli.
* "Kullanici Olustur" baglantisina tiklandiginda ise "2. Kullanici Olusturma Sayfasi"na yonlendirilmeli.
* Eger islemlerde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.

NOT: Test amaciyla,  kullanici adi "admin" sifre "admin" girildiginde ADMIN kullanicisi girisi,  kullanici adi "user" sifre "user" girildiginde NORMAL kullanici girisi yaptirabilirsiniz. Ancak bunun disindaki degerler icin veritabanindan kontrol yapilmali.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    (Hata mesaji varsa burada goruntulensin)
    
    Kullanici Adi: |_________________________| (Bos girise izin verme)
    
    sifre:         |_________________________| (Bos girise izin verme)
    
    << Giris >> (Submit button)
    
    << Kullanici Olustur >> (Kullanici Olusturma Sayfasina baglanti)
    
     / - - - - - - - - - - - - - - - - - - - - - - - - - - /

#### 2. Normal Kullanici Olusturma Sayfasi:

    Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/uye_sayfasi"

Ekrandan "Kullanici Adi", "Yas", "Cinsiyet", "Sifre" girisleri yapildiktan sonra:
* "Uye Ol" butonuna basildiginda, , java kodu tarafinda veritabanindaki "kullanicilar" tablosuna ekleme islemi yapilacak. Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.
* "Vazgec" baglantisina tiklandiginda "1. Giris Sayfasi" sayfasina geri donulecek. Bu sayfadan sadece normal kullanici olusturulabilir. Yani olusturulan kullaniciya tipi olarak "NORMAL" atanmali.

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
Sayfa goruntulendiginde, sistemdeki tum urunler bilgileriyle tek tek her biri bir kutucuk icinde olmak uzere goruntulenebilmeli. 
ADMIN tipindeki kullanicilar da bu sayfayi goruntuleyebilecek.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    / - - - /
    Urun 1 - Fiyat
    
    / - - - /
    
    / - - - /
    Urun 2 - Fiyat
    / - - - /
    
    ....
    
    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
#### 4. ADMIN Kullanici Anasayfa: 

    Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/yonetici/"

Bu sayfanin goruntulenmesine, eger giris yapilmamissa ve giris yapan kullanici tipi ADMIN degilse izin verilmemeli.
Eger "1. Giris Sayfasi" uzerinden kullanici girisi yapilmadiysa, sayfanin goruntulenmesi engellenecek ve "1. Giris Sayfasi" adresine geri yonlendirilecek.
Eger giris yapan kullanici tipi ADMIN degilse "5. Hata Sayfasi" ekranina yonlendirilecek.

Sayfa goruntulendiginde, sistemdeki tum kullanicilar ve urunler ayri ayri  gosterilmeli ve her bir kullanici ve urun yaninda sil baglantisi bulunmali.
Sil baglantisina tiklandiginda, java kodu tarafinda kaydin silme islemi gerceklesmeli ve sonrasinda islem basariliysa mevcut kalan kayitlari gosterecek sekilde ayni sayfaya donulmeli. 
Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.

Ayrica sayfada kullanici ve urun ekleme formlari bulunmali. Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.

Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - -  
    KULLANICILAR
    -------------
    KULLANICI ADI   ISLEM
    / - - - - - /      / - - - - - /
    Kullanici 1        <<sil>>   
    Kullanici 2        <<sil>>
    ....


    URUNLER
    -------------
    
    URUN ADI        ISLEM
    / - - - - - /      / - - - - - /
    Urun 1             <<sil>>   
    Urun 2             <<sil>>
    ....
    
    
    KULLANICI EKLEME FORMU
    -----------------------
    
    Kullanici Tipi:|  NORMAL  /  ADMIN       | (Combobox vb coktan tek secmeli olmali)
    Kullanici Adi: |_________________________| (Bos girise izin verme)
    Yas:           |_________________________| (Bos girise izin verme)
    Cinsiyet:      |_________________________| (Bos girise izin verme)
    Sifre:         |_________________________| (Bos girise izin verme)
    << Kullanici Kaydet >> (Submit button)
    
    
    URUN EKLEME FORMU
    -----------------------
    
    Urun Adi:      |_________________________| (Bos girise izin verme)
    Kategori:      |_________________________| (Combobox vb coktan tek secmeli olmali)
    Fiyat:         |_________________________| (Bos girise izin verme)
    << Urun Kaydet >> (Submit button)
    
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



## DERSLER

### Ders 1 - 13 EKIM
Java Tekrari
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders01

### Ders 2 - 27 EKIM
TCP Socket

Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders02

Bilgi: https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/_archive/00a_NetworkUygulamalari.pdf

### Ders 3 - 3 KASIM
Thread Programlama

Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders03

### Ders 4 - 10 KASIM
Java Swing GUI

Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders02

Bilgi:
* https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/_archive/06a_JavaGUI.pdf
* https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/_archive/07a_JavaGUI_1.pdf
* https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/_archive/07b_JavaGUI_2.pdf

### Ders 5 - 17 KASIM

### ARA SINAV PROJESI

#### Teslim Tarihi: 26 Kasim Pazartesi 23:59:59'a kadar ozkan.sari@outlook.com adresine sadece kod dosyalarinizi gonderiniz. Gec teslim kabul edilmeyecektir.

Vize Saatinde Projelerinizi Derste Sunacaksiniz. 
Sunum yapmayanlardan -40 puan eksiltilerek not verilecektir.
*Ayni ve benzer proje teslimlerini kopya olarak degerlendirilecektir*

Uygulama kodlarinizi tr/edu/medipol/ilerijava/vize/<<ad_soyad>>/ paketinde bulunmali <<ad_soyad>> yerine kendi ad ve soyadinizi yazmalisiniz.

#### Aciklama: 

Java ile Sunucu/Istemci (**Socket**) mimarisinde coklu akisi (Multi Thread) destekleyen bir hesaplama uygulamasi yapmanizi bekliyorum.
Sunucu ve Istemci(ler) iki ayri uygulama seklinde calismali. Bir **sunucuya birden fazla istemcinin TCP socket ile baglanmasi desteklenmeli**.

Sunucu tarafinda Java Swing GUI ile **giden gelen mesajlar** ve **bagli istemcilerin listesi** goruntulenmeli.

Istemci tarafinda ise Java Swing GUI ile istemciden **iki ayri sayi** ve **yapilacak islem tipi** ( +,-,/,* ) girdi olarak alinacak ve **GONDER butonu**na basildiginda sunucuya hesaplama islemi **tcp socket iletisimle mesaj olarak** gonderilecektir. Ornegin "2 * 55" gibi bir mesaj istemciden sunucuya gonderilecek.

Bu mesaji alan sunucu ise gelen mesajdaki hesaplama istegini algilayip, sonucu hesaplayacak ve istekte bulunan istemciye sonucu donecektir.

Istemci ise sonuc mesajini alip ekranda (ornegin labelda ya da disabled textfield'da) gosterecektir.


### Ders 6 - 1 ARALIK

Uygulama Maven Projeye Cevrildi: 
* https://github.com/ozkansari/MyCourses/tree/master/SocketChatApp

Apache Derby Veritabani Ornegi: 
* https://github.com/ozkansari/MyCourses/tree/master/DerbyVeritabaniOrnek

#### ODEV 1
Bir java masaustu ekraninda kullanicidan ayri ayri ad ve soyad girdi olarak alinacak. Gonder butonuna basinca veritabanina kaydedilecek.

Veritabani olarak derste gordugumuz sekilde maven projesi ve apache derby kullanilacak.

7 Aralik Cuma 23:59:59'a kadar ozkan.sari@outlook.com adresine sadece kod dosyalarinizi gonderiniz. Gec teslim kabul edilmeyecektir.

### Ders 7 - 8 ARALIK

Veritabani Uygulama Calismasi

### Ders 8 - 15 ARALIK

Veritabani Uygulama Calismasi

### Ders 9 - 22 ARALIK

Spark Java ile Web projesi : https://github.com/ozkansari/MyCourses/tree/master/WebProjesi
- https://freemarker.apache.org/docs/index.html

### Ders 10 - 29 ARALIK

Spark Java ile Web projesi (Devam) - Web form olusturma

#### ODEV 2

Dersteki web orneginde ogrenci ekleme formu olusturulmustu. Ayni formu ogretmen ekleme formu icin olusturunuz.

### Ders 11 - 5 OCAK

### Ders 12 - 12 OCAK

### FINAL SINAVI

---

## TAKVIM

* Hafta 1 - 13 EKIM : Ders 1 - Java Tekrari
* Hafta 2 - 20 EKIM : Lab Tamirati nedeniyle Ders yapilamadi
* Hafta 3 - 27 EKIM : Ders 2 - TCP Socket ve Thread Programlama
* Hafta 4 - 3 KASIM : Ders 3
* Hafta 5 - 10 KASIM : Ders 4
* Hafta 6 - 17 KASIM  : Ders 5
* Hafta 7 - 24 KASIM  : Ders Yapilamadi
* ARA SINAV PROJESI
* Hafta 8 - 1 ARALIK  : Ders 6 - Apache Derby Veritabani
* Hafta 9 - 8 ARALIK  : Ders 7 - Apache Derby Veritabani
* Hafta 10 - 15 ARALIK  : Ders 8 - Apache Derby Veritabani
* Hafta 11 - 22 ARALIK  : Ders 9 - Spark Java ile Web projesi
* Hafta 12 - 29 ARALIK  : Ders 10 - Spark Java ile Web projesi : Form Submit
* Hafta 13 - 5 OCAK  :
* Hafta 14 - 12 OCAK  :
* FINAL SINAVI PROJESI :
