package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<TaxPayer>();

        System.out.println("Enter the number of taxpayer");
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            System.out.println("TaxPayer #" + i + "data");
            System.out.print("Individual or Company(i/c)");
            char type = scanner.next().charAt(0);
            System.out.println("name:");
            String name = scanner.next();
            System.out.println("anual income:");
            Double anualIncome = scanner.nextDouble();

            if (type == 'i') {
                System.out.print("Health Expenditures");
                Double healthExpenditures = scanner.nextDouble();
                Individual indiv = new Individual(name, anualIncome, healthExpenditures);
                list.add(indiv);

            } else {
                System.out.print("Number of employees:");
                Integer numberOfEmployees = scanner.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        //Aqui entra o polimorfismo
        System.out.println(); // p pular 1 linha
        System.out.println("Taxes paid:");

        for (TaxPayer tp : list) {
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));

        }
        System.out.println();
        double sum = 0.0;
        for (TaxPayer tp : list) {
            sum += tp.tax();
            System.out.println("Total taxes: $ " + String.format("%.2f", sum));

        }
        scanner.close();

    }
}