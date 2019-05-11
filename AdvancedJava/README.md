# ILERI JAVA UYGULAMALARI - 2018 2019 BAHAR (Subat 2019 - Haziran 2019)

Dersler Cumartesi 09:00-10:00 ve 10:15-11:30 arasinda iki oturum halinde yapilacaktir.
Derse mazeretiniz yoksa devam zorunludur. Derse devam ve derse katilimdan not verilecektir.

https://classroom.google.com/c/MzA3Mzk2Mjg3NDVa
Kod: ar5vql

## DUYURULAR

Vize yazili sinav olacaktir. Mebisde duyurulan tarihte. Carsamba 18:00.

Ek olarak asagidaki "Proje 1" odevini yapip 19 Nisana kadar teslim etmeniz gerekecektir.

### PROJE 1

#### Teslim Tarihi: 19 Nisan 2019 Cuma 23:59:59'a kadar class room uzeridnen sadece kod dosyalarinizi gonderiniz. Gec teslim kabul edilmeyecektir.

Projelerinizi Derste Sunmaniz istenebilir. Sunum yapmayanlardan uan eksiltilerek not verilecektir.
*Ayni ve benzer proje teslimlerini kopya olarak degerlendirilecektir*

Uygulama kodlarinizi tr/edu/medipol/ilerijava/proje1/<<ad_soyad>>/ paketinde bulunmali <<ad_soyad>> yerine kendi ad ve soyadinizi yazmalisiniz.

#### Aciklama: 

Java ile Sunucu/Istemci (**Socket**) mimarisinde coklu akisi (Multi Thread) destekleyen bir hesaplama uygulamasi yapmanizi bekliyorum.
Sunucu ve Istemci(ler) iki ayri uygulama seklinde calismali. Bir **sunucuya birden fazla istemcinin TCP socket ile baglanmasi desteklenmeli**.

Sunucu tarafinda Java Swing GUI ile **giden gelen mesajlar** ve **bagli istemcilerin listesi** goruntulenmeli.

Istemci tarafinda ise Java Swing GUI ile istemciden **iki ayri sayi** ve **yapilacak islem tipi** ( +,-,/,* ) girdi olarak alinacak ve **GONDER butonu**na basildiginda sunucuya hesaplama islemi **tcp socket iletisimle mesaj olarak** gonderilecektir. Ornegin "2 * 55" gibi bir mesaj istemciden sunucuya gonderilecek.

Bu mesaji alan sunucu ise gelen mesajdaki hesaplama istegini algilayip, sonucu hesaplayacak ve istekte bulunan istemciye sonucu donecektir.

Istemci ise sonuc mesajini alip ekranda (ornegin labelda ya da disabled textfield'da) gosterecektir.

## DERSLER

### Vize Ders 1
Java Tekrari
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders01

### Vize Ders 2
Inheritance
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders02

### Vize Ders 3
Threads
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders03

### Vize Ders 4
Socket Programlama
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders04

### Vize Ders 5
Socket Programlama
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders05

### Vize Ders 6
Java GUI
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders06

### Vize Ders 7
Java GUI + Socket Programlama
Lab: https://github.com/ozkansari/MyCourses/tree/master/AdvancedJava/src/main/java/tr/edu/medipol/ilerijava/ders07

---

### Final Ders 2
TCP IP Socket ile HTTP Sunucusu Yazma - Web Programlama 
https://github.com/ozkansari/MyCourses/tree/master/JavaHTTPServer

### Final Ders 3
Spark Java ile Web Programlama

1-) Maven Proje Olusturun (Eclipse'de File>New>Other>Maven Project)
* group id : spark.template.freemarker.medipol
* artifactid: OgrenciWeb

2-) pom. xml dependency'lerine spark java kutuphanelerini ekleyin.

pom.xml dosyasinda dependencies tagi icine:

```xml
<!-- Spark Java Web programlama yapmamizi saglayan kutuphane -->
	<dependency>
	    <groupId>com.sparkjava</groupId>
	    <artifactId>spark-core</artifactId>
	    <version>1.1.1</version>
	</dependency>
	<!-- HTML olusturmak icin freemarker kullaniminda gerekli -->
	<dependency>
	    <groupId>com.sparkjava</groupId>
	    <artifactId>spark-template-freemarker</artifactId>
	    <version>1.0</version>
	</dependency>
	<!--
	<dependency>
	    <groupId>org.freemarker</groupId>
	    <artifactId>freemarker</artifactId>
	    <version>2.3.28</version>
	</dependency>
	-->
	<!-- Ekstra spark loglarini acmak icin. Hata incelemede faydali. -->
	<dependency>
		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-simple</artifactId>
		<version>1.7.21</version>
	</dependency>
```

pom. xml'in son hali:


```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>spark.template.freemarker.medipol</groupId>
  <artifactId>OgrenciWeb</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>Ornek Web Projesi</name>
  <description>Sparkjava kullanarak ornek web projesi olusturma</description>
  <properties>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.source>1.8</maven.compiler.source>
  </properties>
  <dependencies>
  	<!-- Spark Java Web programlama yapmamizi saglayan kutuphane -->
	<dependency>
	    <groupId>com.sparkjava</groupId>
	    <artifactId>spark-core</artifactId>
	    <version>1.1.1</version>
	</dependency>
	<!-- HTML olusturmak icin freemarker kullaniminda gerekli -->
	<dependency>
	    <groupId>com.sparkjava</groupId>
	    <artifactId>spark-template-freemarker</artifactId>
	    <version>1.0</version>
	</dependency>
	<!--
	<dependency>
	    <groupId>org.freemarker</groupId>
	    <artifactId>freemarker</artifactId>
	    <version>2.3.28</version>
	</dependency>
	-->
	<!-- Ekstra spark loglarini acmak icin. Hata incelemede faydali. -->
	<dependency>
		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-simple</artifactId>
		<version>1.7.21</version>
	</dependency>
  </dependencies>
</project>
```

3-)


---

## Notlar

![NOTLAR](https://github.com/ozkansari/MyCourses/raw/master/AdvancedJava/_docs/vize_notlar.PNG?v=1)

---

## TAKVIM

* Hafta 1 - 23 SUBAT : Vize Ders 1 - Java Tekrari
* Hafta 2 -  2 MART  : Vize Ders 2 - Java Inheritance, Abstract Classes
* Hafta 3 -  9 MART  : Vize Ders 3 - Threads
* Hafta 4 - 16 MART  : Vize Ders 4 - Socket Programming
* Hafta 5 - 23 MART  : Vize Ders 5 - Socket Programming
* Hafta 6 - 30 MART  : Vize Ders 6 - Socket Programming + GUI 
* Hafta 7 - 6 NISAN  : Vize Ders 7 - Socket Programming + GUI
* << ARA SINAVLAR : 06.04.2019	14.04.2019 >>
* Hafta 8 - 13 NISAN  : Ders Yapilmayacak
* Hafta 9 - 20 NISAN  : Proje uzerine calisma - 
* Hafta 10 - 27 NISAN  : Final Ders 1
* Hafta 11 - 4 MAYIS  : Final Ders 2
* Hafta 12 - 11 MAYIS  : Final Ders 3
* Hafta 13 - 18 MAYIS  : Final Ders 4
* Hafta 14 - 25 MAYIS  : Final Ders 5
* Hafta 15 - 1 HAZIRAN  : Final Ders 6
* << RAMAZAN BAYRAMI : 03.06.2019	06.06.2019 >>
* Hafta 16 - 8 HAZIRAN  : Final Ders 7 - Tekrar
* << DONEM SONU SINAVLARI : 11.06.2019	23.06.2019 >>


