# DEGERLENDIRME

## ON INCELEME

Model ve Servis paketleri nedir?
PreparedStatement derste gosterilmedi. Nereden ogrendin?

## SONUC

--

## ACIKLAMA *************************************************************************

### FINAL PROJESI - ALISVERIS SITESI (Web + Veritabani)

>>> _Son Guncelleme Tarihi: 6 Ocak 2019_

Spark Java Web ortaminda + Veritabanina kayit ve sorgulamanin yapildigi bir alisveris sitesi projesi yapmaniz gerekiyor. Proje ile ilgili aciklamalar detayli bir sekilde asagida aciklanmistir. 

Teslim Tarihi: Aciklanacak (Final Sinavindan 2 gun once 23:59'a kadar gonderilmeli. Yani Final sinavi 20 Ocak'da ise 18 Ocak 23:59:59'a kadar proje gonderimi yapilmis olmali)
ozkan.sari@outlook.com adresine sadece kod dosyalarinizi ve fina lproje raporunu gonderiniz. Gec teslim kabul edilmeyecektir.

Yaptiklariniz ekran goruntuleri ile aciklayan basit bir Final Proje raporu hazirlamaniz gerekmektedir. Tercihen Doc/docx yerine PDFe cevirip gondermelisiniz.

Yapilacaklar Ozet, Ayrintilar Asagida:
* 1-) giris_sayfasi.html , GirisSayfasi.java (http://localhost:4567//<<ad_soyadiniz>>/giris_sayfasi)
* 2-) uye_sayfasi.html, UyeSayfasi.java (http://localhost:4567//<<ad_soyadiniz>>/uye_sayfasi)
* 3-) anasayfa.html, Anasayfa.java (http://localhost:4567/<<ad_soyadiniz>>/)
* 4-) yonetici_anasayfa.html, YoneticiAnasayfa.java (http://localhost:4567/<<ad_soyadiniz>>/yonetici/)
* 5-) hata.html, HataSayfasi.java (http://localhost:4567/<<ad_soyadiniz>>/hata/)
* 6-) Uygulama main metodunu iceren ana uygulama sinifi: UygulamaMain.java
* 7-) 1. ve 2. maddelerle baglanti olarak cikis baglantisi/formu (http://localhost:4567//<<ad_soyadiniz>>/cikis)
* 8-) Final_Proje_Raporu_<<ad_soyadiniz>>.pdf

* Hersey "spark/template/freemarker/<<ad_soyadiniz>>/finalproje/" paketi icerisinde  olmali.

### Onemli Noktalar

* Final projesi sifirdan sade bir sekilde gelistirilmeli. Ornegin, Dersdeki kod ve projeler uzerinden devam ederek proje olustulmamali ve dersteki projeden ilerleyip proje ile alakasiz kodlar gonderilmemeli, isimlendirmelere dikkat edilmeli. Ayni sekilde internetten bulunan alakasiz derste gosterilmeyen kod ve teknolojiler kullanilmamali.
* Spark JAVA 1.1.1 ve Apache Derby 10.11.1.1 (dosya tabanli veritabani) versiyonlari kullanilmali. Derste ogretilenler disinda bir teknoloji kullanilmamali.
* Sinav zamani kodunuzu aciklamaniz istenecektir. Eger aciklayamazsaniz, projeyi sizin yapmadiginiz dusunulecektir.Benzer kod gonderimleri kopya olarak degerlendirilecektir ve bolum baskanligina bildirilecektir. 
* Proje maven projesi olmali.
* Kodlariniz (java ve html) src/main altinda "spark/template/freemarker/<<ad_soyadiniz>>/finalproje/" paketi icerisinde bulunmali. (<<ad_soyadiniz>> yerine kendi ad soyadinizi yaziniz)
* Sayfa adlari "/<<ad_soyadiniz>>/sayfa_adi" seklinde eslestirilmeli. (<<ad_soyadiniz>> yerine kendi ad soyadinizi yaziniz)
* Her bir sayfa icin ayri java sinifi olusturulmali. Tum bu ayri java siniflari, main metodu iceren ana bir Program sinifindan cagrilmali.
* Uygulamanizda tek bir main metodu bulunmali.
* Tum kodunuz tercihen javadoc ile dokumante edilmis olmali.
* Kodunuz okunakli, duzgun formatlanmis ve anlasilir olmali. Degisken, metod, class vb yerlerde turkce karakter kullanilmamali.

### Veritabani Tablolari

Veritabani tablo olusturma (CREATE) islemleri bir defaya mahsus yapilmali. Tablolar daha onceden olusturulduysa uygulama hata vermemeli ve calismaya devam etmeli.

#### "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre

