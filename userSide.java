package DastralOOP;

import java.util.Iterator;
import java.util.LinkedList;

public class userSide extends Admin{
	LinkedList patientInfo = new LinkedList();
	public int key = 1;
	public String patientName, patientGender, patientAddress, patientIllness, patientDoctor, patientStatus, patientRoom, patientAge;
	public void patientInfoFinal() {
		patientInfo.add("Patient ID: " + key);
		sc.nextLine();
		System.out.println("Enter the name of patient: ");
		patientInfo.add("Patient Name: " + sc.nextLine());
		System.out.println("Enter the age of patient: ");
		patientInfo.add("Patient Age: " + sc.nextLine());
		System.out.println("Enter the gender of patient: ");
		patientInfo.add("Patient Gender: " + sc.nextLine());
		System.out.println("Enter the address of patient: ");
		patientInfo.add("Patient Address: " + sc.nextLine());
		System.out.println("Enter the room of patient: ");
		patientInfo.add("Patient Room: " + sc.nextLine());
		System.out.println("Enter the illness of patient: ");
		patientInfo.add("Patient Illness: " + sc.nextLine());
		System.out.println("Enter the doctor of patient: ");
		patientInfo.add("Patient Doctor: " + sc.nextLine());
		System.out.println("Enter the status of patient: ");
		patientInfo.add("Patient Status: " + sc.nextLine());
		key++;
		System.out.println("Patient input done!");
		over.line();
	}
	
	public void healthRecord() {
		if(patientInfo.isEmpty()) {
			System.out.println("No patient yet.");
			over.line();
		}else {
			Iterator it = patientInfo.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			over.line();
		}
	}
}
