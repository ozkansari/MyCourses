# YAZILIM GELISTIRME ORTAM ve ARACLARI
2018 BAHAR

Dersler Cumartesi 12:00-13:00 ve 13:15-14:30 arasinda iki oturum halinde yapilacaktir.
Derse mazeretiniz yoksa %80 devam zorunludur. Derse devam ve derse katilimdan not verilecektir.

## BUTUNLEME YAZILI SINAV OLACAKTIR. VIZEDEKINE BENZER SORULAR CIKACAKTIR.

    Bilgisayar Programcılığı Programı / 2. Sınıf - YAZILIM GELİŞTİRME ORTAM VE ARAÇLARI, Bütünleme
    C-443
    27.06.2018 17:45

## FINAL PROJESI

Teslim Tarihi: 31 Mayis 23:59 (Raporunuzu ozkan.sari@outlook.com e-posta ile gonderebilirsiniz)

Sunum Tarihi: 02.06.2018 13:00 MYO LAB. (iMAC)

 *Maven* (Bkz. Hafta 4-5) kullanarak bir *Spring Boot* projesi (Bkz. Hafta 10) gelistireceksiniz. Projenizde su REST servisler bulunacak: 
- ogrenci Ekleme
- ogrenci Goruntuleme
- ogrenci Silme

https://github.com/ozkansari/FinalProje ornek alinabilir.

Projenizi kurallara uygun gelistirecek ve bir rapor hazirlayacaksiniz. Ayrica final zamani gelip projenizi sunacaksiniz ve aciklayacaksiniz. Projeyi aciklayamama veya projeyi ogrencinin kendisi yapmamasi durumunda final notu sifir olarak girilecektir.

Raporunuzda asagida belirtilmis olan tum adimlari, ayri basliklar altinda aciklamanizi ve ekran gorunutuleriyle desteklemenizi istiyorum. 

oNEMLi: Raporunuz sade ve anlasilir olmali.

Gelistirdiginiz proje ve kodlariniz hakkinda kurallar:
- Maven projesi olacak (Bkz. Hafta 4-5)
- Spring Boot disinda ozel bir teknoloji kullanilmayacak (Bkz. Hafta 10)
- Kodlariniz okunakli olacak: degiskenler, siniflar ve metotlar duzgun isimlendirilmis olacak ve Turkce karakter icermeyecek
- Tum sinif ve metotlariniz javadoc (Bkz. Hafta 8) standardiyla dokumante edilmis olacak. Javadoc raporu olusturulup, olusturma adimlariyla birlikte rapora konulacak.
- Tum metotlariniz icin JUnit ile birim testler yazilacak. (Bkz. Hafta 4-5)
- Yazdiginiz birim testlerin coverage'ini yani test kapsama oranini (Bkz. Hafta 9) hesaplatip, nasil hesaplattiginizin bilgisiyle birlikte raporunuza ekleyeceksiniz.

Projenizden otomatik olarak bir maven site (Bkz. Hafta 8) olusturacaksiniz ve yaptiginiz islemleri adim adim ekran goruntuleriyle aciklayacaksiniz.

Kodlarinizi github'da yeni bir repository olusturularak (Bkz. Hafta 4-5) oraya commitleyeceksiniz.  Nasil yaptiginizi adim adim anlatmanizi ve sonuctaki github repository adresinizi raporunuza koymanizi istiyorum.

Kodlarinizi Travis CI (Bkz. Hafta 11) ile entegre edip otomatik derlettireceksiniz ve CodeCov.io (Bkz. Hafta 11) entegrasyonuyla kodunuun coverage (test kapsama) degerlerinin otomatik hesaplanmasini saglayacaksiniz.  Yaptiginiz islemleri ve sonuclarini adim adim ekran goruntuleriyle aciklayacaksiniz ve raporunuzda paylasacaksiniz.

Kodunuzu Postman (Bkz.Hafta 10) ve JMeter (Bkz. Hafta 11) ile test edip, nasil test ettiginizi ve test sonuclarini raporunuzda adim adim paylasacaksiniz.

Tum siniflarinizin UML diagramlarini (Bkz.Hafta 3) cizeceksiniz. Tercihen ArgoUML ya da benzer bir arac kullanabilirsiniz. UML diagramlari da rapora koyulacak ve aciklanacak.

Jenkins (Bkz. Hafta 6 & 7) kuracaksiniz ve yaptiginiz islemleri adim adim ekran goruntuleriyle aciklayacaksiniz ve projenizin jenkins'te otomatik derlenmesini saglayacaksiniz ve iliskili adimlari rapora koyacaksiniz ve aciklayacaksiniz. 

