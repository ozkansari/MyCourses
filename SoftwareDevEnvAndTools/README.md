# YAZILIM GELISTIRME ORTAM ve ARACLARI : 2019 - 2020 GUZ (Ekim 2019 - Ocak 2020)

Dersler Persembe 19:45-21:45 arasinda blok halde yapilacaktir.

Derse mazeretiniz yoksa devam zorunludur. Derse devam ve derse katilimdan not verilecektir.

Notlandirma: Derse Katilim + Mini Sinavlar + Lab Calismasi + Odevler + Projeler + Yazili Sinav

https://classroom.google.com/c/Mzg0MTU5OTk5NTFa

Kod: w6rrc8a (Okul hesabi ile degil, kisisel hesabinizi kullanininiz)


## DUYURULAR

Google Clasrooma kayit yaptiriniz ve github hesabi olusturunuz.

---


## DERSLER

### Vize Ders 1

Genel yazilim Gelistirme Kavramlari
Tumlesik Gelistirme Ortamlari (IDE)
Eclipse


### Vize Ders 2

Yazilim Surec Adimlari: Analiz, Tasarim, Gercekleme, Test, Bakim vb.
Yazilim Surec Modelleri: Waterfall, Sarmal, Çekik Surecler (Scrum,Kanban)


### VIZE Ders 6 - 31 MART

#### YAPILACAKLAR:

##### Github Hesabi Acma, Repo olusturma ve Bunu Eclipse'e Baglama
* Github.com hesabi acin --> https://github.com/
* Hesabinizda bir repository/project olusturun. Ornegin: medipol
* Actiginiz repository'de README ve .gitignore sayfalari olusturun.
* Repository'ye "download/clone" ile elde ettiginiz URL'i, Eclipse'deki "Git Repository" view'ina sag tiklayip yapistir. Daha sonra kullanici bilgilerini gir ve adimalri tamamla. Boylece repository'yi Eclipse icinde gormeye baslayacaksin.
* Eclipse'de gorunen repository icindeki master branchine sag tiklayarak yeni bir branch olustur. Ornegin: ders2

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

---


### Final Ders 1

### FINAL DERS 1 - Continous Integration (Surekli Entegrasyon) ve Code Coverage (Kod Kapsama Orani)

Code Coverage (Kod Kapsama Orani): Yazilan Kodun Ne Kadarinin Test Edildigini Gosterir. Code Coverage, yazdigimiz testlerin kontrol ettigi kodun, yazdigimiz koda orani demek. Cobertura ve Codecov.io araclari kullanilabilir.

Continuous Integration (CI - Surekli Entegrasyon) : Yazilan kodun, gelistirilen modulun kisaca gelistirme ortamindan cika gelen bir parcanin projeye dahil edilmesi esnasinda bir takim sureclerden gecirilmesine verilen isim. Bagimliliklarin repolardan indirilmesi, projeye dahil edilmesi, gelistirilen kod parcacigin testlerden (unit, integration, vs.) gecirilmesi, olasi durumlara gore gelistiriciye veya isin sorumlusuna bilgi verilmesi (push notification, sms, mail, vs.), isin paketlenmesi gibi eylemlerin tamami, genellikle bu kavramin bir parcasi olarak hayatimizda yer ediyor. https://medium.com/@selcukusta/continuous-integration-ci-%C3%BCzerine-laflamalar-9b7f7d2dad07 Travis.ci veya Jenkins araclari kullanilabilir.

#### JaCoCo Code Coverage (Kodun Ne Kadarinin Test Edildiginin Olculmesi)

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



---

## Notlar

...


---

## TAKVIM

* Hafta 1  - 26 EYLUL : Deprem Nedeniyle Iptal Edildi
* Hafta 2  -  3 EKIM  : Vize Ders 1 - Genel yazilim Gelistirme Kavramlari ve Tumlesik Gelistirme Ortamlari 
* Hafta 3  - 10 EKIM  : Vize Ders 2 - Yazilim Surec Adimlari ve Modelleri
* Hafta 4  - 17 EKIM  : Vize Ders 3 - UML
* Hafta 5  - 24 EKIM  : Vize Ders 4 - Maven, JUnit, Git
* Hafta 6  - 31 EKIM  : 29 Ekim Haftasi Nedeniyle Ders Yapilmayacak 
* Hafta 7  -  7 KASIM : Vize Ders 5 - Maven, JUnit, Git (Devami ..)
* << ARA SINAVLAR : 09.11.2019	17.11.2019 >>
* Hafta 8  - 21 KASIM  : Final Ders 1 - Continous Integration (Surekli Entegrasyon) ve Code Coverage (Kod Kapsama Orani)
* Hafta 9  - 28 KASIM  : Final Ders 2 - Travis CI & CodeCov IO
* Hafta 10 -  5 ARALIK : Final Ders 3 - Spring Boot & Postman
* Hafta 11 - 12 ARALIK : Final Ders 4 - Spring Boot & JMeter
* Hafta 12 - 19 ARALIK : Final Ders 5 - Jenkins & Sonarqube
* Hafta 13 -  2 OCAK   : 1 Ocak Yilbasi Tatili Nedeniyle Ders Yapilmayacak 
* << DONEM SONU SINAVLARI : 06.01.2020	16.01.2020 >>
* << BUTUNLEME SINAVLARI : 23.01.2020	26.01.2020 >> 	

