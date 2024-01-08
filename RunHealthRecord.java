package package1;
import java.util.*;

public class RunHealthRecord {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                             PATIENT HEALTH RECORD");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();

        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter patient gender: ");
        String gender = scanner.nextLine();

        HealthRecord patientRecord = new HealthRecord(patientName, age, gender);

        System.out.print("Enter allergies: ");
        patientRecord.setAllergies(scanner.nextLine());

        System.out.print("Enter medications: ");
        patientRecord.setMedications(scanner.nextLine());

        System.out.print("Enter medical history: ");
        patientRecord.setMedicalHistory(scanner.nextLine());

        
        patientRecord.displayHealthRecord();

    }
}
