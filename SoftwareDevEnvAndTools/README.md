# YAZILIM GELİŞTİRME ORTAM ve ARACLARI
2018 BAHAR

Dersler Cumartesi 12:00-13:00 ve 13:15-14:30 arasında iki oturum halinde yapılacaktır.
Derse mazeretiniz yoksa %80 devam zorunludur. Derse devam ve derse katılımdan not verilecektir.

## FİNAL PROJESİ

Teslim Tarihi: 31 Mayıs 23:59 (Raporunuzu ozkan.sari@outlook.com e-posta ile gönderebilirsiniz)

Sunum Tarihi: 02.06.2018 13:00 MYO LAB. (İMAC)

 *Maven* (Bkz. Hafta 4-5) kullanarak bir *Spring Boot* projesi (Bkz. Hafta 10) geliştireceksiniz. Projenizde şu REST servisler bulunacak: 
- Öğrenci Ekleme
- Öğrenci Görüntüleme
- Öğrenci Silme

Projenizi kurallara uygun geliştirecek ve bir rapor hazırlayacaksınız. Ayrıca final zamanı gelip projenizi sunacaksınız ve açıklayacaksınız. Projeyi açıklayamama veya projeyi öğrencinin kendisi yapmaması durumunda final notu sıfır olarak girilecektir.

Raporunuzda aşağıda belirtilmiş olan tüm adımları, ayrı başlıklar altında açıklamanızı ve ekran görünütüleriyle desteklemenizi istiyorum. 

ÖNEMLİ: Raporunuz sade ve anlaşılır olmalı.

Geliştirdiğiniz proje ve kodlarınız hakkında kurallar:
- Maven projesi olacak (Bkz. Hafta 4-5)
- Spring Boot dışında özel bir teknoloji kullanılmayacak (Bkz. Hafta 10)
- Kodlarınız okunaklı olacak: değişkenler, sınıflar ve metotlar düzgün isimlendirilmiş olacak ve Turkçe karakter içermeyecek
- Tüm sınıf ve metotlarınız javadoc (Bkz. Hafta 8) standardıyla dokümante edilmiş olacak. Javadoc raporu oluşturulup, oluşturma adımlarıyla birlikte rapora konulacak.
- Tüm metotlarınız için JUnit ile birim testler yazılacak. (Bkz. Hafta 4-5)
- Yazdığınız birim testlerin coverage'ını yani test kapsama oranını (Bkz. Hafta 9) hesaplatıp, nasıl hesaplattığınızın bilgisiyle birlikte raporunuza ekleyeceksiniz.

Projenizden otomatik olarak bir maven site (Bkz. Hafta 8) oluşturacaksınız ve yaptığınız işlemleri adım adım ekran görüntüleriyle açıklayacaksınız.

Kodlarınızı github'da yeni bir repository oluşturularak (Bkz. Hafta 4-5) oraya commitleyeceksiniz.  Nasıl yaptığınızı adım adım anlatmanızı ve sonuçtaki github repository adresinizi raporunuza koymanızı istiyorum.

Kodlarınızı Travis CI (Bkz. Hafta 11) ile entegre edip otomatik derlettireceksiniz ve CodeCov.io (Bkz. Hafta 9) entegrasyonuyla kodunuun coverage (test kapsama) değerlerinin otomatik hesaplanmasını sağlayacaksınız.  Yaptığınız işlemleri ve sonuçlarını adım adım ekran görüntüleriyle açıklayacaksınız ve raporunuzda paylaşacaksınız.

Kodunuzu Postman (Bkz.Hafta 10) ve JMeter (Bkz. Hafta 11) ile test edip, nasıl test ettiğinizi ve test sonuçlarını raporunuzda adım adım paylaşacaksınız.

Tüm sınıflarınızın UML diagramlarını (Bkz.Hafta 3) çizeceksiniz. Tercihen ArgoUML ya da benzer bir araç kullanabilirsiniz. UML diagramları da rapora koyulacak ve açıklanacak.

Jenkins (Bkz. Hafta 6 & 7) kuracaksınız ve yaptığınız işlemleri adım adım ekran görüntüleriyle açıklayacaksınız ve projenizin jenkins'te otomatik derlenmesini sağlayacaksınız ve ilişkili adımları rapora koyacaksınız ve açıklayacaksınız. 

SonarQube (Bkz. Hafta 7) kurulumu yapacaksınız ve yaptığınız işlemleri adım adım ekran görüntüleriyle açıklayacaksınız ve jenkinsden tetiklenerek projenizin analiz edilmesini sağlayacaksınız. Analiz sonuçlarınızı da rapora ekleyeceksiniz.

### Bonus

Unit testlerde Spring REST testleri kullanılması. Örnek: https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/

## ODEVLER

### Odev 1

En az 10 Matematiksel işlem için 10 ayrı metod içeren Hesaplama sınıfı yazılacak. 
Bu 10 Matematikel işlemin her biri için de 10 ayrı JUnit test metodu yazılacak.
Uygulama Maven projesi şeklinde geliştirilecek ve Maven test ve install komutların çalışması kontrol edilecek.
Teslim tarihi:23 Mart 23:59'a kadar
Odevleri ozkan.sari@outlook.com adresine  gönderiniz.

### Odev 2 IPTAL
* https://github.com/ozkansari/YAZILIM_ARACLARI_REPO repository'sini git ile indirin (checkout)
* Bu repository'deki master branch üzerinden isminize özel (ad_soyad şeklinde) branch oluşturun.
* Seçtiğiniz bir matematiksel operasyonu aynı isimle bir Sınıfta kodunu yazın.
* Yazdığınız operasyonun JUnit ile birim testini yazın.
* Branch'ınızdaki değişiklikleri commitleyin ve push'layın

