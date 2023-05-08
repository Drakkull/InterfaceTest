package services;

import entities.Contracts;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentServices onlinePaymentServices;

    public ContractService(OnlinePaymentServices onlinePaymentServices) {
        this.onlinePaymentServices = onlinePaymentServices;
    }

    public void processContract (Contracts contracts,int months){
       double basicQuota = contracts.getTotalValue() / months;

        for ( int i = 1; i<= months; i++){
           LocalDate dueDate = contracts.getDate().plusMonths(i);

           double interest = onlinePaymentServices.interest(basicQuota, i);

           double fee = onlinePaymentServices.paymentFee(basicQuota + interest);
           double quota = basicQuota + interest + fee;
           contracts.getInstallments().add(new Installment(dueDate, quota));

       }
    }
}
