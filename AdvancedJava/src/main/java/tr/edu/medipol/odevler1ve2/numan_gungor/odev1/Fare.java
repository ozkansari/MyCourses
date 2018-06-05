package tr.edu.medipol.odevler1ve2.numan_gungor.odev1;


import org.omg.CORBA.PUBLIC_MEMBER;

public class Fare extends Hayvan {


    public void Uyu(){
        System.out.println("uyuyorum");
    }

    @Override
    public void SesCikar(){
        System.out.println("Ses Cikarmiyorum");
    }
    @Override
    public void YemekYe(){
        System.out.println("yemek yemiyorum");
    }
}
