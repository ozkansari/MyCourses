# FİNAL PROJE - Kitap Satış Sitesi

********************************************************************************

## DEGERLENDIRME


### Gec gonderim
-20

### Kodlarınız src/main altinda "spark/template/freemarker/<<ad_soyadiniz>>" paketi içerisinde bulunmalı.
--> Bulunmuyorsa: -5

### Sayfa adları "/<<ad_soyadiniz>>/" şeklinde eşleştirilmeli.
--> Bulunmuyorsa: -5

### Kod derlenmiyorsa
--> Ufak Hata: -5
--> Ciddi Hata: -10

### Javadoc'lar: 10/10

### Fonksiyonlar
- (/20) Ana Sayfa: kitap liste + sepet atma + sepettekiler
- (/15) Sipariş Onay Sayfası
- (/15) Kitap ekle (veritabanina kaydet)
- (/20) Kitap Listele ve Sil (veritabanindan listele ve silme yap)
- (/15) Kitap Görüntüle/Detay
- (/15) Sipariş Listele



********************************************************************************

Teslim Tarihi: 31 Mayıs 23:59 ozkan.sari@outlook.com adresine sadece kod dosyalarınızı gönderiniz. Geç teslim kabul edilmeyecektir. Sunum Tarihi: 2 Haziran 10:00 MYO LAB. (İMAC)

Sunum notu düşük olan öğrenciden yüksek olana doğru sırayla yapılacaktır.

Ön yüz Spark Java ile veritabanı bağlantıları Apache Derby ile maven projesi olarak gerçekleştirilmeli.

Veritabani Tabloları
kitaplar: id, adi, yazar adi, yazar soyadi, yayinevi, fiyatı
siparişler: id, sipariş veren, toplam ucret
Önemli Noktalar
Maven projesi olmalı.
Kodlarınız src/main altinda "spark/template/freemarker/<<ad_soyadiniz>>" paketi içerisinde bulunmalı.
Sayfa adları "/<<ad_soyadiniz>>/<<sayfa_adi>>" şeklinde eşleştirilmeli.
Derste kullanılan teknolojiler / kütüphaneler dışında bir kütüphane kullanılmamalı. (Derby DB & Spark Java)
Tüm kodunuz javadoc ile dokümante edilmiş olmalı.
Kodunuz okunaklı, düzgün formatlanmış ve anlaşılır olmalı. Değişken, metod, class vb yerlerde türkçe karakter kullanılmamalı.
Sayfalar ortak ve güzel bir tasarıma ve ilgili sayfalar arasında geçiş için menüye sahip olmalı. Gösterimde türkçe karakter problemi bulunmamalı.
Kitap Listesi Sayfası
Ana Sayfa : ** Kitaplar listelenecek (veritabani kitaplar tablosu) ** Listelenen her bir kitap hakkında temel bilgiler gösterilecek. ** Listelenen her bir ürün için Sepete Ekle butonu bulunacak. Butona basıldığında aynı sayfada kalınacak. ** Sayfanın bir köşesinde sepet bilgisi görünütülenecek. Sepete Eklendikçe sepettekiler de güncellenecek.

Sepet ** Sepetteki ürünler miktarıyla birlikte listelenecek (Ör.2 defa sepete eklenmiş olabilir) ** Sipariş ver butonu olacak. Tıklanınca sipariş onay sayfasına gidilecek.

Sipariş Onay Sayfası ** Sipariş görüntülenecek. ** Adres girişi yapılacak. ** Sipariş Onay tuşuna basınca, veritabani siparisler tablosuna kayıt atılacak.

Yönetim Sayfaları
Sayfa adları "/<<ad_soyadiniz>>/yonetim/<<sayfa_adi>>" şeklinde eşleştirilmeli.

Kitap ekle (veritabanina kaydet)
Kitap Listele ve Sil (veritabanindan listele ve silme yap)
Kitap Görüntüle/Detay
Sipariş Listele
Bonus
Kitap kategorilendirme (Roman,Hikaye,Klasikler vb.)
Sipariş sayfasında kk bilgisi vs. alma
Satın alma entegrasyonu: https://dev.iyzipay.com/tr veya https://developer.mastercard.com/product/masterpass (Test API)
Siparişlerle kitaplari baglantilandirma (bir kolonda virgül ile kitap idlerini tutabilirsiniz)
Sık Sorulan Sorular?
Fazla karışık olmamak kaydıyla hazır şablon kullanabilirsiniz.
Derste öğrendiğiniz üzere, Maven projesinde html, ftl, imaj, properties, js vb. dosyalar src/main/resources/ altına konulabilir.