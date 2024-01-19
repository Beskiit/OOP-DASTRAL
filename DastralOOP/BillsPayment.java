package DastralOOP;

import java.util.Map;
import java.util.Scanner;

public class BillsPayment extends Admin{
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
    	    		viewBills();
    	    		break;
    	    	case 2:
    	    		computeBill();
    	    		break;
    	    	case 3:
    	    		makePayment();
    	    		break;
    	    	case 4:
    	    		cont = false;
        	}
    	}
    }
    
    public static void makePayment() {
    	DefaultBill db = new DefaultBill();
    	sc.nextLine();
        System.out.print("Enter the patient ID for whom you want to make a payment: ");
        String patientID = sc.nextLine();

        if (NurseAccount.patientInfo.containsKey(patientID)) {

            System.out.print("Enter the payment amount: $");
            double paymentAmount = sc.nextDouble();
            
            if (paymentAmount > 0 && paymentAmount <= db.getTotalBalance()) {
            	
                db.setTotalBalance(db.getTotalBalance() - paymentAmount);

                System.out.println("Payment of $" + paymentAmount + " made successfully.");
                System.out.println("Remaining Balance for Patient " + patientID + ": PHP" + db.getTotalBalance());
            } else {
                System.err.println("Invalid payment amount. Please enter a valid amount.");
            }
        } else {
            System.err.println("Patient ID not found. Please try again.");
        }
    }
    
    public static void viewBills() {
    	for(Map.Entry<String, Double> entry : NurseAccount.patientBalance.entrySet()) {
    		String key = entry.getKey();
    		double value = entry.getValue();
    		
    		System.out.println("Patient ID: " + key);
    		System.out.println("Patient Balance: PHP" + value);
    	}
    }
    
    public static void computeBill() {
    	DefaultBill db = new DefaultBill();
    	double totalBalance = 0.0;
    	sc.nextLine();
    	System.out.print("Enter the patient ID you want to add bill: ");
    	String patientID = sc.nextLine();
    	if(NurseAccount.patientInfo.containsKey(patientID)) {
	    	while(true) {
	    		sc.nextLine();
		    	System.out.println("\t \t \t \t \t \t \t Enter the expenses of the patient (type 'done' when you are done): ");
		    	System.out.println("\t \t \t \t \t \t \t [1] Laboratory");
		    	System.out.println("\t \t \t \t \t \t \t [2] Medication");
		    	System.out.println("\t \t \t \t \t \t \t [3] Room");
		    	System.out.println("\t \t \t \t \t \t \t [4] Diagnosis");
		    	System.out.println("\t \t \t \t \t \t \t [5] Surgery");
		    	System.out.println("\t \t \t \t \t \t \t [6] Back");
		    	String expenses = sc.nextLine();
		    	if(expenses.equalsIgnoreCase("done")) {
		    		db.setTotalBalance(totalBalance);
		    		System.out.println("\t \t \t \t \t \t \t Bill added successfully.");
		            System.out.println("\t \t \t \t \t \t \t Total Balance for Patient " + patientID + ": PHP" + db.getTotalBalance());
		            NurseAccount.patientBalance.put(patientID, db.getTotalBalance());
		    		break;
		    	}
		    	
		    	int expense = Integer.parseInt(expenses);
		    	
		    	if(expense == 1) {
		    		totalBalance += db.getLaboratory();
		    	}else if(expense == 2) {
		    		totalBalance += db.getMedications();
		    	}else if(expense == 3) {
		    		totalBalance += db.getRoom();
		    	}else if(expense == 4) {
		    		totalBalance += db.getDiagnosis();
		    	}else if(expense == 5) {
		    		totalBalance += db.getSurgery();
		    	}else if(expense == 6) {
		    		billOption();
		    		break;
		    	}else {
		    		System.err.println("Input is incorrect. Please try again.");
		    	}
	    	}
    	}else {
    		System.err.println("Patient ID not found. Please try again.");
    	}
    }
}

class DefaultBill{
	private double laboratory = 1000.0;
	private double medications = 500.0;
	private double room = 400.0;
	private double diagnosis = 1500.0;
	private double surgery = 5000.0;
	private double balance = 0.0;
	
	public double getTotalBalance() {
		return balance;
	}
	
	public void setTotalBalance(double balance) {
		this.balance = balance;
	}
	
	public double getLaboratory() {
		return laboratory;
	}
	
	public double getMedications() {
		return medications;
	}
	
	public double getRoom() {
		return room;
	}
	
	public double getDiagnosis() {
		return diagnosis;
	}
	
	public double getSurgery() {
		return surgery;
	}
}
