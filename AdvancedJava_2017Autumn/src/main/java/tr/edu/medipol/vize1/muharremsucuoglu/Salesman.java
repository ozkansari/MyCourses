package tr.edu.medipol.vize1.muharremsucuoglu;

// import payment.Payment;
//import payment.PaymentEnum;

public class Salesman extends Calisan implements Payment {

    private final int workedDay = 6;
    private final int weekOfMonth = 4;
    private final int salesmanEarning = PaymentEnum.Salesman.getEarning();

    @Override
    public int getEarning() {
        return workedDay * (salesmanEarning / 7) * weekOfMonth;
    }
}
