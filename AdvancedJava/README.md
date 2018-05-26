# ILERI JAVA UYGULAMALARI 2018 BAHAR

Dersler Cumartesi 09:00-10:00 ve 10:15-11:30 arasında iki oturum halinde yapılacaktır.
Derse mazeretiniz yoksa %80 devam zorunludur. Derse devam ve derse katılımdan not verilecektir.

## FİNAL PROJE - Kitap Satış Sitesi

Teslim Tarihi: 31 Mayıs 23:59 ozkan.sari@outlook.com adresine sadece kod dosyalarınızı gönderiniz. Geç teslim kabul edilmeyecektir.
Sunum Tarihi: 2 Haziran 10:00 MYO LAB. (İMAC)

Sunum notu düşük olan öğrenciden yüksek olana doğru sırayla yapılacaktır.

Ön yüz Spark Java ile veritabanı bağlantıları Apache Derby ile maven projesi olarak gerçekleştirilmeli.

### Veritabani Tabloları

* kitaplar: id, adi, yazar adi, yazar soyadi, yayinevi, fiyatı
* siparişler: id, sipariş veren, toplam ucret

### Önemli Noktalar

* Maven projesi olmalı.
* Kodlarınız src/main altinda "spark/template/freemarker/<<ad_soyadiniz>>" paketi içerisinde bulunmalı.
* Sayfa adları "/<<ad_soyadiniz>>/<<sayfa_adi>>" şeklinde eşleştirilmeli.
* Derste kullanılan teknolojiler / kütüphaneler dışında bir kütüphane kullanılmamalı. (Derby DB & Spark Java)
* Tüm kodunuz javadoc ile dokümante edilmiş olmalı.
* Kodunuz okunaklı, düzgün formatlanmış ve anlaşılır olmalı. Değişken, metod, class vb yerlerde türkçe karakter kullanılmamalı.
* Sayfalar ortak ve güzel bir tasarıma ve ilgili sayfalar arasında geçiş için menüye sahip olmalı. Gösterimde türkçe karakter problemi bulunmamalı.

### Kitap Listesi Sayfası

* Ana Sayfa : 
  ** Kitaplar listelenecek (veritabani kitaplar tablosu)
  ** Listelenen her bir kitap hakkında temel bilgiler gösterilecek. 
  ** Listelenen her bir ürün için Sepete Ekle butonu bulunacak. Butona basıldığında aynı sayfada kalınacak.
  ** Sayfanın bir köşesinde sepet bilgisi görünütülenecek. Sepete Eklendikçe sepettekiler de güncellenecek.

* Sepet
  ** Sepetteki ürünler miktarıyla birlikte listelenecek (Ör.2 defa sepete eklenmiş olabilir)
  ** Sipariş ver butonu olacak. Tıklanınca sipariş onay sayfasına gidilecek.
  
* Sipariş Onay Sayfası
  ** Sipariş görüntülenecek.
  ** Adres girişi yapılacak.
  ** Sipariş Onay tuşuna basınca, veritabani siparisler tablosuna kayıt atılacak.

### Yönetim Sayfaları

Sayfa adları "/<<ad_soyadiniz>>/yonetim/<<sayfa_adi>>" şeklinde eşleştirilmeli.

* Kitap ekle (veritabanina kaydet)
* Kitap Listele ve Sil (veritabanindan listele ve silme yap)
* Kitap Görüntüle/Detay
* Sipariş Listele

### Bonus

* Kitap kategorilendirme (Roman,Hikaye,Klasikler vb.)
* Sipariş sayfasında kk bilgisi vs. alma
* Satın alma entegrasyonu: https://dev.iyzipay.com/tr veya https://developer.mastercard.com/product/masterpass (Test API)
* Siparişlerle kitaplari baglantilandirma (bir kolonda virgül ile kitap idlerini tutabilirsiniz)

### Sık Sorulan Sorular?

* Fazla karışık olmamak kaydıyla hazır şablon kullanabilirsiniz. 
* Derste öğrendiğiniz üzere, Maven projesinde html, ftl, imaj, properties, js vb. dosyalar src/main/resources/ altına konulabilir.


## VIZE SONRASI ODEVLER

### VIZE SONRASI ODEV-1
( _Teslim Tarihi:11 Mayıs Cuma 23:59:59_ )
Java Swing GUI uygulamasi olarak bir "Öğrenci Ekleme ve Görüntüleme" uygulaması geliştirmelisiniz. 

Uygulamada yalnızca "Öğrenci ekleme" seçeneği bulunacaktır. Ayrıca eklenen öğrenciler, ekranda görüntülenecektir.

Öğrenci eklerken "Ad ve Soyad", "Bölüm", "Giriş Yılı" vb. bilgiler girdi olarak alınacaktır. Boş girişe izin verilmemelidir. Ayrıca "Giriş Yılı" alanına sayı dışında bir değer girilmesine izin verilmemelidir.

Öğrenci Eklerken ID bilgisi sorulmayacak, ID sistem tarafından otomatik atanmalıdır. Görüntülerken ID bilgisi gösterilecektir.

Eklenen öğrenciler Apache Derby dosya tabanlı veritabanına yazılmalı (INSERT) ve gösterilirken veri tabanından alınmalıdır (SELECT).

