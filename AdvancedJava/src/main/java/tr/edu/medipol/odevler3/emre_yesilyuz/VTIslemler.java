package tr.edu.medipol.odevler3.emre_yesilyuz;
//Hocam VtIslemler etkin oldugunda baglanti kurmuyo hata olusuyo bu yuzden derlemiyor etkin yapmadim bu yuzden .

import java.sql.*;
import java.util.ArrayList;

import static java.lang.Class.forName;

public class VTIslemler {
	/*
    static Connection baglanti;
    //Veritabanina baglanmak icin kullanacagimiz baglantiAc metodu
    public static Connection baglantiAc(){
        try {
            forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Konunun basinda bahsettigim derby veritabanina baglanmak icin gerekli baglanti cumlesi
            baglanti=DriverManager.getConnection("jdbc:derby:C:\\Users\\Emre\\Ogrenci","","");
            //DriverManager ile Ogrenci isminde ki veritabanimiza baglaniyoruz. 2. ve 3. parametre veritabani kullanici adi ve sifresi
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return baglanti;
    }

    //Veritabani islemlerini hallettikten sonra veritabanini kapatmaya yarayan baglantiKapa metodu
    public static void baglantiKapa(){
        try {
            baglanti.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //ogrenci bilgilerini veritabanindan alarak, ArrayList olarak donduren metodumuz
    public ArrayList<Ogrenci> ogrenciBilgisiCek(){

        ArrayList<Ogrenci> ogrenciBilgileri=new ArrayList<Ogrenci>();
        //cekilen ogrenci bilgilerini tutacagimiz bir ArrayList olusturuyoruz.
        try {
            Connection baglanti=baglantiAc();
            String sorgu="select * from APP.ogrenci";
            //ogrenci tablosundaki tum verileri ceken sql sorgusu.
            PreparedStatement ps=baglanti.prepareStatement(sorgu);
            ResultSet rs=ps.executeQuery();
            //Veritabanindan cekilen verileri resultsete doldurduk.
            while (rs.next()) {
                Ogrenci ogr=new Ogrenci();
                //ogrenci nesnesi olusturduk.
                ogr.setOgrNo(rs.getInt("ogrnum"));
                ogr.setIsim(rs.getString("isim"));
                ogr.setSoyIsim(rs.getString("soyisim"));
                ogr.setdYeri(rs.getString("dyeri"));
                //ogr nesnemize resultsetten gelen verileri doldurduk.
                ogrenciBilgileri.add(ogr);
            }
            //While dongusu ile ResultSetteki verileri basta olusturdugumuz ArrayListe aktardik.
            ps.close();
            rs.close();
            baglantiKapa();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ogrenciBilgileri;
        //ogrenci verilerini doldurdugumuz ArrayListi return ile donduruyoruz.

    }

    //Gonderilen ogrenci nesnesini veritabanina kaydeden ogrenciKaydet metodu
    public boolean ogrenciKaydet(Ogrenci ogrenci){

        try {
            Connection baglanti=baglantiAc();
            String sorgu="insert into APP.ogrenci(ogrno,isim,soyisim,dyeri) values(?,?,?,?)";
            //ogrenci tablosuna verileri kaydetmeye yarayan sql sorgusu ? ile gosterilen yerler parametreler
            PreparedStatement ps=baglanti.prepareStatement(sorgu);
            ps.setInt(1, ogrenci.getOgrNo());
            ps.setString(2, ogrenci.getIsim());
            ps.setString(3, ogrenci.getSoyIsim());
            ps.setString(4, ogrenci.getdYeri());
            // 4 tane ? ile gosterilen parametreye degerlerini aktariyoruz.
            //Degerleri ogrenciKaydet metodumuza gonderilen ogrenci nesnesinden aliyoruz.
            ps.executeUpdate();
            ps.close();
            baglantiKapa();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Veritabanindan ogrenci silmeye yarayan ogrenciSil metodu
    public boolean ogrenciSil(int ogrenciNo){

        try {
            Connection baglanti=baglantiAc();
            String sorgu="delete from APP.ogrenci where ogrno=?";
            //ogrenci tablosundan ogrno'ya gore veri silen sql sorgumuz
            PreparedStatement ps=baglanti.prepareStatement(sorgu);
            ps.setInt(1, ogrenciNo);
            //Parametre olarak ogrenciSil metoduna gonderilen ogrenciNo'yu kullaniyoruz.
            ps.executeUpdate();
            ps.close();
            baglantiKapa();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Veritabanindaki ogrenci verilerini guncellemeye yarayan ogrenciGuncelle metodu
    public boolean ogrenciGuncelle(Ogrenci ogrenci){
        try {
            Connection baglanti=baglantiAc();
            String sorgu="update APP.ogrenci set isim=?,soyisim=?,dyeri=? where ogrno=?";
            //ogrenci tablosundaki verileri guncellemeye yarayan sql sorgusu. ogrno'ya gore guncelleme yapiyor.
            PreparedStatement ps=baglanti.prepareStatement(sorgu);
            ps.setString(1, ogrenci.getIsim());
            ps.setString(2, ogrenci.getSoyIsim());
            ps.setString(3, ogrenci.getdYeri());
            ps.setInt(4, ogrenci.getOgrNo());
            //Parametreleri ogrenciGuncelle metodumuza gonderilmis olan ogrenci nesnesinden aliyoruz.
            ps.executeUpdate();
            ps.close();
            baglantiKapa();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }*/
}
