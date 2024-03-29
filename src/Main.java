import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MonthsInYear =12;
        final byte Percent = 100;
        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayment = 0;
        double mortgage;

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Principla($1k - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter A Value Between 1000 and 1000000");
        }

        while(true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / Percent / MonthsInYear;
                break;
            }
            System.out.print("Enter a value between 1 and 30");
        }
        while(true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <=30) {
                numberOfPayment = years * MonthsInYear;
                break;
            }
            System.out.print("Enter a value between 1 and 30");
        }

        mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment))
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println(STR."Mortgage: \{mortgageFormatted}");
    }
}