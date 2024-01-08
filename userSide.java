package DastralOOP;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class userSide extends Admin{
	LinkedList patientInformation = new LinkedList();
	private int key = 1;
	private String patientName, patientGender, patientAddress, patientIllness, patientDoctor, patientStatus, patientRoom, patientAge;
	public void patientInfoInput(String patientName, String patientAge, String patientGender, String patientAddress, String patientRoom, String patientIllness, String patientDoctor, String patientStatus) {
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientGender = patientGender;
		this.patientAddress = patientAddress;
		this.patientRoom = patientRoom;
		this.patientIllness = patientIllness;
		this.patientDoctor = patientDoctor;
		this.patientStatus = patientStatus;
		patientInformation.add("Patient ID: " + key);
		patientInformation.add("Patient Name: " + patientName);
		patientInformation.add("Patient Age: " + patientAge);
		patientInformation.add("Patient Gender: " + patientGender);
		patientInformation.add("Patient Address: " + patientAddress);
		patientInformation.add("Patient Room: " + patientRoom);
		patientInformation.add("Patient Illness: " + patientIllness);
		patientInformation.add("Patient Doctor: " + patientDoctor);
		patientInformation.add("Patient Status: " + patientStatus + "\n");
		key++;
	}
	
	public void patientInfoFinal() {
		System.out.print("Enter the name of patient: ");
		patientName = sc.next();
		System.out.print("Enter the age of patient: ");
		patientAge = sc.next();
		System.out.print("Enter the gender of patient: ");
		patientGender = sc.next();
		System.out.print("Enter the address of patient: ");
		patientAddress = sc.next();
		System.out.print("Enter the room of patient: ");
		patientRoom = sc.next();
		System.out.print("Enter the illness of patient: ");
		patientIllness = sc.next();
		System.out.print("Enter the doctor of patient: ");
		patientDoctor = sc.next();
		System.out.print("Enter the status of patient: ");
		patientStatus = sc.next();
		patientInfoInput(patientName, patientAge, patientGender, patientAddress, patientRoom, patientIllness, patientDoctor, patientStatus);
		System.out.println("Patient input done!");
		over.line();
	}
	
	public void healthRecord() {
		if(patientInformation.isEmpty()) {
			System.out.println("No patient yet.");
			over.line();
		}else {
			Iterator it = patientInformation.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			over.line();
		}
	}
}