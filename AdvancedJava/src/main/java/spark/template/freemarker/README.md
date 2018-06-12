# FiNAL PROJE - Kitap Satis Sitesi

********************************************************************************

## DEGERLENDIRME


### Gec gonderim
-20

### Kodlariniz src/main altinda "spark/template/freemarker/<<ad_soyadiniz>>" paketi icerisinde bulunmali.
--> Bulunmuyorsa: -5

### Sayfa adlari "/<<ad_soyadiniz>>/" seklinde eslestirilmeli.
--> Bulunmuyorsa: -5

### Kod derlenmiyorsa
--> Ufak Hata: -5
--> Ciddi Hata: -10

### Javadoc'lar: 10/10

### Fonksiyonlar
- (/20) Ana Sayfa: kitap liste + sepet atma + sepettekiler
- (/15) Siparis Onay Sayfasi
- (/15) Kitap ekle (veritabanina kaydet)
- (/20) Kitap Listele ve Sil (veritabanindan listele ve silme yap)
- (/15) Kitap Goruntule/Detay
- (/15) Siparis Listele



********************************************************************************

Teslim Tarihi: 31 Mayis 23:59 ozkan.sari@outlook.com adresine sadece kod dosyalarinizi gonderiniz. Gec teslim kabul edilmeyecektir. Sunum Tarihi: 2 Haziran 10:00 MYO LAB. (iMAC)

Sunum notu dusuk olan ogrenciden yuksek olana dogru sirayla yapilacaktir.

On yuz Spark Java ile veritabani baglantilari Apache Derby ile maven projesi olarak gerceklestirilmeli.

Veritabani Tablolari
kitaplar: id, adi, yazar adi, yazar soyadi, yayinevi, fiyati
siparisler: id, siparis veren, toplam ucret
Onemli Noktalar
Maven projesi olmali.
Kodlariniz src/main altinda "spark/template/freemarker/<<ad_soyadiniz>>" paketi icerisinde bulunmali.
Sayfa adlari "/<<ad_soyadiniz>>/<<sayfa_adi>>" seklinde eslestirilmeli.
Derste kullanilan teknolojiler / kutuphaneler disinda bir kutuphane kullanilmamali. (Derby DB & Spark Java)
Tum kodunuz javadoc ile dokumante edilmis olmali.
Kodunuz okunakli, duzgun formatlanmis ve anlasilir olmali. Degisken, metod, class vb yerlerde turkce karakter kullanilmamali.
Sayfalar ortak ve guzel bir tasarima ve ilgili sayfalar arasinda gecis icin menuye sahip olmali. Gosterimde turkce karakter problemi bulunmamali.
Kitap Listesi Sayfasi
Ana Sayfa : ** Kitaplar listelenecek (veritabani kitaplar tablosu) ** Listelenen her bir kitap hakkinda temel bilgiler gosterilecek. ** Listelenen her bir urun icin Sepete Ekle butonu bulunacak. Butona basildiginda ayni sayfada kalinacak. ** Sayfanin bir kosesinde sepet bilgisi gorunutulenecek. Sepete Eklendikce sepettekiler de guncellenecek.

Sepet ** Sepetteki urunler miktariyla birlikte listelenecek (Or.2 defa sepete eklenmis olabilir) ** Siparis ver butonu olacak. Tiklaninca siparis onay sayfasina gidilecek.

Siparis Onay Sayfasi ** Siparis goruntulenecek. ** Adres girisi yapilacak. ** Siparis Onay tusuna basinca, veritabani siparisler tablosuna kayit atilacak.

Yonetim Sayfalari
Sayfa adlari "/<<ad_soyadiniz>>/yonetim/<<sayfa_adi>>" seklinde eslestirilmeli.

Kitap ekle (veritabanina kaydet)
Kitap Listele ve Sil (veritabanindan listele ve silme yap)
Kitap Goruntule/Detay
Siparis Listele
Bonus
Kitap kategorilendirme (Roman,Hikaye,Klasikler vb.)
Siparis sayfasinda kk bilgisi vs. alma
Satin alma entegrasyonu: https://dev.iyzipay.com/tr veya https://developer.mastercard.com/product/masterpass (Test API)
Siparislerle kitaplari baglantilandirma (bir kolonda virgul ile kitap idlerini tutabilirsiniz)
Sik Sorulan Sorular?
Fazla karisik olmamak kaydiyla hazir sablon kullanabilirsiniz.
Derste ogrendiginiz uzere, Maven projesinde html, ftl, imaj, properties, js vb. dosyalar src/main/resources/ altina konulabilir.