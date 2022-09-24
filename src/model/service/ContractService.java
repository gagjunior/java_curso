package model.service;

import model.entities.Contract;
import model.entities.InstallMent;

import java.time.LocalDate;

public class ContractService {
    private final int months;
    private final OnlinePaymentService onlinePaymentService;

    public ContractService(int months, OnlinePaymentService onlinePaymentService) {
        this.months = months;
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract){
        double amount = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++){
            double interest = onlinePaymentService.interest(amount, i);
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double paymentFee = onlinePaymentService.paymentFee(interest);
            contract.addInstallMents(new InstallMent(dueDate, paymentFee));
        }
    }
}