## VİZE PROJE

### Teslim Tarihi: 20 Nisan Cuma 23:59:59'a kadar ozkan.sari@outlook.com adresine sadece kod dosyalarınızı gönderiniz. Geç teslim kabul edilmeyecektir.

Vize Saatinde Projelerinizi Derste Sunacaksınız. 
Sunum yapmayanlardan -40 puan eksiltilerek not verilecektir.
Aynı ve benzer proje teslimlerini kopya olarak değerlendirilecektir

### Aciklama: 

Java Swing GUI uygulamasi olarak çalışan bir "Kütüphane Yönetim" uygulaması geliştirmelisiniz. 

Uygulamada menu halinde aşağıdaki seçenekler bulunacaktır: 
* Yayın evi ekle : Yayın evi adı ve e-posta adresi girdi olarak alınacaktır. Eklenen yayınevleri kitap eklemede seçenek olarak sunulacaktır. E-posta adresi eklemede düzenli ifade (regular expression) kontrolü yapılmalıdır. Hatalı formatta e-posta girişine izin verilmemelidir. Aynı şekilde boş girişe de izin verilmemelidir.
* Kitap Ekle : Sistemde eklenmiş yayın evi yoksa kitap eklemeye izin verilmemelidir. Kitap eklerken kitap adı, yazarı, türü, yayın evi, sayfa sayısı vb. sorular sorulacaktır. Yayın evi için sisteme eklenenler arasından seçim yaptırılmalıdır. Sayfa sayısı alanına sayı dışında bir değer girilmesine izin verilmemelidir. Aynı şekilde boş girişe de izin verilmemelidir.
* Kitapları Listele : Kitaplar bilgileriyle birlikte listelenebilecektir. Listelenen kitapların yanında silme seçeneği de bulunacaktır.
* Çıkış: Uygulamadan çıkış

Uygulama çıkışta sistemdeki kayitlari dosyaya yazacak ve uygulama acilirken kaldigi yerden devam edebilmesi icin dosyadan kayitlari okuyacaktir. 

Önemli noktalar:
* Uygulamanızda Kitap ve Yayinevi isimli sınıflar tanımlanmalı ve bunlar sistemde ArrayList olarak tutulmalı.
* Kullanıcı girişlerinde boş girişlere ya da sayfa sayısı gibi sayı beklenen yerlere harf girişine izin verilmemelidir.

## VIZE ODEVLER

### VIZE ODEV-1

* 1-) *Hayvan* sınıfı ve bundan türeyen *Kedi*, *Kopek*, *Zurafa* vb. sınıflar olusturulacak. 
* 2-) Programin calisacagi main metodu iceren *HayvanatBahcesi* isimli bir sinif yapilacak.
* 3-) HayvanatBahcesi sinifi icine *sesCikar* isimli bir metod yapilacak. Bu metod *sesSeviyesi* ve *Hayvan* siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan sınıflarına metod da tanımlanabilir.

    private static int sesCikar(int sesSeviyesi, Hayvan hayvan)

*İpucu:* https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/src/main/java/tr/edu/medipol/hafta02/IleriMatematik.java sınıfındaki islemYap() metodundan fikir alabilirsiniz.

Odevleri *ozkan.sari@outlook.com* adresine (projenin tümünü değil) sadece kaynak dosyaları zipleyip gönderiniz.

### VIZE ODEV -2 

List<String> kullanımı ile hafta 5'te yapılan [örneği](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/src/main/java/tr/edu/medipol/hafta05/DosyaOkumaYazma3.java) , List<OgrenciBilgi> seklinde String yerine tanımlayacağınız OgrenciBilgi sinifi kullanarak yapınız.

Bunun icin,
* OgrenciBilgi isimli bir class osuturun ve icine ogrenciAdSoyad isimli bir String nesne degişkeni ekleyin. Değişkenin private olmasına dikkat edin.
* Daha sonra OgrenciBilgi sınıfını programınızda Dosya okurken, kullanıcıdan girdi alırken ve dosyaya yazarken kullanın.
* Programdaki tüm List<String> kullanımları List<OgrenciBilgi>  şeklinde değişmiş olmalı.

## DERS ICERIKLERI

* [SUNUMLAR](https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/_docs)

### Hafta 1-2-3 : Java Konu Tekrarları

* [1a_JavaProgramlamayaGiris](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/01a_JavaProgramlamayaGiris.pdf)
* [2a_Basit_veri_turleri](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/02a_Basit_veri_turleri.pdf)
* [2b_Degisken_tipleri](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/02b_Degisken_tipleri.pdf)
* [2c_NesnelerVeSiniflaraGiris](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/02c_NesnelerVeSiniflaraGiris.pdf)
* [3a_Denetleyiciler](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03a_Denetleyiciler.pdf)
* [3b_Operatorler](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03b_Operatorler.pdf)
* [3c_Donguler](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03c_Donguler.pdf)
* [3d_Karar_Ifadeleri](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03d_Karar_Ifadeleri.pdf)
* [3e_Faydalı_Metotlar](https://github.com/ozkansari/MyCourses/blob/master/AdvancedJava/_docs/03e_Faydal%C4%B1_Metotlar.pdf)
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

