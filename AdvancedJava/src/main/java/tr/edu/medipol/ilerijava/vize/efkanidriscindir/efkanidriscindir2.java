package tr.edu.medipol.ilerijava.vize.efkanidriscindir;

import java.io.*;
import java.net.*;
import java.util.*;
public class efkanidriscindir2 {
public static final int SERVER_PORT = 2222;
private static ServerSocket sunucuSocketi;
public static void main(String[] args) throws UnknownHostException, IOException {
try {
sunucuSocketi = new ServerSocket(SERVER_PORT);
System.out.println("Istemciler bekleniyor." +
sunucuSocketi.getLocalPort());

while(true) {
Socket istembag = sunucuSocketi.accept();
System.out.println("Istemci baðlantýsý baþarýlý. " +

istembag.getInetAddress());

efkanidriscindir3 bal =

new efkanidriscindir3(istembag);

bal.start();
}
} catch (IOException e) {
System.out.println(SERVER_PORT +

" Ustunden sunucu socketi acarken hata olustu");

e.printStackTrace();
}
}
}