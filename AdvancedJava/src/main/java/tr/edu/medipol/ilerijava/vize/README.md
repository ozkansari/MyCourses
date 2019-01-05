Java ile Sunucu/Istemci (Socket) mimarisinde coklu akisi (Multi Thread) destekleyen bir hesaplama uygulamasi yapmanizi bekliyorum. Sunucu ve Istemci(ler) iki ayri uygulama seklinde calismali. Bir sunucuya birden fazla istemcinin TCP socket ile baglanmasi desteklenmeli.

Sunucu tarafinda Java Swing GUI ile giden gelen mesajlar ve bagli istemcilerin listesi goruntulenmeli.

Istemci tarafinda ise Java Swing GUI ile istemciden iki ayri sayi ve yapilacak islem tipi ( +,-,/,* ) girdi olarak alinacak ve GONDER butonuna basildiginda sunucuya hesaplama islemi tcp socket iletisimle mesaj olarak gonderilecektir. Ornegin "2 * 55" gibi bir mesaj istemciden sunucuya gonderilecek.

Bu mesaji alan sunucu ise gelen mesajdaki hesaplama istegini algilayip, sonucu hesaplayacak ve istekte bulunan istemciye sonucu donecektir.

Istemci ise sonuc mesajini alip ekranda (ornegin labelda ya da disabled textfield'da) gosterecektir.

NOT SKALASI
-------------------

Sunum:
- [  / 25 ] Sorulari Cevaplayabilme

Program:
- [  /  5 ] Islem tipinin girdi olarak alinmasi 
- [  / 10 ] Sonucun sunucu tarafinda hesaplanmasi ve istemciye donulmesi
- [  / 10 ] Sonucun istemci tarafindan alinip goruntulenebilmesi

Konular:
- [  / 15 ] Socket Sunucu
- [  / 15 ] Socket Istemci
- [  / 15 ] Multi Thread destegi
- [  / 10 ] Java Swing GUI

Islevler:
- [  / 10 ] Bir sunucuya birden fazla istemcinin baglanabilmesi
- [  /  5 ] GUI'de giden gelen mesajlarin goruntulenebilmesi
- [  /  5 ] GUI'de bagli istemcilerin listesinin goruntulenebilmesi

+--------------------------------------------------------------------------
Sonuc:


