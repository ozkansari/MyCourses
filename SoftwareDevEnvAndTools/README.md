# YAZILIM GELİŞTİRME ORTAM ve ARACLARI
2018 BAHAR

Dersler Cumartesi 12:00-13:00 ve 13:15-14:30 arasında iki oturum halinde yapılacaktır.
Derse mazeretiniz yoksa %80 devam zorunludur. Derse devam ve derse katılımdan not verilecektir.

## ODEVLER

### Odev 1

En az 10 Matematiksel işlem için 10 ayrı metod içeren Hesaplama sınıfı yazılacak. 
Bu 10 Matematikel işlemin her biri için de 10 ayrı JUnit test metodu yazılacak.
Uygulama Maven projesi şeklinde geliştirilecek ve Maven test ve install komutların çalışması kontrol edilecek.
Teslim tarihi:23 Mart 23:59'a kadar
Odevleri ozkan.sari@outlook.com adresine  gönderiniz.

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

### Hafta 6: Jenkins

#### Jenkins Kurulum
https://jenkins.io/download/ adresinden indirilebilir.
1. Seçenek: Windows Kurulum : https://jenkins.io/download/thank-you-downloading-windows-installer-stable
2. Seçenek: Generic WAR http://mirrors.jenkins.io/war-stable/latest/jenkins.war

Java komutu ile konsoldan çalıştırılabilir. Buradaki java komutunun jdk altındaki java komutu olması iyi olur. Bunun için java komurunu tam yol olarak tırnak içinde de yazabilirsiniz. Örneğin, "Cİ\Program Files\Java\jdk8\bin\java" - jar jenkins.war gibi.

    java -jar jenkins.war
    
8080 portu kullanımdaysa başka bir port aşağıdaki şekilde belirtilebilir:

    java -jar jenkins.war --httpPort=49001

Jenkins home dizinini değiştirmek için çalıştırmadan önce başka bir dizin belirtebilirsiniz. Örneğin:

    SET JENKINS_HOME=C:/jenkins

:exclamation: [JENKINS KURULUM NOTLARI](https://github.com/ozkansari/MyCourses/blob/master/SoftwareDevEnvAndTools/_docs/jenkins/README.md)

#### Jenkins Arayüzü
Tarayıcıdan http://localhost:8080 girerek ara yüz açılabilir.
Daha sonra karşınıza çıkan "Unlock Jenkins" ekranında verilen dizindeki dosyayı açın ve orada yazan şifreyi ekrana girin (Şifre console'dan çalıştırdığınızda loglarda da görünecektir) ve Continue tuşuna basın. Sonraki ekranda "Installed Suggested Plugins" seçiniz. Ayrıntılar için: https://jenkins.io/doc/book/installing/#setupwizard

Plugin kurulum tamamlandıktan sonra, Admin password belirlemenizi isteyecek. belirledikten sonra Jenkins artık kullanıma hazır.

Bu aşamada "Jenkinse Hoşgeldiniz" yazısını ekranda görmeniz lazım.

Jenkinsi Yönet ekranından JDK, Git ve Maven ayarlarını yaptıktan sonra başlamak için "Yeni İş" oluşturuyoruz.

...

## Notlar

..

