
package com.mortgageCalculator;

        import java.text.NumberFormat;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // mortgage calculator

        //define variables and call methods
        int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        double annualRate = (float) readNumber("Annual Interest Rate: ", 1, 30);
        int period = (int) readNumber("Period in Years: ", 1, 30);

        double monthlyMortgage = calculateMortgage(principal, annualRate, period);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(monthlyMortgage);
        System.out.println("Your Monthly Mortgage Rate is: " + mortgageFormatted);

    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.print("Please enter a value between " + min + " and " + max);
        }
        return value;
    }


    public static double calculateMortgage(int principal, double annualRate, int period) {
        // M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]

        int PERCENT = 100;
        int YEAR = 12;

        double monthlyRate = annualRate / PERCENT / YEAR;
        int totalNumPayments = period * YEAR;
        double monthlyMortgage;

        monthlyMortgage = principal * (monthlyRate * Math.pow(1 + monthlyRate, totalNumPayments)) /
                (Math.pow(1 + monthlyRate, totalNumPayments) - 1);


        return monthlyMortgage;


    }


}