* kullanici_adi: Veritabani tablosunda ayni kullanici adina sahip iki kullanici bulunamaz. (Silme islemleri kullanici_adi uzerinden yapilabilir)
* kullanici_tipi: "2. Kullanici Olusturma Sayfasi"ndan girislerde, kullanici tipi ekrandar girdi olarak alinmamali ve "NORMAL" degeri atanmali. Uygulamada iki tip kullanici olacak: NORMAL ve ADMIN. ADMIN kullanici uygulama acilirken java kodu ile bir defaya mahsus tabloya eklenecek (insert). 
* yas: yalnizca sayi girisine izin verilmeli.
* cinsiyet: K ya da E degerleri alabilir.
* sifre: Harf ve rakam girilebilir. kullanici_adi ve sifre birlikte giris islemlerinde kullanilacak.

#### "urunler" tablosu: urun_id, urun_adi, urun_kategori, fiyat

* urun_id : Sistem tarafindan atanan essiz bir id. Veritabani tablosunda ayni urun_idye sahip iki kayit olamaz.
* urun_adi : Urun adi.
* urun_kategori: Urun kategorisi.
* fiyat : Numerik TL olarak urun fiyati.

#### "siparisler" tablosu: siparis_id, kullanici_adi, urun_idler, toplam_ucret

* siparis_id : Sistem tarafindan atanan essiz bir id.
* kullanici_adi: Siparisi yapan kullanici adi
* urun_idler: siparise dahil urunlerin idleri. Virgul ile ayrilmis. Ornegin; 1,2,7,9
* toplam_ucret: urunlerin toplam fiyati

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

NOT 1: ADMIN kullanici uygulama acilirken java kodu ile bir defaya mahsus tabloya eklenecek (insert)

NOT 2: Test amaciyla,  kullanici adi "admin" sifre "admin" girildiginde ADMIN kullanicisi girisi,  kullanici adi "user" sifre "user" girildiginde NORMAL kullanici girisi yaptirabilirsiniz. Ancak bunun disindaki degerler icin veritabanindan kontrol yapilmali.

##### Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    (Hata mesaji varsa burada goruntulensin)
    
    Kullanici Adi: |_________________________| (Bos girise izin verme)
    
    Sifre:         |_________________________| (Bos girise izin verme)
    
    << Giris >> (Submit button)
    
    << Kullanici Olustur >> (Kullanici Olusturma Sayfasina baglanti)
    
     / - - - - - - - - - - - - - - - - - - - - - - - - - - /

#### 2. Normal Kullanici Olusturma Sayfasi:

    Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/uye_sayfasi"

Ekrandan "Kullanici Adi", "Yas", "Cinsiyet", "Sifre" girisleri yapildiktan sonra:
* "Uye Ol" butonuna basildiginda, , java kodu tarafinda veritabanindaki "kullanicilar" tablosuna ekleme islemi yapilacak. Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.
* "Vazgec" baglantisina tiklandiginda "1. Giris Sayfasi" sayfasina geri donulecek. Bu sayfadan sadece normal kullanici olusturulabilir. Yani olusturulan kullaniciya tip olarak "NORMAL" atanmali.

##### Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    Kullanici Adi: |_________________________| (Bos girise izin verme)
    
    Yas:           |_________________________| (Bos girise izin verme)
    
    Cinsiyet:      |   K  /  E               | (Combobox vb coktan tek secmeli olmali)
    
    Sifre:         |_________________________| (Bos girise izin verme)
    
    << Uye Ol >> (Submit button)
    
    << Vazgec >> (Giris sayfasina geri donecek)
    
     / - - - - - - - - - - - - - - - - - - - - - - - - - - /


#### 3. Normal Kullanici Anasayfa: 

    Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/"

##### Onemli Noktalar
* Bu sayfanin goruntulenmesine, eger giris yapilmamissa izin verilmemeli. Ayrica ADMIN tipindeki kullanicilar bu sayfayi goruntuleyemeyecek.
* Eger "1. Giris Sayfasi" uzerinden kullanici girisi yapilmadiysa, sayfanin goruntulenmesi engellenecek ve "1. Giris Sayfasi" adresine geri yonlendirilecek.
* Bkz. Asagidaki Ornek Sayfa Tasarimi

##### Cikis Yap
* Ekranda giris yapan kullanici adi gosterilmeli ve yaninda "Cikis Yap" linki/butonu bulunmali. Buna tiklandiginda giris yapan kullanici bilgileri temizlenmeli ve "1. Giris Sayfasi" adresine geri yonlendirilmeli.
* Bkz. Asagidaki Ornek Sayfa Tasarimi

    Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/cikis"

##### Urun Listesi
* Sayfa goruntulendiginde, sistemdeki tum urunler bilgileriyle tek tek her biri bir kutucuk icinde olmak uzere goruntulenebilmeli. 
* Listelenen her bir urun icin Sepete Ekle butonu bulunacak. Butona basildiginda **sepettekiler** kismina urun eklenecek.
* Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.
* Islem basariliysa ayni sayfaya geri donulecek.
* Bkz. Asagidaki Ornek Sayfa Tasarimi

