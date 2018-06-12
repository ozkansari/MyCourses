FINAL PROJESI
Teslim Tarihi: 31 Mayis 23:59 (Raporunuzu ozkan.sari@outlook.com e-posta ile gonderebilirsiniz)

Sunum Tarihi: 02.06.2018 13:00 MYO LAB. (IMAC)

**************************************************************************
Degerlendirme:

* [ /5] Spring Boot Projesi (Ekle/Goruntule/Sil)  - Aciklama
* [ /15] Githuba commit
* [ /10] Rapor Duzeni & Aciklamalar
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

Ogrenci Ekleme
Ogrenci Goruntuleme
Ogrenci Silme
https://github.com/ozkansari/FinalProje ornek alinabilir.

Projenizi kurallara uygun gelistirecek ve bir rapor hazirlayacaksiniz. Ayrica final zamani gelip projenizi sunacaksiniz ve aciklayacaksiniz. Projeyi aciklayamama veya projeyi ogrencinin kendisi yapmamasi durumunda final notu sifir olarak girilecektir.

Raporunuzda asagida belirtilmis olan tum adimlari, ayri basliklar altinda aciklamanizi ve ekran goruntuleriyle desteklemenizi istiyorum.

ONEMLI: Raporunuz sade ve anlasilir olmali.

Gelistirdiginiz proje ve kodlariniz hakkinda kurallar:

Maven projesi olacak (Bkz. Hafta 4-5)
Spring Boot disinda ozel bir teknoloji kullanilmayacak (Bkz. Hafta 10)
Kodlariniz okunakli olacak: degiskenler, siniflar ve metotlar duzgun isimlendirilmis olacak ve Turkce karakter icermeyecek
Tum sinif ve metotlariniz javadoc (Bkz. Hafta 8) standardiyla dokumante edilmis olacak. Javadoc raporu olusturulup, olusturma adimlariyla birlikte rapora konulacak.
Tum metotlariniz icin JUnit ile birim testler yazilacak. (Bkz. Hafta 4-5)
Yazdiginiz birim testlerin coverage'ini yani test kapsama oranini (Bkz. Hafta 9) hesaplatip, nasil hesaplattiginizin bilgisiyle birlikte raporunuza ekleyeceksiniz.
Projenizden otomatik olarak bir maven site (Bkz. Hafta 8) olusturacaksiniz ve yaptiginiz islemleri adim adim ekran goruntuleriyle aciklayacaksiniz.

Kodlarinizi github'da yeni bir repository olusturularak (Bkz. Hafta 4-5) oraya commitleyeceksiniz. Nasil yaptiginizi adim adim anlatmanizi ve sonuctaki github repository adresinizi raporunuza koymanizi istiyorum.

Kodlarinizi Travis CI (Bkz. Hafta 11) ile entegre edip otomatik derlettireceksiniz ve CodeCov.io (Bkz. Hafta 11) entegrasyonuyla kodunuun coverage (test kapsama) degerlerinin otomatik hesaplanmasini saglayacaksiniz. Yaptiginiz islemleri ve sonuclarini adim adim ekran goruntuleriyle aciklayacaksiniz ve raporunuzda paylasacaksiniz.

Kodunuzu Postman (Bkz.Hafta 10) ve JMeter (Bkz. Hafta 11) ile test edip, nasil test ettiginizi ve test sonuclarini raporunuzda adim adim paylasacaksiniz.

Tum siniflarinizin UML diagramlarini (Bkz.Hafta 3) cizeceksiniz. Tercihen ArgoUML ya da benzer bir ara_ kullanabilirsiniz. UML diagramlari da rapora koyulacak ve aciklanacak.

Jenkins (Bkz. Hafta 6 & 7) kuracaksiniz ve yaptiginiz islemleri adim adim ekran goruntuleriyle aciklayacaksiniz ve projenizin jenkins'te otomatik derlenmesini saglayacaksiniz ve iliskili adimlari rapora koyacaksiniz ve a_iklayacaksiniz.

SonarQube (Bkz. Hafta 7) kurulumu yapacaksiniz ve yaptiginiz islemleri adim adim ekran goruntuleriyle aciklayacaksiniz ve jenkinsden tetiklenerek projenizin analiz edilmesini saglayacaksiniz. Analiz sonu_larinizi da rapora ekleyeceksiniz.

Bonus
Unit testlerde Spring REST testleri kullanilmasi. Ornek: https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/