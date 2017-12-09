package tr.edu.medipol.vize1.muharremsucuoglu;

// import payment.Payment;
//import payment.PaymentEnum;

public class Manager extends Calisan implements Payment {

    private final int workedDay = 5;
    private final int weekOfMonth = 4;
    private final int managerEarning = PaymentEnum.Manager.getEarning();

    @Override
    public int getEarning() {
        return workedDay * (managerEarning / 5) * weekOfMonth;
    }
}