Teslim Tarihi: 20 Nisan 23:59:59. Her hangi bir dosya göndermenize gerek yok. Github branch commit yeterli.

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
1. Seçenek: Windows Kurulum : https://jenkins.io/download/thank-you-downloading-windows-installer-stable
2. Seçenek: Generic WAR http://mirrors.jenkins.io/war-stable/latest/jenkins.war

Java komutu ile war dosyası konsoldan çalıştırılabilir. Buradaki java komutunun jdk altındaki java komutu olması iyi olur. Bunun için java komurunu tam yol olarak tırnak içinde de yazabilirsiniz. Örneğin, "C:\Program Files\Java\jdk8\bin\java" - jar jenkins.war gibi.

    java -jar jenkins.war
    
8080 portu kullanımdaysa başka bir port aşağıdaki şekilde belirtilebilir:

    java -jar jenkins.war --httpPort=49001

#### Jenkins Kurulum Dizini
Jenkins normalde kurulum dizinini kullanıcı dizinindeki .jenkins klasörü (Örneğin C:\Kullanıcılar\bprlab\ .jenkins ) olarak ayarlar. 
Sıfırdan başlamak için bu dizini silebilirsiniz.

Ya da Jenkins home dizinini değiştirmek için çalıştırmadan önce başka bir dizin belirtebilirsiniz. 
Örneğin:

    SET JENKINS_HOME=C:/jenkins_ozkans

:exclamation: [JENKINS KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/jenkins/README.md)

#### Jenkins Arayüzü
Tarayıcıdan http://localhost:8080 girerek ara yüz açılabilir.
Daha sonra karşınıza çıkan "Unlock Jenkins" ekranında verilen dizindeki dosyayı açın ve orada yazan şifreyi ekrana girin (Şifre console'dan çalıştırdığınızda loglarda da görünecektir) ve Continue tuşuna basın. Sonraki ekranda "Installed Suggested Plugins" seçiniz. Ayrıntılar için: https://jenkins.io/doc/book/installing/#setupwizard

Plugin kurulum tamamlandıktan sonra, Admin password belirlemenizi isteyecek. belirledikten sonra Jenkins artık kullanıma hazır.

Bu aşamada "Jenkinse Hoşgeldiniz" yazısını ekranda görmeniz lazım.

Jenkinsi Yönet ekranından JDK, Git ve Maven ayarlarını yaptıktan sonra başlamak için "Yeni İş" oluşturuyoruz.

...

### Hafta 7: SonarQube

https://www.sonarqube.org/downloads/ adresinden sonar uygulamasını zip olarak indirin ve zip dosyasını açın. 

Maven build projenize sonar:sonar aben hedefini belirterek bir sonar analizi çalıştırabilirsiniz.

:exclamation: [SONARQUBE KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/sonarqube/README.md)

### Hafta 8 Javadoc & Maven Site

[JavaDoc Hakkında](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/8a_Javadoc.pdf)

Maven komutuna yapılacak ek: 
    
    javadoc:javadoc javadoc:aggregate site

Sonuçtaki Maven komutu:

    install checkstyle:checkstyle pmd:pmd sonar:sonar javadoc:javadoc javadoc:aggregate site
    
Jenkins Java Doc goruntuleme sorunu icin Jenkins Script'i acın (http://localhost:8080/script) ve asagidaki komutu calistirin.
    
    System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src 'none'; img-src 'self'; style-src 'self'; child-src 'self'; frame-src 'self';")


### Hafta 9 Code Coverage

Code Coverage: Yazılan Kodun Ne Kadarının Test Edildiğini Gösterir. Code Coverage, yazdığımız testlerin kontrol ettiği kodun, yazdığımız koda oranı demek.

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

#### Cobertura Code Coverage (Kodun Ne Kadarın Test Edildiğinin Ölçülmesi)

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
* Indirilen zip dosyasını bir dizine aç (Extract). Ornegin: C:\SpringBootOrnek\ dizininine acalim.
* Eclipse'de Import>Existing Maven Project seçerek next diyoruz
* Root directory olarak Zip dosyasını açtığınız dizini gosteriyoruz. (C:\SpringBootOrnek\ )
* Altta gorunen pom.xml checkbo tikla
* Daha sonra finish.
* En son olarak da Projeye sag tikla, Run as Maven Install sec.
* Proje BUILD SUCCESS olmalı.

3. Adim
RESTServisiOrnek sinifi olustur.
SpringBootOrnekApplication.java sag tikla: Run as java application 
http://localhost:8080/ogrenci/listele adresine tarayıcıdan gir

#### Postman

![POSTMAN](https://github.com/ozkansari/MyCourses/tree/master/SoftwareDevEnvAndTools_2017Autumn/_docs/postman)

### Hafta 11

#### JMeter

![JMETER](https://github.com/ozkansari/MyCourses/tree/master/SoftwareDevEnvAndTools_2017Autumn/_docs/jmeter)

#### Travis CI & CodeCov IO
https://travis-ci.org/ & https://codecov.io : Github hesabınızla üye olun.
Örnek travis.yml: https://github.com/ozkansari/YAZILIM_ARACLARI_REPO/blob/master/.travis.yml 

## Notlar

![NOTLAR](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/Notlar_SwDev.png)

