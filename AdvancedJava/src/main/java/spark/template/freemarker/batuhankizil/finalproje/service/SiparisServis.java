package spark.template.freemarker.batuhankizil.finalproje.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spark.template.freemarker.batuhankizil.finalproje.VeritabaniYonetimi;
import spark.template.freemarker.batuhankizil.finalproje.model.Kullanici;
import spark.template.freemarker.batuhankizil.finalproje.model.Siparis;
import spark.template.freemarker.batuhankizil.finalproje.model.Urun;

public class SiparisServis {

    public SiparisServis(){}

    public boolean siparisVer(String kullanici_adi, List<Urun> siparisler){
    	double tomplamFiyat = 0;
    	StringBuilder urunIdler = new StringBuilder();
    	for(Urun urun: siparisler) {
    		tomplamFiyat += urun.getFiyat();
    		urunIdler.append(urun.getUrun_id()).append(",");
    	}
    	
    	Siparis siparis = new Siparis(kullanici_adi,urunIdler.toString(),tomplamFiyat);
    	return siparisEkle(siparis);
    }

   public boolean siparisEkle(Siparis siparis) {
	        ResultSet rs = null;
	    
            try {
                int siparsiIdNums = 0;
                String countSql = "select count(*)  from siparisler";
                try {
                    PreparedStatement pstmt = VeritabaniYonetimi.getVeriTabaniBaglanitisi().prepareStatement(countSql);
                    rs = pstmt.executeQuery();
                    while (rs.next()){
                    	siparsiIdNums = rs.getInt(1);
                    }
                    pstmt.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                int id = siparsiIdNums + 1;
                String insertSql = "insert into siparisler(siparis_id,kullanici_adi,urun_idler,toplam_ucret) " +
                        "values("+id +" , '" + siparis.getKullanici_adi() + "', '" + siparis.getUrun_idler() + "'," + siparis.getToplam_ucret() +"  )";
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
	        

	        return false;
	    }
   
    
    
    public List<Siparis> siparisleriListele(){
        Connection conn = VeritabaniYonetimi.getVeriTabaniBaglanitisi();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Siparis> siparisler = new ArrayList<>();
        int count = 0;
        try {
            stmt = conn.prepareStatement("select * from siparisler ");
            rs = stmt.executeQuery();

            while (rs.next()){
                int siparis_id = rs.getInt("siparis_id");
                String kullanici_adi = rs.getString("kullanici_adi");
                String urunler = rs.getString("urun_idler");
                double toplamFiyat = rs.getDouble("toplam_ucret");
                Siparis siparis = new Siparis(siparis_id,kullanici_adi,urunler,toplamFiyat);       
                siparisler.add(siparis);
            }
            stmt.close();
            rs.close();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return siparisler;
    }
  
}
