# ILERI JAVA UYGULAMALARI

2017 GÜZ - BPR216050 / BPR226050

Dersler Cumartesi 09:00-10:00 ve 10:15-11:30 arasında iki oturum halinde yapılacaktır.
Derse %80 devam zorunludur. Derse devam ve derse katılımdan not verilecektir.

## FİNAL PROJE - Alışveriş Sİtesi

### Kullanıcı Sayfaları

Sayfa adları "/<<ad_soyadiniz>>/<<sayfa_adi>>" şeklinde eşleştirilmeli.

* Ana Sayfa : 
** Ürünler listelenecek
** Listelenen her bir ürün hakkında temel bilgiler gösterilecek. 
** Listelenen her bir ürün için Sepete Ekle butonu bulunacak. Butona basıldığında aynı sayfada kalınacak.
** Sayfanın bir köşesinde sepet bilgisi görünütülenecek. Sepete Eklendikçe sepettekiler de güncellenecek.

* Sepet
** Sepetteki ürünler miktarıyla birlikte listelenecek (Ör.2 defa sepete eklenmiş olabilir)
** Sipariş ver butonu olacak. Tıklanınca sipariş onay sayfasına gidilecek.

### Yönetim Sayfaları

Sayfa adları "/<<ad_soyadiniz>>/yonetim/<<sayfa_adi>>" şeklinde eşleştirilmeli.

* Urun ekle
* Urun Listele ve Sil
* Ürün Görüntüle/Detay
* Sipariş Listele

### Önemli Noktalar

* Maven projesi olmalı.
* Kodlarınız "spark/template/freemarker/<<ad_soyadiniz>>" paketi içerisinde bulunmalı.
* Derste kullanılan teknolojiler / kütüphaneler dışında bir kütüphane kullanılmamalı. (Derby DB & Spark Java)
* Tüm kodunuz javadoc ile dokümante edilmiş olmalı.
* Kodunuz okunaklı, düzgün formatlanmış ve anlaşılır olmalı. Değişken, metod, class vb yerlerde türkçe karakter kullanılmamalı.
* Sayfalar ortak ve güzel bir tasarıma ve ilgili sayfalar arasında geçiş için menüye sahip olmalı. Gösterimde türkçe karakter problemi bulunmamalı.

### Bonus

* Ürün kategorilendirme
* Sipariş sayfasında adres bilgisi, kk bilgisi vs. alma
* Satın alma entegrasyonu: https://dev.iyzipay.com/tr

## VİZE ODEVLER

Odevleri ozkan.sari@outlook.com adresine gönderebilirsiniz.

### ODEV-1: Metin İcinde harf Arama Uygulamasi
(Teslim Süresi Geçti)
Kullanicidan oncelikle bir metin girmesi istenir. 
Daha sonra bu metin icinde aranilacak harf istenir. 
Aranan harfin metinde hangi indekslerde gectigi birer birer yazdirilir. Harf metin icerisinde gecmiyorsa, metin bulunamadi yazilir.

### ODEV-2 : Randevu Konsol Uygulamasi
(Teslim Süresi Geçti)
Kullanici sisteme randevu bilgileri girebilir. Bu bilgiler sunlardir: randevu adi, yeri, tarih-saati.
Uygulamaniz 5 adet randevu girisini destekleyecek. Sonrasinda randevu bilgileri listelenecektir.
BONUS: Kullaniciya menu halinde randevu girisi, listele ve cikissecenekleri sunulmasi.


## VİZE PROJE

# YAPTIKLARI PROJEYİ A4 KAĞITLARINA/DEFTERLERİNE YAZANLARA (ÇIKTI DEĞİL) VE ÖDEVİ ADIM ADIM AÇIKLAYANLARA EK PUAN VERİLECEKTİR #

