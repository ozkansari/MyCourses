// ----------------------------------------------------------
// DEGERLENDIRME: 66

* Yayın evi ekle : 
** (5/5) Yayın evi adı ve e-posta adresi girdi olarak alınacaktır. 
** Eklenen yayınevleri kitap eklemede seçenek olarak sunulacaktır. 
** (10/10) E-posta adresi eklemede düzenli ifade (regular expression) kontrolü yapılmalıdır. Hatalı formatta e-posta girişine izin verilmemelidir. 
** (5/5) Aynı şekilde boş girişe de izin verilmemelidir.

* Kitap Ekle : 
** (1/5) Sistemde eklenmiş yayın evi yoksa kitap eklemeye izin verilmemelidir. 
--> Yayinevi yoksa program dosya bulunamama hatasi veriyor. Panel acilmiyor.
** (5/5) Kitap eklerken kitap adı, yazarı, türü, yayın evi, sayfa sayısı vb. sorular sorulacaktır. 
** (8/10) Yayın evi için sisteme eklenenler arasından seçim yaptırılmalıdır. 
--> Dosyadan okurken bazen hatalı okuyor.
** (5/5) Sayfa sayısı alanına sayı dışında bir değer girilmesine izin verilmemelidir. 
** (0/5) Aynı şekilde boş girişe de izin verilmemelidir.

* Kitapları Listele : 
** (10/10) Kitaplar bilgileriyle birlikte listelenebilecektir. 
** (2/10) Listelenen kitapların yanında silme seçeneği de bulunacaktır.
--> Guncelleme dosya icerigini guncelliyor. Kayitlari degil.

* (5/5) Çıkış: Uygulamadan çıkış

* (10/15) Uygulama çıkışta sistemdeki kayitlari dosyaya yazacak ve uygulama acilirken kaldigi yerden devam edebilmesi icin dosyadan kayitlari okuyacaktir.
--> Direkt text yaziliyor

* (0/10) Uygulamanızda Kitap ve Yayinevi isimli sınıflar tanımlanmalı ve bunlar sistemde ArrayList olarak tutulmalı.

//----------------------------------------------------------
DIGER:
(-10) Arayuz sinifindaki degisken isimleri. TR karakterli oldugundan sorunluydu, derlenmiyordu. Duzeltildi. 
(-5) Formatsiz kod. DUZELITLDI.
(-10) Dosya ilk olusturulurken yolu bulamıyor, dosya olusturulamıyor.
(+5) Menubar kullanimi
(+5) JOptionPane mesaj
(+5) try catch

TESELLI:
(+10) Menü ve Grafik ara yuz basarili olsuturulmus

//----------------------------------------------------------