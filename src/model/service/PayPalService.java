package model.service;

public class PayPalService implements OnlinePaymentService{

    @Override
    public double paymentFee(double interest) {
        double tax = interest * 0.02;
        return tax + interest;
    }

    @Override
    public double interest(double amount, int month) {
        double tax = amount * 0.01;
        return tax * month + amount;
    }
}
