package DastralOOP;

import java.util.Map;
import java.util.Scanner;

public class BillsPayment extends UserSide{
    static Scanner sc = new Scanner(System.in);
    
    public static void billOption() {
    	boolean cont = true;
    	while(cont) {
    		over.billOptionName();
    		System.out.println("\t \t \t \t \t \t \t [1] View patient bills");
        	System.out.println("\t \t \t \t \t \t \t [2] Add bill");
        	System.out.println("\t \t \t \t \t \t \t [3] Make a payment");
        	System.out.println("\t \t \t \t \t \t \t [4] Back");
        	System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
        	
        	int choice = sc.nextInt();
        	
        	switch(choice) {
    	    	case 1:
    	    		viewPatientBills(UserSide.patientBalances);
    	    		break;
    	    	case 2:
    	    		addBill(UserSide.patientBalances);
    	    		break;
    	    	case 3:
    	    		makePayment(UserSide.patientBalances);
    	    		break;
    	    	case 4:
    	    		cont = false;
        	}
    	}
    }

    public static void addBill(Map<String, Double> patientBalances) {
    	over.addPatientBills();
    	sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the patient ID to add a bill: ");
        String patientID = sc.nextLine();

        if (patientBalances.containsKey(patientID)) {
            System.out.print("\t \t \t \t \t \t \t Enter the bill amount: ");
            double billAmount = sc.nextDouble();

            double currentBalance = patientBalances.get(patientID);
            double updatedBalance = currentBalance + billAmount;

            patientBalances.put(patientID, updatedBalance);

            System.out.println("\t \t \t \t \t \t \t Bill added successfully. Updated balance for patient " + patientID + ": " + updatedBalance);
        } else {
            System.out.println("\t \t \t \t \t \t \t Patient ID not found. Please enter a valid ID.");
        }
        over.line();
    }

    public static void makePayment(Map<String, Double> patientBalances) {
    	over.paymentBills();
    	sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the patient ID to make a payment: ");
        String patientID = sc.nextLine();

        if (patientBalances.containsKey(patientID)) {
            double currentBalance = patientBalances.get(patientID);

            if (currentBalance > 0) {
                System.out.print("\t \t \t \t \t \t \t Enter the payment amount: ");
                double paymentAmount = sc.nextDouble();

                double updatedBalance = currentBalance - paymentAmount;

                patientBalances.put(patientID, updatedBalance);

                System.out.println("\t \t \t \t \t \t \t Payment made successfully. Updated balance for patient " + patientID + ": " + updatedBalance);
            } else {
                System.out.println("\t \t \t \t \t \t \t No outstanding balance for patient " + patientID + ".");
            }
        } else {
            System.out.println("\t \t \t \t \t \t \t Patient ID not found. Please enter a valid ID.");
        }
        over.line();
    }

    public static void viewPatientBills(Map<String, Double> patientBalances) {
    	over.viewPatientBills();
        System.out.println("\t \t \t \t \t \t \t Patient Bills:");

        for (Map.Entry<String, Double> entry : patientBalances.entrySet()) {
            String patientID = entry.getKey();
            Double balance = entry.getValue();
            
            if(patientBalances.isEmpty()) {
            	System.out.println("\t \t \t \t \t \t \t No bills yet.");
            }
            
            if (balance > 0) {
                System.out.println("\t \t \t  \t \t \t \t Patient ID: " + patientID + ", Outstanding Balance: " + balance);
            }
        }
        over.line();
    }
}
