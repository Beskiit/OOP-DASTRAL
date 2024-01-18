package DastralOOP;

import java.util.Map;
import java.util.Scanner;

public class BillsPayment extends UserSide {
    static Scanner sc = new Scanner(System.in);

    public static void manageBills() {
        boolean continueProcessing = true;

        while (continueProcessing) {
            over.billOptionName();
            System.out.println("\t \t \t \t \t \t \t [1] View patient bills");
            System.out.println("\t \t \t \t \t \t \t [2] Add bill");
            System.out.println("\t \t \t \t \t \t \t [3] Make a payment");
            System.out.println("\t \t \t \t \t \t \t [4] View detailed bill");
            System.out.println("\t \t \t \t \t \t \t [5] Back");
            System.out.print("\t \t \t \t \t \t \t Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewPatientBills(UserSide.patientBalances);
                    break;
                case 2:
                    addBillToPatient(UserSide.patientBalances);
                    break;
                case 3:
                    makePaymentToPatient(UserSide.patientBalances);
                    break;
                case 4:
                    viewDetailedBill(UserSide.patientBalances);
                    break;
                case 5:
                    continueProcessing = false;
                    break;
            }
        }
    }

    public static void addBillToPatient(Map<String, Double> patientBalances) {
        over.addPatientBills();
        sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the patient ID to add a bill: ");
        String patientID = sc.nextLine();

        if (patientBalances.containsKey(patientID)) {
            double defaultPrice = 50.0;

            System.out.println("\t \t \t \t \t \t \t Default price for the service: $" + defaultPrice);
            System.out.print("\t \t \t \t \t \t \t Use the default price? (y/n): ");
            String useDefault = sc.nextLine();

            double billAmount = (useDefault.equalsIgnoreCase("y")) ? defaultPrice : getCustomAmount();

            double currentBalance = patientBalances.get(patientID);
            double updatedBalance = currentBalance + billAmount;

            patientBalances.put(patientID, updatedBalance);

            System.out.println("\t \t \t \t \t \t \t Bill added successfully. Updated balance for patient " + patientID + ": $" + updatedBalance);
        } else {
            System.out.println("\t \t \t \t \t \t \t Patient ID not found. Please enter a valid ID.");
        }
        over.line();
    }

    private static double getCustomAmount() {
        System.out.print("\t \t \t \t \t \t \t Enter the custom bill amount: ");
        return sc.nextDouble();
    }

    public static void makePaymentToPatient(Map<String, Double> patientBalances) {
        over.paymentBills();
        sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the patient ID to make a payment: ");
        String patientID = sc.nextLine();

        if (patientBalances.containsKey(patientID)) {
            double currentBalance = patientBalances.get(patientID);

            if (currentBalance > 0) {
                System.out.println("\t \t \t \t \t \t \t Current Outstanding Balance for patient " + patientID + ": $" + currentBalance);
                System.out.print("\t \t \t \t \t \t \t Enter the payment amount: ");
                double paymentAmount = sc.nextDouble();

                if (isValidPayment(paymentAmount, currentBalance)) {
                    processPaymentToPatient(patientBalances, patientID, currentBalance, paymentAmount);
                } else {
                    System.out.println("\t \t \t \t \t \t \t Invalid payment amount. Please enter a valid amount.");
                }
            } else {
                System.out.println("\t \t \t \t \t \t \t No outstanding balance for patient " + patientID + ".");
            }
        } else {
            System.out.println("\t \t \t \t \t \t \t Patient ID not found. Please enter a valid ID.");
        }
        over.line();
    }

    private static boolean isValidPayment(double paymentAmount, double currentBalance) {
        return paymentAmount > 0 && paymentAmount <= currentBalance;
    }

    private static void processPaymentToPatient(Map<String, Double> patientBalances, String patientID, double currentBalance, double paymentAmount) {
        double updatedBalance = currentBalance - paymentAmount;
        patientBalances.put(patientID, updatedBalance);
        System.out.println("\t \t \t \t \t \t \t Payment made successfully. Updated balance for patient " + patientID + ": $" + updatedBalance);
    }

    private static void viewDetailedBill(Map<String, Double> patientBalances) {
        over.viewDetailedBill();
        sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the patient ID to view detailed bill: ");
        String patientID = sc.nextLine();

        if (patientBalances.containsKey(patientID)) {
            double currentBalance = patientBalances.get(patientID);
            System.out.println("\t \t \t \t \t \t \t Current Outstanding Balance for patient " + patientID + ": $" + currentBalance);
        } else {
            System.out.println("\t \t \t \t \t \t \t Patient ID not found. Please enter a valid ID.");
        }
        over.line();
    }
}