### Teslim Tarihi: 09.12.2017 10:00 MYO LAB.(GİRİŞ) 
Vize Saatinde Projelerinizi Derste Sunacaksınız. Vizeye gelmeyen projeden de sıfır alacaktır.
### Aciklama: 
(Aynı ve benzer proje teslimlerini kopya olarak değerlendirilecektir)
Java Swing GUI uygulamasi olarak calisan bir Magaza Yonetim Programi uygulamasi yapilacak. 
Uygulamada menu halinde gosterilecek 1-) Calisan Ekle/Sil/Listele 2-) Stok Ekle/Sil/listele 3-) Cikis secenekleri olacaktir.  
Uygulama kalitim ve cok yuzluluk (polimorfizm) iliskisi ile farkli calisan ve stok tiplerini destekleyecektir: Stajyer/Personel/Mudur ve Giysi/Aksesuar/Yiyecek vb.
Uygulama cikista sistemdeki kayitlari dosyaya yazacak ve uygulama acilirken kaldigi yerden devam edebilmesi icin dosyadan kayitlari okuyacaktir. 

## DERS ICERIKLERI

### Hafta 1-2

- [2d_JavaOzet1](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/2d_JavaOzet1.pdf)

- [1a_JavaProgramlamayaGiris](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/1a_JavaProgramlamayaGiris.pdf)
- [2a_Basit_veri_turleri](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/2a_Basit_veri_turleri.pdf)
- [2a_Basit_veri_turleri](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/2a_Basit_veri_turleri.pdf)
- [2c_NesnelerVeSiniflaraGiris](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/2c_NesnelerVeSiniflaraGiris.pdf)

- [lab hafta1](https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava_2017Autumn/src/main/java/tr/edu/medipol/hafta1)
- [lab hafta2](https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava_2017Autumn/src/main/java/tr/edu/medipol/hafta2)

### Hafta 3

- [3a_Denetleyiciler](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/3a_Denetleyiciler.pdf)
- [3b_Operatorler](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/3b_Operatorler.pdf)
- [3c_Donguler](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/3c_Donguler.pdf)
- [3d_Karar_Ifadeleri](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/3d_Karar_Ifadeleri.pdf)
- [3e_Faydalı_Metotlar](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/3e_Faydalı_Metotlar.pdf)
- [3f_Karakter_String_Islemleri](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/3f_Karakter_String_Islemleri.pdf)
- [3g_Diziler](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/3g_Diziler.pdf)
- [3h_Zaman](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/3h_Zaman.pdf)
- [3i_Duzenli_Ifadeler](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/3i_Duzenli_Ifadeler.pdf)
- [lab hafta3](https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava_2017Autumn/src/main/java/tr/edu/medipol/hafta3)

### Hafta 4

- [4a_Diziler](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/4a_Diziler.pdf)
- [4b_Zaman](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/4b_Zaman.pdf)
- [4c_Duzenli_Ifadeler](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/4c_Duzenli_Ifadeler.pdf)
- [lab hafta4](https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava_2017Autumn/src/main/java/tr/edu/medipol/hafta4)

### Hafta 5

- [5a_Dosya_Islemleri](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/5a_Dosya_Islemleri.pdf)
- [5b_Istisnalar](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/5b_Istisnalar.pdf)
- [lab hafta5](https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava_2017Autumn/src/main/java/tr/edu/medipol/hafta5)

### Hafta 6

- [GUI 1](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/6a_JavaGUI.pdf)
- [lab hafta6](https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava_2017Autumn/src/main/java/tr/edu/medipol/hafta6)

### Hafta 7

- [GUI 1](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/7a_JavaGUI_1.pdf)
- [GUI 2](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/7b_JavaGUI_2.pdf)

### Hafta 8

- [Javadoc  ](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava_2017Autumn/_docs/8a_Javadoc.pdf)
- [Kalitim ve Kapsulleme](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava_2017Autumn/_docs/8b_Kalitim_Kapsulleme.pdf)
- [Arayuzler ve Uzerine Yazma](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava_2017Autumn/_docs/8c_Arazyuzler_UzerineYazma.pdf)

### Hafta 9

- [Network Uygulamaları](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava_2017Autumn/_docs/9a_NetworkUygulamalari.pdf)

### Hafta 10

- [Veritabanı](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava_2017Autumn/_docs/10a_JavaVeritabaniBaglantilari.pdf)

## Notlar

![NOTLAR](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava_2017Autumn/_docs/NotlarIleriJavaGuz2017.PNG?hafta=10)
