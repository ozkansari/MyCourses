package tr.edu.medipol.odevler2.emre_yesilyuz;
//Hocam VtIslemler etkin olduğunda bağlantı kurmuyo hata oluşuyo bu yüzden derlemiyor etkin yapmadım bu yüzden .

import java.sql.*;
import java.util.ArrayList;

import static java.lang.Class.forName;

public class VTIslemler {
	/*
    static Connection baglanti;
    //Veritabanına bağlanmak için kullanacağımız baglantiAc metodu
    public static Connection baglantiAc(){
        try {
            forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Konunun başında bahsettiğim derby veritabanına bağlanmak için gerekli bağlantı cümlesi
            baglanti=DriverManager.getConnection("jdbc:derby:C:\\Users\\Emre\\Ogrenci","","");
            //DriverManager ile Ogrenci isminde ki veritabanımıza bağlanıyoruz. 2. ve 3. parametre veritabanı kullanıcı adı ve şifresi
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return baglanti;
    }

    //Veritabanı işlemlerini hallettikten sonra veritabanını kapatmaya yarayan baglantiKapa metodu
    public static void baglantiKapa(){
        try {
            baglanti.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Öğrenci bilgilerini veritabanından alarak, ArrayList olarak döndüren metodumuz
    public ArrayList<Ogrenci> ogrenciBilgisiCek(){

        ArrayList<Ogrenci> ogrenciBilgileri=new ArrayList<Ogrenci>();
        //Çekilen öğrenci bilgilerini tutacağımız bir ArrayList oluşturuyoruz.
        try {
            Connection baglanti=baglantiAc();
            String sorgu="select * from APP.ogrenci";
            //ogrenci tablosundaki tüm verileri çeken sql sorgusu.
            PreparedStatement ps=baglanti.prepareStatement(sorgu);
            ResultSet rs=ps.executeQuery();
            //Veritabanından çekilen verileri resultsete doldurduk.
            while (rs.next()) {
                Ogrenci ogr=new Ogrenci();
                //Öğrenci nesnesi oluşturduk.
                ogr.setOgrNo(rs.getInt("ogrnum"));
                ogr.setIsim(rs.getString("isim"));
                ogr.setSoyIsim(rs.getString("soyisim"));
                ogr.setdYeri(rs.getString("dyeri"));
                //ogr nesnemize resultsetten gelen verileri doldurduk.
                ogrenciBilgileri.add(ogr);
            }
            //While döngüsü ile ResultSetteki verileri başta oluşturduğumuz ArrayListe aktardık.
            ps.close();
            rs.close();
            baglantiKapa();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ogrenciBilgileri;
        //Öğrenci verilerini doldurduğumuz ArrayListi return ile döndürüyoruz.

    }

    //Gönderilen öğrenci nesnesini veritabanına kaydeden ogrenciKaydet metodu
    public boolean ogrenciKaydet(Ogrenci ogrenci){

        try {
            Connection baglanti=baglantiAc();
            String sorgu="insert into APP.ogrenci(ogrno,isim,soyisim,dyeri) values(?,?,?,?)";
            //ogrenci tablosuna verileri kaydetmeye yarayan sql sorgusu ? ile gösterilen yerler parametreler
            PreparedStatement ps=baglanti.prepareStatement(sorgu);
            ps.setInt(1, ogrenci.getOgrNo());
            ps.setString(2, ogrenci.getIsim());
            ps.setString(3, ogrenci.getSoyIsim());
            ps.setString(4, ogrenci.getdYeri());
            // 4 tane ? ile gösterilen parametreye değerlerini aktarıyoruz.
            //Değerleri ogrenciKaydet metodumuza gönderilen ogrenci nesnesinden alıyoruz.
            ps.executeUpdate();
            ps.close();
            baglantiKapa();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Veritabanından öğrenci silmeye yarayan ogrenciSil metodu
    public boolean ogrenciSil(int ogrenciNo){

        try {
            Connection baglanti=baglantiAc();
            String sorgu="delete from APP.ogrenci where ogrno=?";
            //ogrenci tablosundan ogrno'ya göre veri silen sql sorgumuz
            PreparedStatement ps=baglanti.prepareStatement(sorgu);
            ps.setInt(1, ogrenciNo);
            //Parametre olarak ogrenciSil metoduna gönderilen ogrenciNo'yu kullanıyoruz.
            ps.executeUpdate();
            ps.close();
            baglantiKapa();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Veritabanındaki ogrenci verilerini güncellemeye yarayan ogrenciGuncelle metodu
    public boolean ogrenciGuncelle(Ogrenci ogrenci){
        try {
            Connection baglanti=baglantiAc();
            String sorgu="update APP.ogrenci set isim=?,soyisim=?,dyeri=? where ogrno=?";
            //ogrenci tablosundaki verileri güncellemeye yarayan sql sorgusu. ogrno'ya göre güncelleme yapıyor.
            PreparedStatement ps=baglanti.prepareStatement(sorgu);
            ps.setString(1, ogrenci.getIsim());
            ps.setString(2, ogrenci.getSoyIsim());
            ps.setString(3, ogrenci.getdYeri());
            ps.setInt(4, ogrenci.getOgrNo());
            //Parametreleri ogrenciGuncelle metodumuza gönderilmiş olan ogrenci nesnesinden alıyoruz.
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