SonarQube (Bkz. Hafta 7) kurulumu yapacaksiniz ve yaptiginiz islemleri adim adim ekran goruntuleriyle aciklayacaksiniz ve jenkinsden tetiklenerek projenizin analiz edilmesini saglayacaksiniz. Analiz sonuclarinizi da rapora ekleyeceksiniz.

### Bonus

Unit testlerde Spring REST testleri kullanilmasi. ornek: https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/

## ODEVLER

### Odev 1

En az 10 Matematiksel islem icin 10 ayri metod iceren Hesaplama sinifi yazilacak. 
Bu 10 Matematikel islemin her biri icin de 10 ayri JUnit test metodu yazilacak.
Uygulama Maven projesi seklinde gelistirilecek ve Maven test ve install komutlarin calismasi kontrol edilecek.
Teslim tarihi:23 Mart 23:59'a kadar
Odevleri ozkan.sari@outlook.com adresine  gonderiniz.

### Odev 2 IPTAL
* https://github.com/ozkansari/YAZILIM_ARACLARI_REPO repository'sini git ile indirin (checkout)
* Bu repository'deki master branch uzerinden isminize ozel (ad_soyad seklinde) branch olusturun.
* Sectiginiz bir matematiksel operasyonu ayni isimle bir Sinifta kodunu yazin.
* Yazdiginiz operasyonun JUnit ile birim testini yazin.
* Branch'inizdaki degisiklikleri commitleyin ve push'layin

Teslim Tarihi: 20 Nisan 23:59:59. Her hangi bir dosya gondermenize gerek yok. Github branch commit yeterli.

## DERS ICERIKLERI

### Hafta 1
- [Sunum](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/1_Ders_Sunum.pdf)
- [Eclipse IDE](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/1_Eclipse-Kullanimi.pdf)

### Hafta 2 
- [Sunum](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/2_Ders_Sunum.pdf)

### Hafta 3 : UML
- [Sunum](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/3_Ders_Sunum.pdf)

### Hafta 4-5 : Maven, JUnit, Git
- [Sunum](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/4_Ders_Sunum.pdf)

### Hafta 6 & 7: Jenkins

#### Jenkins Kurulum
https://jenkins.io/download/ adresinden indirilebilir.
1. Secenek: Windows Kurulum : https://jenkins.io/download/thank-you-downloading-windows-installer-stable
2. Secenek: Generic WAR http://mirrors.jenkins.io/war-stable/latest/jenkins.war

Java komutu ile war dosyasi konsoldan calistirilabilir. Buradaki java komutunun jdk altindaki java komutu olmasi iyi olur. Bunun icin java komurunu tam yol olarak tirnak icinde de yazabilirsiniz. ornegin, "C:\Program Files\Java\jdk8\bin\java" - jar jenkins.war gibi.

    java -jar jenkins.war
    
8080 portu kullanimdaysa baska bir port asagidaki sekilde belirtilebilir:

    java -jar jenkins.war --httpPort=49001

#### Jenkins Kurulum Dizini
Jenkins normalde kurulum dizinini kullanici dizinindeki .jenkins klasoru (ornegin C:\Kullanicilar\bprlab\ .jenkins ) olarak ayarlar. 
Sifirdan baslamak icin bu dizini silebilirsiniz.

Ya da Jenkins home dizinini degistirmek icin calistirmadan once baska bir dizin belirtebilirsiniz. 
ornegin:

    SET JENKINS_HOME=C:/jenkins_ozkans

:exclamation: [JENKINS KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/jenkins/README.md)

