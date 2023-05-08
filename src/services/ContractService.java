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
        contracts.getInstallments().add(new Installment(LocalDate.of(2018,7,25), 206.04));
    }
}
