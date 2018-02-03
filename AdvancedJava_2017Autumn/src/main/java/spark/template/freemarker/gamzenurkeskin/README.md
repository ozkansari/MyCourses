Yönetim sayfaları Urun ekle, sil, listele var guncelle yok.
Magazada sepete kleyemiyor. Sepet goruntule ekranı var.

Kodlarınız "spark/template/freemarker/<<ad_soyadiniz>>" paketi içerisinde bulunmalı. --> HAYIR (-5)

----------------------------------

### Kullanıcı Sayfaları

Sayfa adları "/<<ad_soyadiniz>>/<<sayfa_adi>>" şeklinde eşleştirilmeli. --> HAYIR (-5)

* Ana Sayfa : 
  * Ürünler listelenecek
  * Listelenen her bir ürün hakkında temel bilgiler gösterilecek. 
  * Listelenen her bir ürün için Sepete Ekle butonu bulunacak. Butona basıldığında aynı sayfada kalınacak.
  * Sayfanın bir köşesinde sepet bilgisi görünütülenecek. Sepete Eklendikçe sepettekiler de güncellenecek.

* Sepet
  * Sepetteki ürünler miktarıyla birlikte listelenecek (Ör.2 defa sepete eklenmiş olabilir)
  * Sipariş ver butonu olacak. Tıklanınca sipariş onay sayfasına gidilecek.

### Yönetim Sayfaları

Sayfa adları "/<<ad_soyadiniz>>/yonetim/<<sayfa_adi>>" şeklinde eşleştirilmeli. --> HAYIR (-5)

* Urun ekle
* Urun Listele ve Sil
* Ürün Görüntüle/Detay
* Sipariş Listele

### Önemli Noktalar

* Maven projesi olmalı.
* Kodlarınız "spark/template/freemarker/<<ad_soyadiniz>>" paketi içerisinde bulunmalı. --> HAYIR (-5)
* Derste kullanılan teknolojiler / kütüphaneler dışında bir kütüphane kullanılmamalı. (Derby DB & Spark Java)
* Tüm kodunuz javadoc ile dokümante edilmiş olmalı.
* Kodunuz okunaklı, düzgün formatlanmış ve anlaşılır olmalı. Değişken, metod, class vb yerlerde türkçe karakter kullanılmamalı.
* Sayfalar ortak ve güzel bir tasarıma ve ilgili sayfalar arasında geçiş için menüye sahip olmalı. Gösterimde türkçe karakter problemi bulunmamalı.

### Bonus

* Ürün kategorilendirme
* Sipariş sayfasında adres bilgisi, kk bilgisi vs. alma
* Satın alma entegrasyonu: https://dev.iyzipay.com/tr veya https://developer.mastercard.com/product/masterpass (Test API)