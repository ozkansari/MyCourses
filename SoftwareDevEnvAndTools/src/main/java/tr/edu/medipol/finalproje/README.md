FINAL PROJESI
Teslim Tarihi: 31 Mayis 23:59 (Raporunuzu ozkan.sari@outlook.com e-posta ile gönderebilirsiniz)

Sunum Tarihi: 02.06.2018 13:00 MYO LAB. (IMAC)

**************************************************************************
Degerlendirme:

* [ /5] Spring Boot Projesi (Ekle/Görüntüle/Sil)  - Aciklama
* [ /15] Githuba commit
* [ /10] Rapor Düzeni & Aciklamalar
* [ /5] Javadoc
* [ /10] JUnit/Birim Test
* [ /5] Test kapsama (Coverage)
* [ /5] Maven site
* [ /15] Travis CI & Codecov.io
* [ /15] Jenkins - Github maven build
* [ /10] SonarQube - Jenkins tetikleme
* [ /5] Postman
* [ /10] Jmeter
* [ /10] UML
---------------------------
* [ /120] Toplam

**************************************************************************

Maven (Bkz. Hafta 4-5) kullanarak bir Spring Boot projesi (Bkz. Hafta 10) gelistireceksiniz. Projenizde su REST servisler bulunacak:

Ögrenci Ekleme
Ögrenci Görüntüleme
Ögrenci Silme
https://github.com/ozkansari/FinalProje Örnek alinabilir.

Projenizi kurallara uygun gelistirecek ve bir rapor hazirlayacaksiniz. Ayrica final zamani gelip projenizi sunacaksiniz ve açiklayacaksiniz. Projeyi açiklayamama veya projeyi ögrencinin kendisi yapmamasi durumunda final notu sifir olarak girilecektir.

Raporunuzda asagida belirtilmis olan tüm adimlari, ayri basliklar altinda açiklamanizi ve ekran görünütüleriyle desteklemenizi istiyorum.

ÖNEMLI: Raporunuz sade ve anlasilir olmali.

Gelistirdiginiz proje ve kodlariniz hakkinda kurallar:

Maven projesi olacak (Bkz. Hafta 4-5)
Spring Boot disinda özel bir teknoloji kullanilmayacak (Bkz. Hafta 10)
Kodlariniz okunakli olacak: degiskenler, siniflar ve metotlar düzgün isimlendirilmis olacak ve Turkçe karakter içermeyecek
Tüm sinif ve metotlariniz javadoc (Bkz. Hafta 8) standardiyla dokümante edilmis olacak. Javadoc raporu olusturulup, olusturma adimlariyla birlikte rapora konulacak.
Tüm metotlariniz için JUnit ile birim testler yazilacak. (Bkz. Hafta 4-5)
Yazdiginiz birim testlerin coverage'ini yani test kapsama oranini (Bkz. Hafta 9) hesaplatip, nasil hesaplattiginizin bilgisiyle birlikte raporunuza ekleyeceksiniz.
Projenizden otomatik olarak bir maven site (Bkz. Hafta 8) olusturacaksiniz ve yaptiginiz islemleri adim adim ekran görüntüleriyle açiklayacaksiniz.

Kodlarinizi github'da yeni bir repository olusturularak (Bkz. Hafta 4-5) oraya commitleyeceksiniz. Nasil yaptiginizi adim adim anlatmanizi ve sonuçtaki github repository adresinizi raporunuza koymanizi istiyorum.

Kodlarinizi Travis CI (Bkz. Hafta 11) ile entegre edip otomatik derlettireceksiniz ve CodeCov.io (Bkz. Hafta 11) entegrasyonuyla kodunuun coverage (test kapsama) degerlerinin otomatik hesaplanmasini saglayacaksiniz. Yaptiginiz islemleri ve sonuçlarini adim adim ekran görüntüleriyle açiklayacaksiniz ve raporunuzda paylasacaksiniz.

Kodunuzu Postman (Bkz.Hafta 10) ve JMeter (Bkz. Hafta 11) ile test edip, nasil test ettiginizi ve test sonuçlarini raporunuzda adim adim paylasacaksiniz.

Tüm siniflarinizin UML diagramlarini (Bkz.Hafta 3) çizeceksiniz. Tercihen ArgoUML ya da benzer bir araç kullanabilirsiniz. UML diagramlari da rapora koyulacak ve açiklanacak.

Jenkins (Bkz. Hafta 6 & 7) kuracaksiniz ve yaptiginiz islemleri adim adim ekran görüntüleriyle açiklayacaksiniz ve projenizin jenkins'te otomatik derlenmesini saglayacaksiniz ve iliskili adimlari rapora koyacaksiniz ve açiklayacaksiniz.

SonarQube (Bkz. Hafta 7) kurulumu yapacaksiniz ve yaptiginiz islemleri adim adim ekran görüntüleriyle açiklayacaksiniz ve jenkinsden tetiklenerek projenizin analiz edilmesini saglayacaksiniz. Analiz sonuçlarinizi da rapora ekleyeceksiniz.

Bonus
Unit testlerde Spring REST testleri kullanilmasi. Örnek: https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/