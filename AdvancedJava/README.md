# ILERI JAVA UYGULAMALARI 2018 BAHAR

Dersler Cumartesi 09:00-10:00 ve 10:15-11:30 arasinda iki oturum halinde yapilacaktir.
Derse mazeretiniz yoksa %80 devam zorunludur. Derse devam ve derse katilimdan not verilecektir.

## BUTUNLEME PROJESI - SparkJava ile Web Projesi

Teslim Tarihi: 25 Haziran 23:59:59'a kadar ozkan.sari@outlook.com adresine sadece kod dosyalarinizi gonderiniz. Gec gonderim kabul edilmeyecektir.

Butunleme sinavi zamani, projelerinizi sunmaniz/anlatmaniz istenecektir.

    Bilgisayar Programcılığı Programı / 2. Sınıf - İLERİ JAVA UYGULAMALARI, Bütünleme
    A115	
    27.06.2018 18:30	

### Onemli Noktalar

* Spark JAVA 1.1.1 ve Apache Derby 10.11.1.1 versiyonlari kullanilmali. Derste ogretilenler disinda bir teknoloji kullanilmamali.
* Butunleme zamani kodunuzu aciklamaniz istenecektir. Eger aciklayamazsaniz, projeyi sizin yapmadiginiz dusunulecektir.
* Proje maven projesi olmali.
* Kodlariniz (java ve html) src/main altinda "spark/template/freemarker/ad_soyadiniz" paketi icerisinde bulunmali.
* Sayfa adlari "/ad_soyadiniz/sayfa_adi" seklinde eslestirilmeli.
* Her bir sayfa icin ayri java sinifi olusturulmali. Tum bu ayri java siniflari, main metodu iceren ana bir Program sinifindan cagrilmali.
* Uygulamanizda tek bir main metodu bulunmali.
* Tum kodunuz javadoc ile dokumante edilmis olmali.
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


## FiNAL PROJE - Kitap Satis Sitesi

Teslim Tarihi: 31 Mayis 23:59 ozkan.sari@outlook.com adresine sadece kod dosyalarinizi gonderiniz. Gec teslim kabul edilmeyecektir.
Sunum Tarihi: 2 Haziran 10:00 MYO LAB. (iMAC)

Sunum notu dusuk olan ogrenciden yuksek olana dogru sirayla yapilacaktir.

On yuz Spark Java ile veritabani baglantilari Apache Derby ile maven projesi olarak gerceklestirilmeli.

### Veritabani Tablolari

* kitaplar: id, adi, yazar adi, yazar soyadi, yayinevi, fiyati
* siparisler: id, siparis veren, toplam ucret

### Onemli Noktalar

* Maven projesi olmali.
* Kodlariniz (java ve html) src/main altinda "spark/template/freemarker/<<ad_soyadiniz>>" paketi icerisinde bulunmali.
* Sayfa adlari "/<<ad_soyadiniz>>/<<sayfa_adi>>" seklinde eslestirilmeli.
* Derste kullanilan teknolojiler / kutuphaneler disinda bir kutuphane kullanilmamali. (Derby DB & Spark Java)
* Tum kodunuz javadoc ile dokumante edilmis olmali.
* Kodunuz okunakli, duzgun formatlanmis ve anlasilir olmali. Degisken, metod, class vb yerlerde turkce karakter kullanilmamali.
* Sayfalar ortak ve guzel bir tasarima ve ilgili sayfalar arasinda gecis icin menuye sahip olmali. Gosterimde turkce karakter problemi bulunmamali.

### Kitap Listesi Sayfasi

* Ana Sayfa : 
  ** Kitaplar listelenecek (veritabani kitaplar tablosu)
  ** Listelenen her bir kitap hakkinda temel bilgiler gosterilecek. 
  ** Listelenen her bir urun icin Sepete Ekle butonu bulunacak. Butona basildiginda ayni sayfada kalinacak.
  ** Sayfanin bir kosesinde sepet bilgisi gorunutulenecek. Sepete Eklendikce sepettekiler de guncellenecek.

* Sepet
  ** Sepetteki urunler miktariyla birlikte listelenecek (Or.2 defa sepete eklenmis olabilir)
  ** Siparis ver butonu olacak. Tiklaninca siparis onay sayfasina gidilecek.
  
* Siparis Onay Sayfasi
  ** Siparis goruntulenecek.
  ** Adres girisi yapilacak.
  ** Siparis Onay tusuna basinca, veritabani siparisler tablosuna kayit atilacak.

