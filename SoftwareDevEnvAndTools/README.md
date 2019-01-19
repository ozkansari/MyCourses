# YAZILIM GELISTIRME ORTAM ve ARACLARI - 2018 GUZ

Dersler Cumartesi 12:00-13:00 ve 13:15-14:30 arasinda iki oturum halinde yapilacaktir.
Derse mazeretiniz yoksa %80 devam zorunludur. Derse devam ve derse katilimdan not verilecektir.

## DUYURULAR

Final Projesi Mebis'te duyurulan yer ve saatte *yazili sinav* olarak yapilacaktir. Donem boyunca tum konulardan soru cikabilir.

## DERSLER

### Ders 1 - 13 EKIM
Eclipse ve Git'e giris. Github Hesabi acilmasi.

Bilgi: https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/1_Eclipse-Kullanimi.pdf

### Ders 2 - 27 EKIM
Maven ve Git ile Spring Boot projesi gelistirme.
https://start.spring.io/
https://github.com/

Bilgi:
* https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/2_git-puf-noktalari.pdf
* https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/2_git101.pdf

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

### Ders 3 - 3 KASIM

JUnit & Maven
Bilgi: https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/2_Ders_Sunum.pdf

### Ders 4 - 10 KASIM

Travis CI

#### Continuous Integration (CI) Nedir?
Yazilan kodun, gelistirilen modulun — kisaca gelistirme ortamindan cika gelen bir parcanin — projeye dahil edilmesi esnasinda bir takim sureclerden gecirilmesine verilen isim. Bagimliliklarin repolardan indirilmesi, projeye dahil edilmesi, gelistirilen kod parcacigin testlerden (unit, integration, vs…) gecirilmesi, olasi durumlara gore gelistiriciye veya isin sorumlusuna bilgi verilmesi (push notification, sms, mail, vs…), isin paketlenmesi gibi eylemlerin tamami, genellikle bu kavramin bir parcasi olarak hayatimizda yer ediyor. 
https://medium.com/@selcukusta/continuous-integration-ci-%C3%BCzerine-laflamalar-9b7f7d2dad07



### Ders 5 - 17 KASIM

UML
https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/5_Ders_Sunum.pdf

### ARA SINAV

### Ders 6 - 1 ARALIK

Tekrar

### Ders 7 - 8 ARALIK

Spring Boot Rest API Olusturma & Postman Request ve Postman Code Generation

#### Postman : 
Web Servislerine bir ara yuz araciligiyla istek gondermemizi ve sonucunu goruntulememizi saglar. Ayrica web servisi cagiracak istemci (client) kodunu otomatik olusturmamizi da saglayan bir aractir.

https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/postman/postman1.PNG?raw=true

Bir post istegini test etmek icin, web servis URL'ini yaziyoruz. Headers alanina "Content-Type "application/json" olarak belirtiyoruz. Body kisminda ise gonderecegimiz parametreleri key -> value ikilisi olarak yaziyoruz. Burada key, gonderilecek istege ait parametre, value ise o parametrenin degeridir. Alternatif olarak, Body altindaki raw secilerek, json oalrak da istek yapilabilir. Bu sekilde, ornegin Spring Boot ile gelistirdigimiz REST web servislerine istek yapıp, sonucunu goruntuleyebiliyoruz.

Ek olarak Headers/Body gibi tabların oldugu siradaki en sağdaki "Code" baglantisi secilerek, yapilan istege ait kod da otomatik oalrak olusturulabilir.

Populer bir arac oldugundan, ayrintili bilgi icin internette bir cok farkli kaynak bulunabilir. Ornegin:
* https://medium.com/postman-t%C3%BCrkiye/postman-nedir-622be8afef2e
* https://medium.com/turkce/api-testleri-i%CC%87%C3%A7in-postman-kullanmak-8e407e260b3a

### Ders 8 - 15 ARALIK

JMeter ile REST API testi

#### JMeter

