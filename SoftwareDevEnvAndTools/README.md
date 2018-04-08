# YAZILIM GELİŞTİRME ORTAM ve ARACLARI
2018 BAHAR

# Vize sinavi 11 Nisan Carsamba Saat 18:00'de yazili sinav olarak yapilacaktir. A202 No'lu Derslikte.

    Meslek Yüksekokulu - Bilgisayar Programciligi ( I.Ö.) Programi / 2. Sinif - YAZILIM GELISTIRME ORTAM VE ARAÇLARI, 1. Ara Sinav	A202 No'lu Derslik	11.4.2018	18:00
    Meslek Yüksekokulu - Bilgisayar Programciligi Programi / 2. Sinif - YAZILIM GELISTIRME ORTAM VE ARAÇLARI, 1. Ara Sinav	A202 No'lu Derslik	11.4.2018	18:00

# 14 NISAN CUMARTESI DERS YAPILMAYACAKTIR

Dersler Cumartesi 12:00-13:00 ve 13:15-14:30 arasında iki oturum halinde yapılacaktır.
Derse mazeretiniz yoksa %80 devam zorunludur. Derse devam ve derse katılımdan not verilecektir.

## ODEVLER

### Odev 1

En az 10 Matematiksel işlem için 10 ayrı metod içeren Hesaplama sınıfı yazılacak. 
Bu 10 Matematikel işlemin her biri için de 10 ayrı JUnit test metodu yazılacak.
Uygulama Maven projesi şeklinde geliştirilecek ve Maven test ve install komutların çalışması kontrol edilecek.
Teslim tarihi:23 Mart 23:59'a kadar
Odevleri ozkan.sari@outlook.com adresine  gönderiniz.

### Odev 2
* https://github.com/ozkansari/YAZILIM_ARACLARI_REPO repository'sini git ile indirin (checkout)
* Bu repository'deki master branch üzerinden isminize özel (ad_soyad şeklinde) branch oluşturun.
* Seçtiğiniz bir matematiksel operasyonu aynı isimle bir Sınıfta kodunu yazın.
* Yazdığınız operasyonun JUnit ile birim testini yazın.
* Branch'ınızdaki değişiklikleri commitleyin ve push'layın

Teslim Tarihi: 20 Nisan 23:59:59

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

## Notlar

![NOTLAR](https://github.com/ozkansari/MyCourses/raw/master/SoftwareDevEnvAndTools/_docs/Notlar_SwDev.png)

