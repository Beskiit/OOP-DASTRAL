package DastralOOP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NurseAccount extends Admin{
	static int key = 1;
	static int editValue;
	static Map <String, List<String>> patientInfo = new TreeMap<>();
	static Map<String, Doctor> doctorMap = new TreeMap<>();
	
	public static void viewPatient() {
		over.viewPatientRecord();
        if (patientInfo.isEmpty()) {
            System.out.println("\t \t \t \t \t \t \t No patient yet.");
        }else{
            printPatient(patientInfo);
        }
	}
	
	public static void patientAdministration() {
		over.addPatientRecord();
        String patientKey = "PT - " + key;
        List<String> patientInformation = new ArrayList<>();
        
        sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the name of patient: ");
        patientInformation.add("Patient Name: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the age of patient: ");
        patientInformation.add("Patient Age: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the gender of patient: ");
        patientInformation.add("Patient Gender: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the address of patient: ");
        patientInformation.add("Patient Address: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the room of patient: ");
        patientInformation.add("Patient Room: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the illness of patient: ");
        patientInformation.add("Patient Illness: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the doctor of patient: ");
        patientInformation.add("Patient Doctor: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the status of patient: ");
        patientInformation.add("Patient Status: " + sc.nextLine());

        patientInfo.put(patientKey, patientInformation);

        key++;
        System.out.println("\t \t \t \t \t \t \t Patient input done!");
	}
	
	public static void editPatient() {
		editInfo(patientInfo);
	}
	
	public static void editInfo(Map<String, List<String>> map) {
		List <String> myList = new ArrayList<>();
		for(List<String> list : map.values()) {
			myList.addAll(list);
		}
		System.out.println(myList);
		sc.nextLine();
		System.out.print("Enter the ID of the patient you want to edit: ");
		String editPatientID = sc.nextLine();
		
		if(patientInfo.containsKey(editPatientID)) {
			System.out.print("Enter the information of the patient you want to edit: ");
			String editPatientInfo = sc.nextLine();
			
			if(editPatientInfo.equalsIgnoreCase("name")) {
				editValue = 0;
				System.out.print("Enter your new information: ");
				myList.set(editValue,"Patient Name: " + sc.nextLine());
				map.put(editPatientID, myList);
			}else if(editPatientInfo.equalsIgnoreCase("age")) {
				editValue = 1;
				System.out.print("Enter your new information: ");
				myList.set(editValue,"Patient Age: " + sc.nextLine());
				map.put(editPatientID, myList);
			}else if(editPatientInfo.equalsIgnoreCase("gender")) {
				editValue = 2;
				System.out.print("Enter your new information: ");
				myList.set(editValue,"Patient Gender: " + sc.nextLine());
				map.put(editPatientID, myList);
			}else if(editPatientInfo.equalsIgnoreCase("address")) {
				editValue = 3;
				System.out.print("Enter your new information: ");
				myList.set(editValue,"Patient Address: " + sc.nextLine());
				map.put(editPatientID, myList);
			}else if(editPatientInfo.equalsIgnoreCase("room")) {
				editValue = 4;
				System.out.print("Enter your new information: ");
				myList.set(editValue,"Patient Room: " + sc.nextLine());
				map.put(editPatientID, myList);
			}else if(editPatientInfo.equalsIgnoreCase("illness")) {
				editValue = 5;
				System.out.print("Enter your new information: ");
				myList.set(editValue,"Patient Illness: " + sc.nextLine());
				map.put(editPatientID, myList);
			}else if(editPatientInfo.equalsIgnoreCase("doctor")) {
				editValue = 6;
				System.out.print("Enter your new information: ");
				myList.set(editValue,"Patient Doctor: " + sc.nextLine());
				map.put(editPatientID, myList);
			}else if(editPatientInfo.equalsIgnoreCase("status")) {
				editValue = 7;
				System.out.print("Enter your new information: ");
				myList.set(editValue,"Patient Status: " + sc.nextLine());
				map.put(editPatientID, myList);
			}else {
				System.err.println("The information you entered is not present. Please try again.");
			}
		}
	}
	
	public static void doctorSchedule() {
		doctorMap.put("DOC-1", new Doctor("Dr. Smith", "Cardiology", "Monday, Wednesday, Friday"));
        doctorMap.put("DOC-2", new Doctor("Dr. Johnson", "Orthopedics", "Tuesday, Thursday"));
        doctorMap.put("DOC-3", new Doctor("Dr. Davis", "Pediatrics", "Monday, Friday"));
        doctorMap.put("DOC-4", new Doctor("Dr. Williams", "Dermatology", "Wednesday, Thursday"));
        doctorMap.put("DOC-5", new Doctor("Dr. Brown", "Internal Medicine", "Monday, Tuesday, Thursday"));
        
        
	}
	
	public static void doctorEditSchedule() {
		
	}
	
	public static void accountSettings() {
		
	}
	
	public static void printPatient(Map <String, List<String>> map) {
		System.out.println("\t \t \t \t \t \t \t Current Patient/s: " + (key-1));
		over.line();
		for(Map.Entry<String, List<String>> key : map.entrySet()) {
			List<String> values = key.getValue();
			System.out.println("\t \t \t \t \t \t \t Patient ID: " + key.getKey());
			for(String value : values) {
				System.out.println("\t \t \t \t \t \t \t " + value);
			}
		}
	}
}
