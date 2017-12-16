# YAZILIM ORTAM ve ARACLARI
2017 GÜZ - BPR216053

Dersler Cumartesi 12:00-13:00 ve 13:15-14:30 arasında iki oturum halinde yapılacaktır.
Derse %80 devam zorunludur. Derse devam ve derse katılımdan not verilecektir.

[KANBAN TAHTASI](https://kanbanflow.com/board/431c1561cc21b3a1b4ad19175f70f668)

## VİZE SINAVI
Yazılı sınav olacaktır.

    Meslek Yüksekokulu - Bilgisayar Programcılığı Programı / 2. Sınıf - YAZILIM GELİŞTİRME ORTAM VE ARAÇLARI
    1. Ara Sınav
    Yer: MYO LAB.(GİRİŞ)
    Tarih: 9.12.2017
    Saat: 12:00 - 13:00

## ÖDEV

## ÖDEV 1
a-) https://github.com/ozkansari/YAZILIM_ARACLARI_REPO repository'sindeki master branch üzerinden isminize özel branch oluşturun.
b-) Derste şahsınıza atanan ya da seçtiğiniz bir matematiksel operasyonu aynı isimle bir Sınıfta kodunu yazın.
c-) Yazdığınız operasyonun JUnit ile birim testini yazın.
d-) Branch'ınızdaki değişiklikleri commitleyin ve push'layın.

## DERS ICERIKLERI

### Hafta 1
- [Sunum](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools_2017Autumn/_docs/1_Ders_Sunum.pdf)
- [Eclipse IDE](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools_2017Autumn/_docs/1_Eclipse-Kullanimi.pdf)

### Hafta 2 
- [Sunum](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools_2017Autumn/_docs/2_Ders_Sunum.pdf)

### Hafta 3 : UML
- [Sunum](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools_2017Autumn/_docs/3_Ders_Sunum.pdf)

### Hafta 4-5: Maven, JUnit ve Git
- [Sunum](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools_2017Autumn/_docs/4_Ders_Sunum.pdf)

- https://github.com/ozkansari/YAZILIM_ARACLARI_REPO

### Hafta 6: Jenkins

#### Jenkins Kurulum
https://jenkins.io/download/ adresinden indirilebilir.
1. Seçenek: Windows Kurulum : https://jenkins.io/download/thank-you-downloading-windows-installer-stable
2. Seçenek: Generic WAR http://mirrors.jenkins.io/war-stable/latest/jenkins.war

    java -jar jenkins.war
    
8080 portu kullanımdaysa başka bir port aşağıdaki şekilde belirtilebilir:

    java -jar jenkins.war --httpPort=49001

:exclamation: [JENKINS KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools_2017Autumn/_docs/jenkins/README.md)

#### Jenkins Arayüzü
Tarayıcıdan http://localhost:8080 girerek ara yüz açılabilir.
Daha sonra karşınıza çıkan "Unlock Jenkins" ekranında verilen dizindeki dosyayı açın ve orada yazan şifreyi ekrana girin (Şifre console'dan çalıştırdığınızda loglarda da görünecektir) ve Continue tuşuna basın. Sonraki ekranda "Installed Suggested Plugins" seçiniz. Ayrıntılar için: https://jenkins.io/doc/book/installing/#setupwizard

Plugin kurulum tamamlandıktan sonra, Admin password belirlemenizi isteyecek. belirledikten sonra Jenkins artık kullanıma hazır.

Bu aşamada "Jenkinse Hoşgeldiniz" yazısını ekranda görmeniz lazım.

Jenkinsi Yönet ekranından JDK, Git ve Maven ayarlarını yaptıktan sonra başlamak için "Yeni İş" oluşturuyoruz.

### Hafta 7: SonarQube

https://www.sonarqube.org/downloads/ adresinden sonar uygulamasını zip olarak indirin ve zip dosyasını açın. 

Maven build projenize sonar:sonar aben hedefini belirterek bir sonar analizi çalıştırabilirsiniz.

:exclamation: [SONARQUBE KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools_2017Autumn/_docs/sonarqube/README.md)

## Notlar
![NOTLAR](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools_2017Autumn/_docs/Notlar2017Guz.PNG)

## Hafta 8 Javadoc

Maven komutu: 
    install checkstyle:checkstyle pmd:pmd sonar:sonar javadoc:javadoc javadoc:aggregate site

Jenkins Java Doc goruntuleme sorunu icin Jenkins Script'i acın (http://localhost:8080/script) ve asagidaki komutu calistirin.
     System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src 'none'; img-src 'self'; style-src 'self'; child-src 'self'; frame-src 'self';")
