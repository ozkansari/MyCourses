package tr.edu.medipol.vize1.muharremsucuoglu;

public enum PaymentEnum {

    Stajyer(1400),
    Cashier(2500),
    Salesman(2500),
    Manager(5500);

    private int earning;

    PaymentEnum(int earning) {

        this.earning = earning;
    }

    public int getEarning() {
        return earning;
    }
}