#### Jenkins Arayuzu
Tarayicidan http://localhost:8080 girerek ara yuz acilabilir.
Daha sonra karsiniza cikan "Unlock Jenkins" ekraninda verilen dizindeki dosyayi acin ve orada yazan sifreyi ekrana girin (sifre console'dan calistirdiginizda loglarda da gorunecektir) ve Continue tusuna basin. Sonraki ekranda "Installed Suggested Plugins" seciniz. Ayrintilar icin: https://jenkins.io/doc/book/installing/#setupwizard

Plugin kurulum tamamlandiktan sonra, Admin password belirlemenizi isteyecek. belirledikten sonra Jenkins artik kullanima hazir.

Bu asamada "Jenkinse Hosgeldiniz" yazisini ekranda gormeniz lazim.

Jenkinsi Yonet ekranindan JDK, Git ve Maven ayarlarini yaptiktan sonra baslamak icin "Yeni is" olusturuyoruz.

...

### Hafta 7: SonarQube

https://www.sonarqube.org/downloads/ adresinden sonar uygulamasini zip olarak indirin ve zip dosyasini acin. 

Maven build projenize sonar:sonar aben hedefini belirterek bir sonar analizi calistirabilirsiniz.

:exclamation: [SONARQUBE KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/sonarqube/README.md)

### Hafta 8 Javadoc & Maven Site

[JavaDoc Hakkinda](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/8a_Javadoc.pdf)

Maven komutuna yapilacak ek: 
    
    javadoc:javadoc javadoc:aggregate site

Sonuctaki Maven komutu:

    install checkstyle:checkstyle pmd:pmd sonar:sonar javadoc:javadoc javadoc:aggregate site
    
Jenkins Java Doc goruntuleme sorunu icin Jenkins Script'i acin (http://localhost:8080/script) ve asagidaki komutu calistirin.
    
    System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src 'none'; img-src 'self'; style-src 'self'; child-src 'self'; frame-src 'self';")


### Hafta 9 Code Coverage

Code Coverage: Yazilan Kodun Ne Kadarinin Test Edildigini Gosterir. Code Coverage, yazdigimiz testlerin kontrol ettigi kodun, yazdigimiz koda orani demek.

#### JaCoCo

http://www.eclemma.org/jacoco/trunk/doc/report-mojo.html

Maven Goal: "install test jacoco:report"

Maven Plugin:

```xml
   <project>
       <!-- Dependencies -->
       <!- .... --> 
       <build>
           <plugins>
               <plugin>
                  <groupId>org.jacoco</groupId>
                  <artifactId>jacoco-maven-plugin</artifactId>
                  <version>0.8.1</version>
                </plugin>
           </plugins>
        </build>
    </project>
```        

#### Cobertura Code Coverage (Kodun Ne Kadarin Test Edildiginin olculmesi)

http://www.baeldung.com/cobertura

Maven Goal 1: "cobertura:cobertura"

Maven Goal 2: "cobertura:check"

Maven Plugin:

```xml
   <project>
       <!-- Dependencies -->
       <!- .... --> 
       <build>
           <plugins>
               <plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>cobertura-maven-plugin</artifactId>
				<version>2.7</version>
				<configuration>
					<formats>
						<format>html</format>
						<format>xml</format>
					</formats>
					<check />
				</configuration>
			</plugin>
           </plugins>
        </build>
    </project>
```      

### Hafta 10 Spring Boot & Postman

1. ADIM
* http://start.spring.io/ sayfasini aciyoruz.
* Generate a  "MAVEN PROJECT" with "JAVA" and Spring Boot "1.5.13"
* Group:	com.medipol.yazilimaraclari
* Artifact: SpringBootOrnek
* Search for dependencies : Web
* Generate Project

2. ADIM
* Indirilen zip dosyasini bir dizine ac (Extract). Ornegin: C:\SpringBootOrnek\ dizininine acalim.
* Eclipse'de Import>Existing Maven Project secerek next diyoruz
* Root directory olarak Zip dosyasini actiginiz dizini gosteriyoruz. (C:\SpringBootOrnek\ )
* Altta gorunen pom.xml checkbo tikla
* Daha sonra finish.
* En son olarak da Projeye sag tikla, Run as Maven Install sec.
* Proje BUILD SUCCESS olmali.

3. Adim
RESTServisiOrnek sinifi olustur.
SpringBootOrnekApplication.java sag tikla: Run as java application 
http://localhost:8080/ogrenci/listele adresine tarayicidan gir

#### Postman

https://www.getpostman.com/

![POSTMAN](https://github.com/ozkansari/MyCourses/tree/master/SoftwareDevEnvAndTools/_docs/postman)

### Hafta 11

#### JMeter
https://jmeter.apache.org/download_jmeter.cgi

![JMETER](https://github.com/ozkansari/MyCourses/tree/master/SoftwareDevEnvAndTools/_docs/jmeter)

#### Travis CI & CodeCov IO

Repository'nin ana dizinine ".travis.yml" isimli bir dosya olusturacaksiniz.
Dosya icine yazilacaklar icin: https://github.com/ozkansari/FinalProje/blob/master/.travis.yml ornek alinabilir. 
Proje adi SpringBootOrnek degilse kendi proje adiniz olmali.

https://travis-ci.org/ & https://codecov.io : Github hesabinizla uye olun.

ornek travis.yml: https://github.com/ozkansari/YAZILIM_ARACLARI_REPO/blob/master/.travis.yml 

## Notlar

![NOTLAR](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/Notlar_SwDev.png)

