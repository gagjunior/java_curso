package model.service;

public interface OnlinePaymentService {
    double paymentFee(double interest);
    double interest(double amount, int month);
}
