import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.InstallMent;
import model.service.ContractService;
import model.service.PayPalService;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data");

        System.out.print("Number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Date (DD/MM/YYYY): ");
        LocalDate date = LocalDate.parse(scanner.next(), fmt);

        System.out.print("Contract value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter number of installments: ");
        int months = scanner.nextInt();

        Contract contract = new Contract(number, date, value);
        ContractService contractService = new ContractService(months, new PayPalService());

        contractService.processContract(contract);

        System.out.println("\nInstallments:");
        for (InstallMent installMent : contract.getInstallMents()) {
            System.out.println(installMent);
        }

        scanner.close();
    }
}