### Yonetim Sayfalari

Sayfa adlari "/<<ad_soyadiniz>>/yonetim/<<sayfa_adi>>" seklinde eslestirilmeli.

* Kitap ekle (veritabanina kaydet)
* Kitap Listele ve Sil (veritabanindan listele ve silme yap)
* Kitap Goruntule/Detay
* Siparis Listele

### Bonus

* Kitap kategorilendirme (Roman,Hikaye,Klasikler vb.)
* Siparis sayfasinda kk bilgisi vs. alma
* Satin alma entegrasyonu: https://dev.iyzipay.com/tr veya https://developer.mastercard.com/product/masterpass (Test API)
* Siparislerle kitaplari baglantilandirma (bir kolonda virgul ile kitap idlerini tutabilirsiniz)

### Sik Sorulan Sorular?

* Fazla karisik olmamak kaydiyla hazir sablon kullanabilirsiniz. 

------------------------------------------------------------

## VIZE SONRASI ODEVLER

### VIZE SONRASI ODEV-1
( _Teslim Tarihi:11 Mayis Cuma 23:59:59_ )
Java Swing GUI uygulamasi olarak bir "Ogrenci Ekleme ve Goruntuleme" uygulamasi gelistirmelisiniz. 

Uygulamada yalnizca "Ogrenci ekleme" secenegi bulunacaktir. Ayrica eklenen ogrenciler, ekranda goruntulenecektir.

Ogrenci eklerken "Ad ve Soyad", "Bolum", "Giris Yili" vb. bilgiler girdi olarak alinacaktir. Bos girise izin verilmemelidir. Ayrica "Giris Yili" alanina sayi disinda bir deger girilmesine izin verilmemelidir.

Ogrenci Eklerken ID bilgisi sorulmayacak, ID sistem tarafindan otomatik atanmalidir. Goruntulerken ID bilgisi gosterilecektir.

Eklenen ogrenciler Apache Derby dosya tabanli veritabanina yazilmali (INSERT) ve gosterilirken veri tabanindan alinmalidir (SELECT).

------------------------------------------------------------

## ViZE PROJE

### Teslim Tarihi: 20 Nisan Cuma 23:59:59'a kadar ozkan.sari@outlook.com adresine sadece kod dosyalarinizi gonderiniz. Gec teslim kabul edilmeyecektir.

Vize Saatinde Projelerinizi Derste Sunacaksiniz. 
Sunum yapmayanlardan -40 puan eksiltilerek not verilecektir.
Ayni ve benzer proje teslimlerini kopya olarak degerlendirilecektir

### Aciklama: 

Java Swing GUI uygulamasi olarak calisan bir "Kutuphane Yonetim" uygulamasi gelistirmelisiniz. 

Uygulamada menu halinde asagidaki secenekler bulunacaktir: 
* Yayin evi ekle : Yayin evi adi ve e-posta adresi girdi olarak alinacaktir. Eklenen yayinevleri kitap eklemede secenek olarak sunulacaktir. E-posta adresi eklemede duzenli ifade (regular expression) kontrolu yapilmalidir. Hatali formatta e-posta girisine izin verilmemelidir. Ayni sekilde bos girise de izin verilmemelidir.
* Kitap Ekle : Sistemde eklenmis yayin evi yoksa kitap eklemeye izin verilmemelidir. Kitap eklerken kitap adi, yazari, turu, yayin evi, sayfa sayisi vb. sorular sorulacaktir. Yayin evi icin sisteme eklenenler arasindan secim yaptirilmalidir. Sayfa sayisi alanina sayi disinda bir deger girilmesine izin verilmemelidir. Ayni sekilde bos girise de izin verilmemelidir.
* Kitaplari Listele : Kitaplar bilgileriyle birlikte listelenebilecektir. Listelenen kitaplarin yaninda silme secenegi de bulunacaktir.
* cikis: Uygulamadan cikis

Uygulama cikista sistemdeki kayitlari dosyaya yazacak ve uygulama acilirken kaldigi yerden devam edebilmesi icin dosyadan kayitlari okuyacaktir. 

Onemli noktalar:
* Uygulamanizda Kitap ve Yayinevi isimli siniflar tanimlanmali ve bunlar sistemde ArrayList olarak tutulmali.
* Kullanici girislerinde bos girislere ya da sayfa sayisi gibi sayi beklenen yerlere harf girisine izin verilmemelidir.

------------------------------------------------------------

## VIZE ODEVLER


### VIZE ODEV-1

