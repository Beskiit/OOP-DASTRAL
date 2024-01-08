package package1;
import java.util.*;

public class PatientName {
    Scanner scan = new Scanner(System.in);

    String patientID, patientName, patientAddress, patientGender, patientIllness;
    int age, patientFees;

    void patient() {
    	
    	System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                     		  PATIENT SECTION");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.print("Patient ID: ");
        patientID = scan.nextLine();

        System.out.print("Patient Name: ");
        patientName = scan.nextLine();

        System.out.print("Address: ");
        patientAddress = scan.nextLine();

        System.out.print("Age: ");
        age = scan.nextInt();
        scan.nextLine(); 

        System.out.print("Gender: "); 
        patientGender = scan.nextLine();

        System.out.print("Illness: ");
        patientIllness = scan.nextLine();

        System.out.print("Fees: ");
        patientFees = scan.nextInt();
    }

    void patientInfo() {
        System.out.println(patientID + "       \t" + patientName + "        \t" + patientAddress + "       \t" +
                age + "     \t" + patientGender + "\t  " + patientIllness + "\t    " + patientFees);
    }

    public static void main(String[] args) {
        PatientName patient = new PatientName();
        
        patient.patient();       
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Patient ID\tPatient Name   \tAddress   \tAge   \tGender    Illness    Fees");
        System.out.println("------------------------------------------------------------------------------------------");
        patient.patientInfo();
    }
}


