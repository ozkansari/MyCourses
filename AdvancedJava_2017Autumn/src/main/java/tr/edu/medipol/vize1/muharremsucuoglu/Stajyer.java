package tr.edu.medipol.vize1.muharremsucuoglu;

// import payment.Payment;
//import payment.PaymentEnum;

public class Stajyer extends Calisan implements Payment {

    private final int workedDay = 3;
    private final int weekOfMonth = 4;
    private final int stajyerEarning = PaymentEnum.Stajyer.getEarning();

    @Override
    public int getEarning() {
        return workedDay * (stajyerEarning / 5) * weekOfMonth;
    }
}
