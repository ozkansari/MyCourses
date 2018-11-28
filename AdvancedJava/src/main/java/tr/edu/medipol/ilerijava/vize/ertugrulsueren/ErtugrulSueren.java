package tr.edu.medipol.ilerijava.vize.ertugrulsueren;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ErtugrulSueren {

private static final int SERVER_PORT = 1234;

private static Socket sunucubag;

public static void main(String[] args) throws InterruptedException{
	
Scanner input = new Scanner(System.in);

int sayý1=0,sayý2=0;

String al;

System.out.print("Sayý Gir:");

sayý1 = input.nextInt();

sayý2 = input.nextInt();

System.out.println("Ýþlem Seç");

al = input.next();

System.out.println("Istemciye Giriliyor");

PrintWriter msj = null;

try {
	
	sunucubag = new Socket("localhost",

	ErtugrulSueren.SERVER_PORT);

msj =

new PrintWriter(sunucubag.getOutputStream());

} catch (UnknownHostException e) {
	
System.out.println("IP hatali" + e.getMessage());

} catch (IOException e) {
	
System.out.println("Sunucu Baðlantýsý Hata" +

e.getMessage());

}
msj.println(sayý1);

msj.println(sayý2);

msj.println(al);

msj.flush();

}
}