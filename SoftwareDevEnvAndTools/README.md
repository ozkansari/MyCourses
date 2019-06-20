# YAZILIM GELISTIRME ORTAM ve ARACLARI - 2019 BAHAR ( Subat 2019 - Haziran 2019)

Dersler Cumartesi 12:00-13:00 ve 13:15-14:30 arasinda iki oturum halinde yapilacaktir.
Derse mazeretiniz yoksa %80 devam zorunludur. Derse devam ve derse katilimdan not verilecektir.
Her ders sonunda quiz yapilacaktir.

https://classroom.google.com/c/MzA3Mzk2Mjk1MDda
Kod:ni56f2f

## DUYURULAR

Final yazili sinav olacaktir.

## FINAL PROJESI

Teslim Tarihi: Final sinavindan 1 gun oncesine kadar Classroom uzerinden raporunuzu PDF formatinda gonderiniz.

 *Maven* kullanarak bir *Spring Boot* projesi (Bkz. Hafta 10) gelistireceksiniz. Projenizde su REST servisler bulunacak: 
- ogrenci Ekleme
- ogrenci Goruntuleme

https://github.com/ozkansari/MyCourses/tree/master/RestAPIOrnek ornek alinabilir.

Projenizi kurallara uygun gelistirecek ve bir rapor hazirlayacaksiniz. Ayrica final sinavi sonrasi projenizi aciklamaniz istenebilir. Projeyi aciklayamama veya projeyi ogrencinin kendisi yapmamasi durumunda final notu sifir olarak girilecektir.

Raporunuzda asagida belirtilmis olan tum adimlari, ayri basliklar altinda aciklamanizi ve ekran gorunutuleriyle desteklemenizi istiyorum. 

ONEMLi: Raporunuz sade ve anlasilir olmali.

Gelistirdiginiz proje ve kodlariniz hakkinda kurallar:
- Maven projesi olacak
- Spring Boot disinda ozel bir teknoloji kullanilmayacak
- Kodlariniz okunakli olacak: degiskenler, siniflar ve metotlar duzgun isimlendirilmis olacak ve Turkce karakter icermeyecek
- Tum metotlariniz icin JUnit ile birim testler yazilacak.
- Yazdiginiz birim testlerin coverage'ini yani test kapsama oranini hesaplatip, nasil hesaplattiginizin bilgisiyle birlikte raporunuza ekleyeceksiniz.

Kodlarinizi github'da yeni bir *repository* olusturularak  oraya commitleyeceksiniz.  Nasil yaptiginizi adim adim anlatmanizi ve sonuctaki github repository adresinizi raporunuza koymanizi istiyorum.

Kodlarinizi *Travis CI*  ile entegre edip otomatik derlettireceksiniz ve *CodeCov.io* entegrasyonuyla kodunuun coverage (test kapsama) degerlerinin otomatik hesaplanmasini saglayacaksiniz.  Yaptiginiz islemleri ve sonuclarini adim adim ekran goruntuleriyle aciklayacaksiniz ve raporunuzda paylasacaksiniz.

Kodunuzu *Postman* ve *JMeter* ile test edip, nasil test ettiginizi ve test sonuclarini raporunuzda adim adim paylasacaksiniz.

Tum siniflarinizin *UML* diagramlarini cizeceksiniz. Tercihen ArgoUML ya da benzer bir arac kullanabilirsiniz ya da paint veya elle cizebilirsiniz. UML diagramlari da rapora koyulacak ve aciklanacak.

*Jenkins* kuracaksiniz ve yaptiginiz islemleri adim adim ekran goruntuleriyle aciklayacaksiniz ve projenizin jenkins'te otomatik derlenmesini saglayacaksiniz ve iliskili adimlari rapora koyacaksiniz ve aciklayacaksiniz. 

*SonarQube* kurulumu yapacaksiniz ve yaptiginiz islemleri adim adim ekran goruntuleriyle aciklayacaksiniz ve jenkinsden tetiklenerek projenizin analiz edilmesini saglayacaksiniz. Analiz sonuclarinizi da rapora ekleyeceksiniz.

