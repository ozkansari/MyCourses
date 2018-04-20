package tr.edu.medipol.vizeproje.alican_celik;
public class Yayinevi {
    private int id;
    private String yayineviadi;
    private String email;


    public Yayinevi() {
    }

    public Yayinevi(int id, String yayineviadi, String email) {
        this.id = id;
        this.yayineviadi = yayineviadi;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYayineviadi() {
        return yayineviadi;
    }

    public void setYayineviadi(String yayineviadi) {
        this.yayineviadi = yayineviadi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
