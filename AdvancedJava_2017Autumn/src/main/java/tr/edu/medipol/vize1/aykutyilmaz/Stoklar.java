package tr.edu.medipol.vize1.aykutyilmaz;

public class Stoklar {

    private int ID;
    private String adi;
    private String tipi;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    @Override
    public String toString() {
        return "Stoklar{" +
                "ID='" + ID + '\'' +
                ", adi='" + adi + '\'' +
                ", tipi='" + tipi + '\'' +
                '}';
    }
}
