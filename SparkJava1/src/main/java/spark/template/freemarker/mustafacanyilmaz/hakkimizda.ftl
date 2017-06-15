<#import "template.ftl" as c/>
<@c.page title="Anasayfa">
    <!-- custom page content -->


<div class="main">
<center><h1> Programimiza Hosgeldiniz </h1></center>

<h4>Programimizdan Kisaca Bahsetmek Gerekirse;</h4>
<p><h3>Anasayfa</h3>Giris ekraninda bizi Anasayfa karsiliyor, anasayfada kisaca projemize ait bir baslik altinda on bilgi bulunmaktadir.</p>
<p><h3>Ogrenci Ve Ders Ekle </h3></p>
Bu sayfada kullanicidan belli basli girilmesi istenen degerler bulunmakta.
Ogrencinin Id'si sadece integer deger olmasi icin o formata uygun yapilmistir, programimiza hem front-end hemde back-end kisminda girilmesi
istenen input degerlerin kontrolu ( back end'de == null  ya da isEmpty() fonksiyonlariyla front-end'de ise  required komutlariyla) kontrol saglandi.
ek olarak kullanicidan 18 yas ve ustu seklinde Yas degeri istendi ( back-end kisminda for dongusu ile donuldu tek tek front-end'de option diye eklenmedi).
Polimorfizm destegi sunuldu.
Kullanicidan istenen degerler eksiksiz girildiginde kullanici Ogrenci Listele sayfasina aktarildi.

<h3>Ogrenci Listele</h3>
<p>Kullaniciyi bu sayfada daha once Ogrenci ve ders ekle sayfasinda girmis oldugu verilerin arayuz kisminda tablo halinde goruntulenmesi saglanmistir,
Kolon kolon kullanicidan alinan degerler listelenmistir.Kullanici rahat ayirt edilebilmesi adina Id'si ve Adi bu sayfada listelenmistir.
kullanici bu sayfada Ogrencinin detayina tikladiginda OgrenciDetay Adli sayfaya yonlendirilmektedir.(Arama cubuguna /ogrenciDetay yazildiginda yonlendirme saglanmamaktadir. Sadece buton ile saglanmaktadir. nedeni ise secilen Id'ye gore detay listelenmektedir.)
Ogrenci detay sayfasinda farkli bir tabloda ogrencinin ders detaylari ve derse kayitli olma durumu listelenmektedir.Geri don butonuna basildiginda bir onceki sayfaya Ogrenci Listeleye donmektedir.
Kullanici Ogrenci Sil butonuna tikladiginda hangi kolonda tikladiysa o kolondaki ogrenci silinmektedir.
Alt kisimda bulunan input deger beklenen textbox kismina ornegin elinizde 50000 kayit var ve bu kayitlar arasindan tek tek kullanici arayip butonla silmek yerine Id'sini bildiginiz zaman Id ile silip kolaylik saglamak adina yapilmistir.
Ogrenci Ekle kismina basildiginda ogrenci ekleme sayfasi acilmaktadir. 

<h3>Programimin Yapiminda Nasil Yol izledim ?</h3>
<p>Yaptigim bu sistemin front-end kismini yaparken temel html bilgimi kullanarak Header, Main  ve Footer kisimlari olusturdum.</p><p>
Bu kisimlari tek bir yerden kullanacagim yerlerde import ettim.Back-end kisminda ise derste isledigimiz konulari kilavuz olarak kullandim.</p>


<h3>Not: Veritabani projeye baglanmamistir, Veritabani clasi icindeki kodlarin calisma prensibi dogrudur.</h3>
  


</div>

</@c.page>
