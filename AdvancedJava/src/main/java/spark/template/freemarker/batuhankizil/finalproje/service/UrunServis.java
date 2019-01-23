package spark.template.freemarker.batuhankizil.finalproje.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spark.template.freemarker.batuhankizil.finalproje.VeritabaniYonetimi;
import spark.template.freemarker.batuhankizil.finalproje.model.Urun;

public class UrunServis {

   
	public boolean urunEkle(Urun urun){
        String selectSql = "select count(*)  from urunler where urun_adi = ?";
        ResultSet rs = null;
        int urunSay = 0;
        try {
            PreparedStatement rstmt = VeritabaniYonetimi.getVeriTabaniBaglanitisi().prepareStatement(selectSql);
            rstmt.setString(1,urun.getUrun_adi());
            rs = rstmt.executeQuery();
            while (rs.next()){
                urunSay = rs.getInt(1);
            }
            rstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (urunSay > 0) {
            System.out.println("Hata bu isimde urun var");
            return false;
        }else{
            try {
                int urunIdNums = 0;
                String countSql = "select count(*)  from urunler";
                try {
                    PreparedStatement pstmt = VeritabaniYonetimi.getVeriTabaniBaglanitisi().prepareStatement(countSql);
                    rs = pstmt.executeQuery();
                    while (rs.next()){
                        urunIdNums = rs.getInt(1);
                    }
                    pstmt.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                int id = urunIdNums + 1;
                String insertSql = "insert into urunler(urun_id,urun_adi,urun_kategori,fiyat) " +
                        "values("+id +" , '" + urun.getUrun_adi() + "', '" + urun.getUrun_kategori() + "'," + urun.getFiyat() +"  )";
                Statement stmt = VeritabaniYonetimi.getVeriTabaniBaglanitisi().createStatement();
                int updatedRowCount = stmt.executeUpdate(insertSql);
                if (updatedRowCount > 0){
                    return true;
                }else {
                    System.out.println("Kaydedilemedi");
                }
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    public void urunSil(int Urun_id){}

    public List<Urun> urunListele(){
        List<Urun> urunler = new ArrayList<Urun>();
        String selectSql = "select urun_id,urun_adi,urun_kategori,fiyat  from urunler";
        ResultSet rs = null;
        try {
            PreparedStatement stmt = VeritabaniYonetimi.getVeriTabaniBaglanitisi().prepareStatement(selectSql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Urun urun = new Urun();
                urun.setUrun_id(rs.getInt("urun_id"));
                urun.setUrun_adi(rs.getString("urun_adi"));
                urun.setUrun_kategori(rs.getString("urun_kategori"));
                urun.setFiyat(rs.getDouble("fiyat"));
                urunler.add(urun);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urunler;
    }


	public Urun urunGetir(int urunId) {
		
	        String selectSql = "select urun_id,urun_adi,urun_kategori,fiyat from urunler where urun_id = ? ";
	        ResultSet rs = null;
	        try {
	            PreparedStatement stmt = VeritabaniYonetimi.getVeriTabaniBaglanitisi().prepareStatement(selectSql);
	            stmt.setInt(1,urunId);
	            rs = stmt.executeQuery();
	            Urun urun = new Urun();
	            while (rs.next()){
	                urun.setUrun_id(rs.getInt("urun_id"));
	                urun.setUrun_adi(rs.getString("urun_adi"));
	                urun.setUrun_kategori(rs.getString("urun_kategori"));
	                urun.setFiyat(rs.getDouble("fiyat"));
	            }
	            stmt.close();
	            rs.close();
	            return urun;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}

}