* 1-) *Hayvan* sinifi ve bundan tureyen *Kedi*, *Kopek*, *Zurafa* vb. siniflar olusturulacak. 
* 2-) Programin calisacagi main metodu iceren *HayvanatBahcesi* isimli bir sinif yapilacak.
* 3-) HayvanatBahcesi sinifi icine *sesCikar* isimli bir metod yapilacak. Bu metod *sesSeviyesi* ve *Hayvan* siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan siniflarina metod da tanimlanabilir.

    private static int sesCikar(int sesSeviyesi, Hayvan hayvan)

*ipucu:* https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/src/main/java/tr/edu/medipol/hafta02/IleriMatematik.java sinifindaki islemYap() metodundan fikir alabilirsiniz.

Odevleri *ozkan.sari@outlook.com* adresine (projenin tumunu degil) sadece kaynak dosyalari zipleyip gonderiniz.

### VIZE ODEV -2 

List<String> kullanimi ile hafta 5'te yapilan [ornegi](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/src/main/java/tr/edu/medipol/hafta05/DosyaOkumaYazma3.java) , List<OgrenciBilgi> seklinde String yerine tanimlayacaginiz OgrenciBilgi sinifi kullanarak yapiniz.

Bunun icin,
* OgrenciBilgi isimli bir class osuturun ve icine ogrenciAdSoyad isimli bir String nesne degiskeni ekleyin. Degiskenin private olmasina dikkat edin.
* Daha sonra OgrenciBilgi sinifini programinizda Dosya okurken, kullanicidan girdi alirken ve dosyaya yazarken kullanin.
* Programdaki tum List<String> kullanimlari List<OgrenciBilgi>  seklinde degismis olmali.

------------------------------------------------------------

## DERS ICERIKLERI

* [SUNUMLAR](https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/_docs)

### Hafta 1-2-3 : Java Konu Tekrarlari

* [1a_JavaProgramlamayaGiris](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/01a_JavaProgramlamayaGiris.pdf)
* [2a_Basit_veri_turleri](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/02a_Basit_veri_turleri.pdf)
* [2b_Degisken_tipleri](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/02b_Degisken_tipleri.pdf)
* [2c_NesnelerVeSiniflaraGiris](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/02c_NesnelerVeSiniflaraGiris.pdf)
* [3a_Denetleyiciler](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03a_Denetleyiciler.pdf)
* [3b_Operatorler](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03b_Operatorler.pdf)
* [3c_Donguler](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03c_Donguler.pdf)
* [3d_Karar_Ifadeleri](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03d_Karar_Ifadeleri.pdf)
* [3e_Faydali_Metotlar](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03e_Faydal%C4%B1_Metotlar.pdf)
* [3f_Karakter_String_Islemleri](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03f_Karakter_String_Islemleri.pdf)

### Hafta 4 : Diziler, Zaman, Duzenli Ifadeler (regular Expressions)

* [4a_Diziler](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/04a_Diziler.pdf)
* [4b_Zaman](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/04b_Zaman.pdf)
* [4c_Duzenli_Ifadeler](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/04c_Duzenli_Ifadeler.pdf)

### Hafta 5 : Dosya Islemleri ve Istisnalar

* [5a_Dosya_Islemleri](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/05a_Dosya_Islemleri.pdf)
* [5b_Istisnalar](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/05b_Istisnalar.pdf)

### Hafta 6 & 7 : Swing GUI

* [6a_JavaGUI](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/06a_JavaGUI.pdf)
* [7a_JavaGUI_1](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/07a_JavaGUI_1.pdf)
* [7b_JavaGUI_2](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/07b_JavaGUI_2.pdf)

### Hafta 7

    // Acilirken dosyadan oku
    ArrayList ogrenciListesi = new ArrayList();
    while(scanner.hasNext()) {
      String satir = scanner.nextLine();
      String [] alanlar = satir.split(",");
      Ogrenci ogrenci = new Ogrenci(alanlar[0], alanlar[1], alanlar [2], alanlar[3]);
      ogrenciListesi.add(ogrenci);
    }
    
    // Cikarken dosyaya yaz
    PrintWriter dosyaYazici ....
    for(Ogrenci : ogrenciListesi) {
       dosyaYazici.writeLine(ogrenci.getAd()+","+ogrenci.getSoyad()+","+ .....);
    }
    dosyaYazici.close();


## Notlar

![Notlar](https://raw.githubusercontent.com/ozkansari/MyCourses/master/AdvancedJava/_docs/Notlar.png)