##### Sepettekiler
* Sayfanin bir kosesinde sepet bilgisi goruntulenecek. Sepete Eklendikce sepettekiler de guncellenecek. Sepet bos ise bu kisim goruntulenmeyecek.
* Sepetteki urunler miktariyla birlikte listelenecek (Or.2 defa sepete eklenmis olabilir) 
* Siparis ver butonu olacak. Tiklaninca siparise ait, veritabani siparisler tablosuna kayit atilacak ve sepet bosaltilacak.
* Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.
* Islem basariliysa ayni sayfaya geri donulecek.
* Bkz. Asagidaki Ornek Sayfa Tasarimi

##### Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    GIRIS YAPAN KULLANICI: Kullanici 3 - <<Cikis Yap link/button>>
    
    / - - - /
    SEPETTEKILER (Sepet bos ise bu kisim goruntulenmeyecek.)
    Urun 1 - 1 adet
    Urun 4 - 3 adet
    Urun 7 - 2 adet
    <<siparis ver link/button>>
    / - - - /
    
    / - - - /
    URUNLER
    Urun 1 - Fiyat - <<sepete ekle link/button>>
    Urun 2 - Fiyat - <<sepete ekle link/button>>
    / - - - /
    
    ....
    
    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
#### 4. ADMIN Kullanici Anasayfa: 

    Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/yonetici/"

##### Onemli Noktalar
* Bu sayfanin goruntulenmesine, eger giris yapilmamissa ve giris yapan kullanici tipi ADMIN degilse izin verilmemeli.
* Eger "1. Giris Sayfasi" uzerinden kullanici girisi yapilmadiysa, sayfanin goruntulenmesi engellenecek ve "1. Giris Sayfasi" adresine geri yonlendirilecek.
* Eger giris yapan kullanici tipi ADMIN degilse "5. Hata Sayfasi" ekranina yonlendirilecek.

##### Cikis Yap
* Ekranda giris yapan kullanici adi gosterilmeli ve yaninda "Cikis Yap" linki/butonu bulunmali. Buna tiklandiginda giris yapan kullanici bilgileri temizlenmeli ve "1. Giris Sayfasi" adresine geri yonlendirilmeli.
* Bkz. Asagidaki Ornek Sayfa Tasarimi

    Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/cikis"
    
##### Kullanici ve Urun Listeleme & Kullanici Silme
* Sayfa goruntulendiginde, sistemdeki tum kullanicilar ve urunler ayri ayri  gosterilmeli ve her bir kullanici yaninda sil baglantisi bulunmali. Urun silinmeyecek.
* Sil baglantisina tiklandiginda, java kodu tarafinda kaydin silme islemi gerceklesmeli ve sonrasinda islem basariliysa mevcut kalan kayitlari gosterecek sekilde ayni sayfaya donulmeli. 
* Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.
* Islem basariliysa ayni sayfaya geri donulecek.

##### Kullanici ve Urun Ekleme Formlari
* Ayrica sayfada kullanici ve urun ekleme formlari bulunmali. 
* Eger islemde bir hata cikarsa, "5. Hata Sayfasi" ekranina yonlendirilecek.
* Islem basariliysa ayni sayfaya geri donulecek.


##### Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - -  
    
    GIRIS YAPAN KULLANICI: Kullanici X Admin - <<Cikis Yap linki/butonu>>
    
    SIPARISLER
    ------------
    KULLANICI ADI      SIPARIS NO
    / - - - - - /      / - - - - - /
    Kullanici 1        Siparis 1
    Kullanici 1        Siparis 2
    Kullanici 2        Siparis 3
    Kullanici 1        Siparis 4
    .....
    
    KULLANICILAR
    -------------
    KULLANICI ADI      ISLEM
    / - - - - - /      / - - - - - /
    Kullanici 1        <<sil>>   
    Kullanici 2        <<sil>>
    ....


    URUNLER
    -------------
    
    URUN ADI     
    / - - - - - /
    Urun 1               
    Urun 2             
    ....
    
    
    KULLANICI EKLEME FORMU
    -----------------------
    
    Kullanici Tipi:|  NORMAL  /  ADMIN       | (Combobox vb coktan tek secmeli olmali)
    Kullanici Adi: |_________________________| (Bos girise izin verme)
    Yas:           |_________________________| (Bos girise izin verme)
    Cinsiyet:      |   K  /  E               | (Combobox vb coktan tek secmeli olmali)
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

Normal tipteki bir kullanici "4. ADMIN Kullanici Anasayfa" ekranina eirsmeye calisirsa ya da uygulamada bir hata cikarsa, uygun bir mesajla birlikte bu sayfaya yonlendirilecek.

##### Ornek Sayfa tasarimi:

    / - - - - - - - - - - - - - - - - - - - - - - - - - - /
    
    HATA
    
    (Hata mesaji)
    
    / - - - - - - - - - - - - - - - - - - - - - - - - - - /

------------------------------------------------------------    

