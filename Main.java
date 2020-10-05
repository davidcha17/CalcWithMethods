package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, let's calculate your mortgage.");

        int principal = (int) readNumbers("principal: ", 1000, 1_000_000);
        float monthlyInterest = (float) readNumbers("annual interest: ", 1, 30);
        byte years = (byte) readNumbers("years: ", 1 ,30);

        double mortgage = calculateMortgage(principal, monthlyInterest, years);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + formattedMortgage);
        /*
        In our main method, we are cut down the amount of repetitive code. The previous method contained 3 while
        methods and we created a method that utilizes the same structure while loops. (not always the case)
        We are calling on a method that is doing all the calculation for our mortgage calculator and it requires
        the inputs from the earlier method of readNumbers.
        We associate the method to a double variable in order for us to string the value of our mortgage value
        */
    }

    public static double readNumbers(String prompt, double min, double max) {
        /*
        This method just takes in the user inputs and see whether they are acceptable for our mortgage calculator.
        The 3 parameter is takes in are the prompt (principal, years, and annual rate), the minimum, and the maximum
        When we call it on the main method, we will input the min and max to make sure that the prompt we are making
        is appropriate.
        */
        Scanner scanner = new Scanner(System.in);
        double value;
//        since it is ambiguous we are naming the prompt value as value
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max)
                break;
            else
                System.out.println("Please enter a value between " + min + " and " + max);
        }
        return value;
        /*
        Until the loops becomes false or breaks we will check to see if the value is greater than the min or greater
        than the max. If it passes the condition we will break it and keep going on the main method, else we will
        ask the user to enter a value between the min and max provided by the method call on the main method.
        */
    }

    public static double calculateMortgage(
            int principal,
            float monthlyInterest,
            byte years) {
//  Keeping the syntax consistent and have the 3 parameters as such.

//        System.out.println(principal + " principal");

        final byte monthInYears = 12;
        final byte percent = 100;
//      variable declaration for scoping purposes

        short num_Of_Payments = (short)(years * monthInYears);
        float actualRate = (monthlyInterest / percent) / monthInYears;

        float ratePlusOne = (float) (Math.pow((1 + actualRate), num_Of_Payments));
        double mortgage = (principal * ((actualRate * ratePlusOne) / (ratePlusOne - 1)));

//        double mortgage = principal
//                * (actualRate * Math.pow(1 + actualRate, num_Of_Payments)
//                / (Math.pow(1 + actualRate, num_Of_Payments) - 1));

//        System.out.println("ratePlusOne is: " + ratePlusOne);
//        System.out.println("monthly interest " + monthlyInterest);
//        System.out.println("actual Rate: " + actualRate);
//        System.out.println("months in years " + num_Of_Payments);

        return mortgage;
        /*
        In this method we are just calculating the inputs from the earlier methods. We were able to organize our
        code much better.
        */
    }
}

// Down here was the previous code I made before with just one method.
//
//public class Main {
//
//    public static void main(String[] args) {
//        System.out.println("Let's calculate your mortgage payments");
//
//        int principal = 0;
//        int years = 0;
//        float actualRate = 0;
//        int monthly = 0;
//
//        Scanner scanner = new Scanner(System.in);
//
//        while(true) {
//            System.out.print("Principal: ");
//            principal = scanner.nextInt();
//            if(principal >= 1_000 && principal <= 1_000_000)
//                break;
//            else
//                System.out.println("Please print a number between 1,000 and 1,000,000.");
//        }
//
//        while (true) {
//            System.out.print("Annual Interest Rate: ");
//            float rate = scanner.nextFloat();
//            if(rate > 0 && rate <= 30) {
//                actualRate = (rate / 100) / 12;
//                System.out.println("Annual Rate: " + actualRate);
//                break;
//            }
//            else
//                System.out.println("Please enter an annual interest rate between 0 and 30.");
//        }
//
//
//
//        while(true) {
//            System.out.print("Period (years): ");
//            int year = scanner.nextInt();
//            if(year >= 1 && year <= 30) {
//                monthly = year * 12;
//                System.out.println("months: " + monthly);
//                break;
//            }
//            else
//                System.out.println("Please enter a year between 1 and 30.");
//        }
//
//        float ratePlusOne = (float) (Math.pow((1 + actualRate), monthly));
////        System.out.println("ratePlusOne is: " + ratePlusOne);
//
//        float mortgage = (principal * ((actualRate * ratePlusOne) / (ratePlusOne - 1)));
//
//        String currency = NumberFormat.getCurrencyInstance().format(mortgage);
//
//        System.out.println("Mortgage: " + currency);
////        refactored(principal, rate, year);
//    }
//
//    private static void refactored(long principal, float rate, int year) {
////        this is the refactored code for mortgage rate
//        final byte PERCENT = 100;
//        final byte MONTHS_IN_YEAR = 12;
//
//        float rate2 = rate / PERCENT / MONTHS_IN_YEAR;
//        int monthly = year * MONTHS_IN_YEAR;
//
//        double mortgage2 = principal
//                * (rate2 * Math.pow(1 + rate2, monthly)
//                / (Math.pow(1 + rate2, monthly) - 1 ));
//
//        String totalPayment = NumberFormat.getCurrencyInstance().format(mortgage2);
//
//        System.out.println("refactored part: ");
//        System.out.println(totalPayment);
//    }
//    /*
//    From all this, the concepts utilized for this basic practice were reference types, casting (implicit and explicit)
//    primitive types, reading inputs, variables and CONSTANTS, and strings, numbers, and arrays. We need conditional
//    statements to make this flow better without hitting the EXCEPTION ERROR.
//    */
//
//}
