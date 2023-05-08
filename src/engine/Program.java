package engine;

import entities.Contracts;
import entities.Installment;
import services.ContractService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.println("-----PILILIU CORP LTDA-------");
        System.out.print("Contract Number:  ");
        int contract = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(),fmt);

        System.out.print("Enter the value of the contract:  ");
        double totalValue = sc.nextDouble();

        Contracts obj = new Contracts(contract, date, totalValue);

        System.out.print("Enter the number of months: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(null);

        contractService.processContract(obj, n);

        System.out.print("Parcelas:  ");
        for (Installment installment : obj.getInstallments()){
            System.out.println(installment);

        }




        sc.close();
    }
}
