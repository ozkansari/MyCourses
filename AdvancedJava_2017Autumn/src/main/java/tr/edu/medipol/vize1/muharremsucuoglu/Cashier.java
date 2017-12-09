package tr.edu.medipol.vize1.muharremsucuoglu;

// import payment.Payment;
//import payment.PaymentEnum;

public class Cashier extends Calisan implements Payment {

    private final int workedDay = 6;
    private final int weekOfMonth = 4;
    private final int cashierEarning = PaymentEnum.Cashier.getEarning();

    @Override
    public int getEarning() {
        return workedDay * (cashierEarning / 7) * weekOfMonth;
    }
}
