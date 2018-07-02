

-----------------------------------------------------------------------------------------------------------------------------------------------------
Onemli Noktalar
Spark JAVA 1.1.1 ve Apache Derby 10.11.1.1 versiyonlari kullanilmali. Derste ogretilenler disinda bir teknoloji kullanilmamali.
Butunleme zamani kodunuzu aciklamaniz istenecektir. Eger aciklayamazsaniz, projeyi sizin yapmadiginiz dusunulecektir.
Proje maven projesi olmali.
Kodlariniz (java ve html) src/main altinda “spark/template/freemarker/ad_soyadiniz” paketi icerisinde bulunmali.
Sayfa adlari “/ad_soyadiniz/sayfa_adi” seklinde eslestirilmeli.
Her bir sayfa icin ayri java sinifi olusturulmali. Tum bu ayri java siniflari, main metodu iceren ana bir Program sinifindan cagrilmali.
Uygulamanizda tek bir main metodu bulunmali.
Tum kodunuz javadoc ile dokumante edilmis olmali.
Kodunuz okunakli, duzgun formatlanmis ve anlasilir olmali. Degisken, metod, class vb yerlerde turkce karakter kullanilmamali.
Veritabani Tablolari
“kullanicilar” tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
kullanici_adi: Ayni kullanici adina sahip iki kullanici bulunamaz. (Silme islemleri kullanici_adi uzerinden yapilabilir)
kullanici_tipi: Ekrandan girilmemeli, “2. Kullanici Olusturma Sayfasi”ndan girislerde “NORMAL” degeri atanmali. Uygulamada iki tip kullanici olacak: NORMAL ve ADMIN. ADMIN kullanici uygulama acilirken java kodu ile bir defaya mahsus tabloya eklenecek (insert). Yani zaten admin kullanici varsa tabloya kayit olarak eklenmemeli.
yas: yanlizca sayi girisine izin verilmeli.
cinsiyet: K ya da E degerleri alabilir.
sifre: Harf ve rakam girilebilir. kullanici_adi ve sifre birlikte giris islemlerinde kullanilacak.

Proje Odevi Aciklamasi
1. Giris Sayfasi:
Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/giris_sayfasi"
Burada standart bir giris ekrani yapmanizi istiyorum.

“Kullanici Adi” ve “sifre” girisi yapildiktan sonra, kullanici “Giris” butonuna bastiginda, java kodu tarafinda kullanici ve sifre bilgileri kontrol edilecek.
“Kullanici Adi” ve “sifre” bilgileri veritabanindaki “kullanicilar” tablosundaki kayitlardan kontrol edilmeli.
Eger girilen “Kullanici Adi” ve “sifre” bilgileri, veritabanindaki “kullanicilar” tablosundaki her hangi bir kayit ile eslesiyorsa, sayfa “3. Normal Kullanici Anasayfa”sina yonlendirilmeli. Aksi durumda, ayni sayfaya bir hata mesajiyla geri donulmeli.
“Kullanici Olustur” baglantisina tiklandiginda ise “2. Kullanici Olusturma Sayfasi”na yonlendirilmeli.
Eger islemlerde bir hata cikarsa, “5. Hata Sayfasi” ekranina yonlendirilecek.

2. Kullanici Olusturma Sayfasi:
Yonlendirme adresi: "http://localhost:4567//<<ad_soyadiniz>>/uye_sayfasi"
Ekrandan “Kullanici Adi”, “Yas”, “Cinsiyet”, “Sifre” girisleri yapildiktan sonra:

“Uye Ol” butonuna basildiginda, , java kodu tarafinda veritabanindaki “kullanicilar” tablosuna ekleme islemi yapilacak. Eger islemde bir hata cikarsa, “5. Hata Sayfasi” ekranina yonlendirilecek.
“Vazgec” baglantisina tiklandiginda “1. Giris Sayfasi” sayfasina geri donulecek.
Ornek Sayfa tasarimi:

3. Normal Kullanici Anasayfa:
Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/"
Bu sayfanin goruntulenmesine, eger giris yapilmamissa izin verilmemeli. Eger “1. Giris Sayfasi” uzerinden kullanici girisi yapilmadiysa, sayfanin goruntulenmesi engellenecek ve “1. Giris Sayfasi” adresine geri yonlendirilecek. Sayfa goruntulendiginde, sistemdeki tum kullanicilar bilgileriyle tek tek her biri bir kutucuk icinde olmak uzere goruntulenebilmeli.

4. ADMIN Kullanici Anasayfa:
Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/yonetici/"
Bu sayfanin goruntulenmesine, eger giris yapilmamissa ve giris yapan kullanici tipi ADMIN degilse izin verilmemeli. Eger “1. Giris Sayfasi” uzerinden kullanici girisi yapilmadiysa, sayfanin goruntulenmesi engellenecek ve “1. Giris Sayfasi” adresine geri yonlendirilecek. Eger giris yapan kullanici tipi ADMIN degilse “5. Hata Sayfasi” ekranina yonlendirilecek. Sayfa goruntulendiginde, sistemdeki tum kullanicilar tablo halinde gosterilmeli ve her bir kullanici yaninda sil baglantisi bulunmali. Sil baglantisina tiklandiginda, java kodu tarafinda kullanicilar tablosundan secilen kullanicinin silme islemi gerceklesmeli ve sonrasinda islem basariliysa mevcut kalan kullanicilari gosterecek sekilde ayn sayfaya donulmeli. Eger islemde bir hata cikarsa, “5. Hata Sayfasi” ekranina yonlendirilecek.v

5. Hata Sayfasi:
Yonlendirme adresi: "http://localhost:4567/<<ad_soyadiniz>>/hata/"
Normal tipteki bir kullanici “4. ADMIN Kullanici Anasayfa” ekranna eirsmeye calisirsa ya da uygulamada bir hata cikarsa, uygun bir mesajla birlikte bu sayfaya yonlendirilecek.