### Degerlendirme:

* [ /5] Spring Boot Projesi (Ekle/Goruntule/Sil) - Aciklama
* [ /10] Githuba commit
* [ /10] Rapor Duzeni & Aciklamalar
* [ /10] JUnit/Birim Test
* [ /5] Test kapsama (Coverage)
* [ /10] Travis CI & Codecov.io
* [ /15] Jenkins - Github maven build
* [ /10] SonarQube - Jenkins tetikleme
* [ /5] Postman
* [ /10] Jmeter
* [ /10] UML

---------------------------------------------------------------------------

## DERSLER

### VIZE Ders 1 - 13 EKIM


### VIZE Ders 6 - 31 MART

#### Spring Boot: 
Spring Boot (https://start.spring.io/), Spring tabanli uygulama geliÅŸtirmenin en hizli ve kolay yolu olmasi amaciyla geliÅŸtirilmiÅŸ bir frameworktUr. Spring Boot sayesinde boilerplate yani basmakalip kodlardan siyrilip, sadece ihtiyacimiz olan kodu yaziyoruz (only write code that you need to). Spring Boot web sunucusu olarak Tomcat ve diger birÃ§ok ek Ã¶zellikle beraber geliyor.

* https://medium.com/kodgemisi/spring-boot-ile-%C3%B6rnek-web-uygulamas%C4%B1-914c94c9099f
* http://burcualtinok.com.tr/blog/spring-boot-nedir/

#### YAPILACAKLAR:

##### Github Hesabi Acma, Repo olusturma ve Bunu Eclipse'e Baglama
* Github.com hesabi acin --> https://github.com/
* Hesabinizda bir repository/project olusturun. Ornegin: medipol
* Actiginiz repository'de README ve .gitignore sayfalari olusturun.
* Repository'ye "download/clone" ile elde ettiginiz URL'i, Eclipse'deki "Git Repository" view'ina sag tiklayip yapistir. Daha sonra kullanici bilgilerini gir ve adimalri tamamla. Boylece repository'yi Eclipse icinde gormeye baslayacaksin.
* Eclipse'de gorunen repository icindeki master branchine sag tiklayarak yeni bir branch olustur. Ornegin: ders2

##### Spring Boot Projesi Olusturma
* Spring Initializr araci kullanarak bir Spring Boot (Web, Actuator) projesi olusturun. https://start.spring.io/
* Olusturdugun projeyi "Import > Existing Maven Project" adimi ile eclipse'e aktar.

##### Projeyi Github repoya gonderme
* Eclipse'de "Team/share" adimi ile projeyi repository secerek sectigin git repository'sine bagla.
* .gitignore dosyasina .* satiri ekleyerek gereksiz dosyalarin git gorunumden cikmasini sagla.
* Dosyalari unstaged changes'den staged changes'e aktar.
* Anlamli bir commit mesaji yaz ve "commit and push" butonuna tikla. (Sadece commit, sonrasinda da branch'e sag tiklayip push denilebilir)

##### Github repo uzerinden pull request acma
* Github.com'daki repository'ne girerek pull request ac
* Pull Request'e merge yap
* Degisikliklerin master branch'inde gorundugune emin ol

##### Github.com uzerinden master'da yapilan degisiklikleri Eclipse Local Repoya indirme
* Eclipse'deki repository'nizde master branch'ine cift tiklayarak, secilen branch'e gecis yapin.
* Daha onceden yaptiginiz degisikliklerin burada gorunmedigine emin olun.
* Eclipse'deki repository'nize sag tiklayin ve "Pull" secin.
* Degisikliklerin Eclispe projenizde gorundugune emin olun.

### FINAL DERS 1 - Continous Integration (Surekli Entegrasyon) ve Code Coverage (Kod Kapsama Orani)

Code Coverage (Kod Kapsama Orani): Yazilan Kodun Ne Kadarinin Test Edildigini Gosterir. Code Coverage, yazdigimiz testlerin kontrol ettigi kodun, yazdigimiz koda orani demek. Cobertura ve Codecov.io araclari kullanilabilir.

Continuous Integration (CI - Surekli Entegrasyon) : Yazilan kodun, gelistirilen modulunâ€Šâ€”â€Škisaca gelistirme ortamindan cika gelen bir parcanin €Šprojeye dahil edilmesi esnasinda bir takim sureclerden gecirilmesine verilen isim. Bagimliliklarin repolardan indirilmesi, projeye dahil edilmesi, gelistirilen kod parcacigin testlerden (unit, integration, vs.) gecirilmesi, olasi durumlara gore gelistiriciye veya isin sorumlusuna bilgi verilmesi (push notification, sms, mail, vs.), isin paketlenmesi gibi eylemlerin tamami, genellikle bu kavramin bir parcasi olarak hayatimizda yer ediyor. https://medium.com/@selcukusta/continuous-integration-ci-%C3%BCzerine-laflamalar-9b7f7d2dad07 Travis.ci veya Jenkins araclari kullanilabilir.

#### JaCoCo Code Coverage (Kodun Ne Kadarinin Test EdildigŸinin Olculmesi)

Travis ile birlikte JaCoCo kullanilmali. 

Maven Goal: 

Maven Plugin:

```xml
<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.2</version>
				<executions>
					<execution>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<phase>test</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
```


#### Cobertura Code Coverage (Kodun Ne Kadarinin Test EdildigŸinin Olculmesi)

Java 8 ile ilgili bazen hatali hesaplama yapabiliyor.  Travis ile JaCoCo kullanilsa daha iyi olur.

Maven Goal: "cobertura:check" veya "cobertura:cobertura"

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

### FINAL DERS 2 - Travis CI & CodeCov IO

Code Cov IO icin jaCoCo plugin'i kullanilmali.

#### Travis CI & CodeCov IO
https://travis-ci.org/ & https://codecov.io : Github hesabinizla Uye olun.

Repository'nin ana dizinine ".travis.yml" isimli bir dosya olusturacaksiniz.

Ornek travis.yml: https://github.com/ozkansari/YAZILIM_ARACLARI/blob/master/.travis.yml
 

### FINAL DERS 3 - Spring Boot & Postman

1. ADIM
* http://start.spring.io/ sayfasini aciyoruz.
* Generate a  "MAVEN PROJECT" with "JAVA" and Spring Boot "2.1.4"
* Group: com.medipol.yazilimaraclari
* Artifact: RestAPIOrnek
* Search for dependencies : Web
* Generate Project

2. ADIM
* Indirilen zip dosyasini bir dizine ac (Extract). Ornegin: C:\RestAPIOrnek\ veya /Users/bprlab/Downloads/RestAPIOrnek dizininine acalim.
* Eclipse'de Import>Existing Maven Project secerek next diyoruz
* Root directory olarak Zip dosyasini actiginiz dizini gosteriyoruz. (C:\RestAPIOrnek\ veya /Users/bprlab/Downloads/RestAPIOrnek)
* Altta gorunen pom.xml checkbox tikla
* Daha sonra finish.
* En son olarak da Projeye sag tikla, Run as Maven Install sec.
* Proje BUILD SUCCESS olmali.

3. Adim
OgrenciRESTAPI sinifi olustur.
RestApiOrnekApplication.java sag tikla: Run as java application 
http://localhost:8080/ogrenci/listele adresine tarayicidan gir

#### Postman

https://www.getpostman.com/

![POSTMAN](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/postman/postman1.PNG?raw=true)

### FINAL DERS 4 - Spring Boot & JMeter

#### JMeter
https://jmeter.apache.org/download_jmeter.cgi

https://github.com/ozkansari/MyCourses/tree/master/SoftwareDevEnvAndTools/_docs/jmeter?raw=true

### FINAL DERS 5 - Jenkins & Sonarqube

#### Jenkins

##### Jenkins Kurulum
https://jenkins.io/download/ adresinden indirilebilir.
1. Secenek: Windows Kurulum : https://jenkins.io/download/thank-you-downloading-windows-installer-stable
2. Secenek: Generic WAR http://mirrors.jenkins.io/war-stable/latest/jenkins.war

Java komutu ile war dosyasi konsoldan calistirilabilir. Buradaki java komutunun jdk altindaki java komutu olmasi iyi olur. Bunun icin java komurunu tam yol olarak tirnak icinde de yazabilirsiniz. ornegin, "C:\Program Files\Java\jdk8\bin\java" - jar jenkins.war gibi.

    java -jar jenkins.war
    
8080 portu kullanimdaysa baska bir port asagidaki sekilde belirtilebilir:

    java -jar jenkins.war --httpPort=49001

##### Jenkins Kurulum Dizini
Jenkins normalde kurulum dizinini kullanici dizinindeki .jenkins klasoru (ornegin C:\Kullanicilar\bprlab\ .jenkins ) olarak ayarlar. 
Sifirdan baslamak icin bu dizini silebilirsiniz.

Ya da Jenkins home dizinini degistirmek icin calistirmadan once baska bir dizin belirtebilirsiniz. 
ornegin:

    SET JENKINS_HOME=C:/jenkins_ozkans

:exclamation: [JENKINS KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/jenkins/README.md)

##### Jenkins Arayuzu
Tarayicidan http://localhost:8080 girerek ara yuz acilabilir.
Daha sonra karsiniza cikan "Unlock Jenkins" ekraninda verilen dizindeki dosyayi acin ve orada yazan sifreyi ekrana girin (sifre console'dan calistirdiginizda loglarda da gorunecektir) ve Continue tusuna basin. Sonraki ekranda "Installed Suggested Plugins" seciniz. Ayrintilar icin: https://jenkins.io/doc/book/installing/#setupwizard

Plugin kurulum tamamlandiktan sonra, Admin password belirlemenizi isteyecek. belirledikten sonra Jenkins artik kullanima hazir.

Bu asamada "Jenkinse Hosgeldiniz" yazisini ekranda gormeniz lazim.

Jenkinsi Yonet ekranindan JDK, Git ve Maven ayarlarini yaptiktan sonra baslamak icin "Yeni is" olusturuyoruz.

...

### SonarQube

https://www.sonarqube.org/downloads/ adresinden sonar uygulamasini zip olarak indirin ve zip dosyasini acin. 

Maven build projenize sonar:sonar hedefini belirterek bir sonar analizi calistirabilirsiniz.

:exclamation: [SONARQUBE KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/sonarqube/README.md)


## Notlar

![NOTLAR](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/vize_notlar.PNG?v=1)

## TAKVIM

* Vize Hafta 1 - 23 SUBAT : Ders 1
* Vize Hafta 2 - 2 MART : Vize Ders 2 
* Vize Hafta 3 - 9 MART : Vize Ders 3
* Vize Hafta 4 - 16 MART : Vize Ders 4 
* Vize Hafta 5 - 23 MART  : Vize Ders 5
* Vize Hafta 6 - 30 MART  : Vize Ders 6
* Vize Hafta 7 - 6 NISAN  : Vize Ders 7 - Tekrar
* << ARA SINAVLAR : 06.04.2019	14.04.2019 >>
* Final Hafta 8 - 13 NISAN  : Ders Yapilmayacak
* Final Hafta 9 - 20 NISAN  : Final Ders 1 - Travis CI & Code Cov IO
* Final Hafta 10 - 27 NISAN  : Final Ders 2 - Travis CI & Code Cov IO
* Final Hafta 11 - 4 MAYIS  : Final Ders 3 - Spring Boot Rest & Postman
* Final Hafta 12 - 11 MAYIS  : Final Ders 4 - JMeter
* Final Hafta 13 - 18 MAYIS  : Final Ders 5 - Jenkins & Sonarqube
* Final Hafta 14 - 25 MAYIS  : Ders Yapilmayacak
* Final Hafta 15 - 1 HAZIRAN  : Ders Yapilmayacak
* << RAMAZAN BAYRAMI : 03.06.2019	06.06.2019 >>
* Final Hafta 16 - 8 HAZIRAN  : Ders Yapilmayacak
* << DONEM SONU SINAVLARI : 11.06.2019	23.06.2019 >>
