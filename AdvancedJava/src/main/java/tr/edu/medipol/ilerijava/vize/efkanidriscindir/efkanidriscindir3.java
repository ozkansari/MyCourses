package tr.edu.medipol.ilerijava.vize.efkanidriscindir;

import java.net.*;
import java.io.*;
import java.util.*;

public class efkanidriscindir3 extends Thread{
public double sonuc = 0;
String[] gel = new String[4];
private Socket istembag;
public efkanidriscindir3(Socket istembagl) {
this.istembag = istembagl;
}
@Override
public void run() {
System.out.println("Thread calisiyor" +

istembag.getInetAddress());
BufferedReader istemciOkuyucu = null;

try {
InputStream girdi = this.istembag.getInputStream();
InputStreamReader girdiOkuyucu = new InputStreamReader(girdi);
istemciOkuyucu = new BufferedReader(girdiOkuyucu);
istemciOkuyucu = new BufferedReader(
new InputStreamReader(

istembag.getInputStream()

)

);
} catch (IOException e) {
System.out.println("Istemci okuyucu acilirken hata: "

+ e.getMessage()) ;

}
int i=0;
do {
try {
gel[i] = istemciOkuyucu.readLine();
if (gel[i] == null) {break;}
System.out.println(gel[i]);
i++;
} catch (IOException e) {
break;
}
} while(true);
if (gel[2].equals("+")) {
sonuc =(Integer.valueOf(gel[0])+Integer.valueOf(gel[1]));
}
else if (gel[2].equals("-")) {
sonuc =(Integer.valueOf(gel[0])-Integer.valueOf(gel[1]));
}
else if (gel[2].equals("*")) {
sonuc =(Integer.valueOf(gel[0])*Integer.valueOf(gel[1]));
}
else if (gel[2].equals("/")) {
sonuc =(Integer.valueOf(gel[0])/Integer.valueOf(gel[1]));
}
else {
System.out.println("Yanlýþ Giriþ");
}
System.out.println(sonuc);
}

}