JMeter, sadece web servislerini degil genel olarak bir cok farklı servisi (veritabani, MQ vb) otomatik olarak istek gonderek yuk ve performans testleri yapabilecegimiz bir aractir. Sampler'lar sayesinde farklı test tipleri/istekler calistirilabilir. Listener'lar ile yapilan testlerin/isteklerin sonuclari goruntulenebilir. Bir cok farkli sampler ve listener secenegi mevcuttur. Ornegin HTTP Sampler ile web istekleri simule edilebilir. Bu performans ve yuk testleri yapılırken "Config Element" secenegi ile testlerde kullanılabilecek dinamik degerler olusturmak da mumkundur.

https://github.com/ozkansari/MyCourses/tree/master/SoftwareDevEnvAndTools/_docs/jmeter baglantisi altinda derste yapilan jmeter ornegi ekran goruntuleriyle goruntulenebilir.

Populer bir arac oldugundan, ayrintili bilgi icin internette bir cok farkli kaynak bulunabilir. Ornegin:
* https://gokhansengun.com/jmeter-nedir-ve-ne-ise-yarar/
* http://ilkaygunel.com/blog/2016/jmeter-load-testing/

### Ders 9 - 22 ARALIK

#### MacOS adimlar

1-) jenkins.war indirilir. (Generic WAR http://mirrors.jenkins.io/war-stable/latest/jenkins.war)

2-) bprlab altında jenkins dizini oluşturuldu ve jenkins.war bu dizine tasindi

3-) Terminal bprlab dizininde acilir

4-) "cd jenkins" komutu ile jenkins dizinine girilir

5-) Asagidaki komutlar calistirilir

    export JENKINS_HOME=/Users/bprlab/jenkins
    java -jar jenkins.war --httpPort=49001 --enable-future-java

6-) http://localhost:49001/

7-) Terminalde ******** lar arasinda bulunan sifreyi kopyalayip, ekrandaki "Administrator password" yazan yere yapistirin.

8-) "Install Suggested Plugins" seçin

9-) Kullanici bilgileri (Or. bprlab) olusturun ve "save and continue" secin.

10-) Sonraki ekranlari da "Jenkinse hosgeldiniz" yazisini gorene kadar next/continue/finish diyerek gecin.

11-) Manage Jenkins > Global Tool Configuration > Add JDK secilir. Install Automatically secenegi kaldirilir.

12-) Java Home dizini bulmak icin asagidaki komutlar calistirilir. Bu komutlarin sonucunda ortaya cikan dizin kopyalanir ve jenkinse girilir.

    export JAVA_HOME=`/usr/libexec/java_home`
    /usr/libexec/java_home
    
13-) Manage Jenkins > Global Tool Configuration > Add Git secilir ve altindaki "Jgit" ve "Jgit with Apache Client" eklenir.

14-) Manage Jenkins > Global Tool Configuration > Add Maven secilir. Install Automatically ve Install From Apache secilerek 3.6.0 surumu secilir.

15-) Save denilerek ayarlar kaydedilir.

16-) Yeni Item secerek yeni bir is olusturmaya baslayin.

17-) Bir isim verin. Ornegin: Maven Build Ders 9. "Serbest Stil" isaretleyerek "OK" secin.

18-) Daha sonra "Kaynak Kodu Yonetimi" adimindan "Git" secin ve Repository URL alanina github repository URL'inizi girin. Ornegin: https://github.com/ozkansari/yaz_arac_ders4.git

19-) "Yapılandırma Adımı Ekle" altından "En Ust Seviye Maven Adimlarini Calistir" secin.
Bkz. https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/jenkins/24.PNG

20-) Maven olarak Varsayılan yerine 14. adımda eklediginiz Maven'i secin, hedefi belirtin. Ornegin: install 

21-) Gelismis ayarlari secerek projenin repository altindaki pom yolunu gosterin. Ornegin: Ders4Proje/pom.xml
Bkz. https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/jenkins/25.PNG
Bkz: https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/jenkins/26.PNG

NOTE: Ayrintili bilgiler ve ekran goruntuleri icin: https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/jenkins/README.md

NOTE: Maven otomatik kurulum sorunlari yasayanlar kendileri maven indirip bilgisayarlarina tanitabilirler.
https://maven.apache.org/install.html



#### Windows Kurulum

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

### Ders 10 - 29 ARALIK

Jenkins tekrar

### Ders 11 - 5 OCAK

SonarQube kurulum

#### MacOS adimlar

Kisaca yapilmasi gereken zip dosyasini indirip, acilan zip dosyasi icindeki "/bin/macosx-universal-64/sobar.sh" komutunu start parametresi ile calistirmak yani: .//bin/macosx-universal-64/sobar.sh start

1-) https://www.sonarqube.org/downloads/ sayfasından "Community Edition 7.5" linkine tıklayarak sonarqube-7.5.zip dosyasi indirilir.

2-) Indirildigi dizine gidilir ve zip dosyasi acilir. (Finder>Indirilenler)

3-) Acilan zip dosya klasoru (sonarqube-7.5) bprlab altina tasinir ve klasor ismi "sonarqube" olarak degistirilir. (Eski adi sonarqube-7.5)

4-) Terminal acin. "bprlab" dizinindeyken sonarqube/bin/macosx-universal-64 dizinine gidin

    cd sonarqube
    cd bin
    cd macosx-universal-64
    
5-) Daha sonra asagidaki komutu calistirin.

    ./sonar.sh start
    
6-) Bir sure bekledikten sonra tarayicidan http://localhost:9000/ adresine girilir.

7-) Jenkins Maven Build adiminda "install sonar:sonar" denildiginde sonar analizi otomatik calisacaktir. Console logunun sonunda asagidaki gibi bir ifade gorurseniz, sonar analizi basarili olmustur. Gosterilen baglantiya tiklayarak analiz goruntulenebilir.

    [INFO] ANALYSIS SUCCESSFUL, you can browse http://localhost:9000/dashboard?id=tr.edu.medipol.yazarac%3ADers4Proje

 8-) Ek bazı analizler icin maven install hedefi asagidaki gibi yazilabilir:
 
    clean jacoco:prepare-agent install jacoco:report pmd:pmd sonar:sonar 

Ancak bunun için projenin pom.xml'inde project tagi icine jacoco ayari yapilmasi gerekir:

	<build>
		<plugins>
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.2</version>

				<executions>
					<execution>
						<id>jacoco-initialize</id>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>jacoco-site</id>
						<phase>package</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
Ayrıca maven projesinin Java 8 ile derlenmesi icin pom.xml'e project tagi icine asagidaki ekleme yapilmalidir:

    <properties>
		<maven.compiler.target>1.8</maven.compiler.target>
		<maven.compiler.source>1.8</maven.compiler.source>
    </properties>

:exclamation: [SONARQUBE WINDOWS KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/sonarqube/README.md)

### Ders 12 - 12 OCAK

Quiz Sınavı: https://tr.surveymonkey.com/r/W2TH6LG

### FINAL SINAVI

Final Projesi Mebis'te duyurulan yer ve saatte *yazili sinav* olarak yapilacaktir. Donem boyunca tum konulardan soru cikabilir.

## TAKVIM

* Hafta 1 - 13 EKIM : Ders 1 - Eclipse ve Gite giris. Github Hesabi acilmasi.
* Hafta 2 - 20 EKIM : Lab Tamirati nedeniyle Ders yapilamadi
* Hafta 3 - 27 EKIM : Ders 2 - Maven ve Git ile Spring Boot projesi gelistirme.
* Hafta 4 - 3 KASIM : Ders 3 - JUnit ve Maven
* Hafta 5 - 10 KASIM : Ders 4 - Travis CI
* Hafta 6 - 17 KASIM  : Ders 5 - UML
* Hafta 7 - 24 KASIM  : Ders Yapilamadi
* ARA SINAV
* Hafta 8 - 1 ARALIK  : Ders 6
* Hafta 9 - 8 ARALIK  : Ders 7 - Postman
* Hafta 10 - 15 ARALIK  : Ders 8 - JMeter
* Hafta 11 - 22 ARALIK  : Ders 9 - jenkins
* Hafta 12 - 29 ARALIK  : Ders 10 - jenkins
* Hafta 13 - 5 OCAK  : Ders 11 - sonarqube
* Hafta 14 - 12 OCAK  : Ders Yapilamadi
* Hafta 15 - 19 OCAK  : Ders 12 - quiz ve tekrar
* FINAL SINAVI





