package DastralOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NurseAccount extends Admin{
	static int key = 1;
	static int docKey = 1;
	static int editValue;
	static Map <String, List> patientInfo = new TreeMap<>();
	static Map <String, Double> patientBalance = new TreeMap<>();
	static Scanner sc = new Scanner(System.in);
	static Admin admin = new Admin();
	
	public static void nurseOption() {
		boolean cont = true;
		while(cont) {
			System.out.println("\t \t \t \t \t \t \t [1] View patient record");
	    	System.out.println("\t \t \t \t \t \t \t [2] Input new patient record");
	    	System.out.println("\t \t \t \t \t \t \t [3] Edit patient record");
	    	System.out.println("\t \t \t \t \t \t \t [4] Doctor Schedule");
	    	System.out.println("\t \t \t \t \t \t \t [5] Edit Doctor Schedule");
	    	System.out.println("\t \t \t \t \t \t \t [6] Schedule appointment");
	    	System.out.println("\t \t \t \t \t \t \t [7] Bills and payments");
	    	System.out.println("\t \t \t \t \t \t \t [8] Account Settings");
	    	System.out.println("\t \t \t \t \t \t \t [9] Back");
	    	System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
	    	
	    	int choice = sc.nextInt();
	    	
	    	switch(choice) {
	    		case 1:
	    			viewPatient();
	    			break;
	    		case 2:
	    			patientAdministration();
	    			break;
	    		case 3:
	    			editPatient();
	    			break;
	    		case 4:
	    			doctorSchedule();
	    			break;
	    		case 5:
	    			doctorEditSchedule();
	    			break;
	    		case 6:
	    			scheduleAppointment();
	    			break;
	    		case 7:
	    			BillsPayment.billOption();
	    			break;
	    		case 8:
	    			accountSettings();
	    		case 9:
	    			startProgram();
	    			cont = false;
	    		default:
	    			System.err.println("Your input is incorrect. Please try again.");	
	    	}
		}
	}
	
	public static void viewPatient() {
		over.viewPatientRecord();
        if (patientInfo.isEmpty()) {
            System.out.println("\t \t \t \t \t \t \t No patient yet.");
            over.line();
        }else{
            printPatient();
        }
	}
	
	public static void scheduleAppointment() {
		sc.nextLine();
		System.out.print("\t \t \t \t \t \t \t Enter patient's ID: ");
		String patientID = sc.nextLine();
		if(patientInfo.containsKey(patientID)) {
		}else {
			System.err.println("\t \t \t \t \t \t \t There is no patient with an ID of " + patientID);
		}
		System.out.print("\t \t \t \t \t \t \t Enter the Doctor's ID you want to appoint: ");
		String appoint = sc.nextLine();
		
		if(docAcc.containsKey(appoint)) {
			System.out.print("\t \t \t \t \t \t \t Enter the day you want to schedule: ");
			String sched = sc.nextLine();
			TreeMap<String, DoctorData> docData = docAcc.get(appoint);
			DoctorData getDoctorData = docData.get("data");
			List<String> schedule = getDoctorData.getSchedule();
			schedule.remove(sched);
			Doctors.appointment.offer(sched);
			System.out.println("\t \t \t \t \t \t \t Appointment added successfuly.");
		}else {
			System.err.println("\t \t \t \t \t \t \t There is no doctor with an ID of " + appoint);
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
        patientInformation.add("Patient Age: " + sc.nextInt());
        sc.nextLine();
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
	
	public static void editInfo(Map<String, List> map) {
		List <String> myList = new ArrayList<>();
		for(List<String> list : map.values()) {
			myList.addAll(list);
		}
		sc.nextLine();
		while(true) {
			System.out.print("\t \t \t \t \t \t \t Enter the ID of the patient you want to edit (type 'done' if you are done): ");
			String editPatientID = sc.nextLine();
			if(editPatientID.equalsIgnoreCase("done")) {
				break;
			}
			
			if(patientInfo.containsKey(editPatientID)) {
				System.out.print("\t \t \t \t \t \t \t Enter the information of the patient you want to edit: ");
				String editPatientInfo = sc.nextLine();
				
				if(editPatientInfo.equalsIgnoreCase("name")) {
					editValue = 0;
					System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
					myList.set(editValue,"Patient Name: " + sc.nextLine());
					map.put(editPatientID, myList);
				}else if(editPatientInfo.equalsIgnoreCase("age")) {
					editValue = 1;
					System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
					myList.set(editValue,"Patient Age: " + sc.nextInt());
					map.put(editPatientID, myList);
				}else if(editPatientInfo.equalsIgnoreCase("gender")) {
					editValue = 2;
					System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
					myList.set(editValue,"Patient Gender: " + sc.nextLine());
					map.put(editPatientID, myList);
				}else if(editPatientInfo.equalsIgnoreCase("address")) {
					editValue = 3;
					System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
					myList.set(editValue,"Patient Address: " + sc.nextLine());
					map.put(editPatientID, myList);
				}else if(editPatientInfo.equalsIgnoreCase("room")) {
					editValue = 4;
					System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
					myList.set(editValue,"Patient Room: " + sc.nextLine());
					map.put(editPatientID, myList);
				}else if(editPatientInfo.equalsIgnoreCase("illness")) {
					editValue = 5;
					System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
					myList.set(editValue,"Patient Illness: " + sc.nextLine());
					map.put(editPatientID, myList);
				}else if(editPatientInfo.equalsIgnoreCase("doctor")) {
					editValue = 6;
					System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
					myList.set(editValue,"Patient Doctor: " + sc.nextLine());
					map.put(editPatientID, myList);
				}else if(editPatientInfo.equalsIgnoreCase("status")) {
					editValue = 7;
					System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
					myList.set(editValue,"Patient Status: " + sc.nextLine());
					map.put(editPatientID, myList);
				}else {
					System.err.println("\t \t \t \t \t \t \t The information you entered is not present. Please try again.");
				}
			}else {
				System.err.println("\t \t \t \t \t \t \t The patient ID you entered is not present. Please try again.");
			}
		}
	}
	
	public static void doctorSchedule() {
		for(Map.Entry<String, TreeMap<String, DoctorData>> entry : docAcc.entrySet()) {
			String docID = entry.getKey();
			TreeMap<String, DoctorData> docData = entry.getValue();
			DoctorData data = docData.get("data");
			
			System.out.println("Doctor ID: " + docID);
			System.out.println("Doctor Name: " + data.getDoctorName());
			System.out.println("Doctor Expertise: " + data.getExpertise());
			System.out.print("Schedule: ");
			List<String> sched = data.getSchedule();
			for(String schedule : sched) {
				System.out.print(schedule);
				if(sched.indexOf(schedule) < sched.size() - 1){
					System.out.print(",");
				}
			}
			System.out.println();
		}
		
		over.line();
	}
	
	public static void doctorEditSchedule() {
		sc.nextLine();
		System.out.print("\t \t \t \t \t \t \t Enter the ID of doctor: ");
		String doctorID = sc.nextLine();
		if(docAcc.containsKey(doctorID)) {
			System.out.print("\t \t \t \t \t \t \t Enter the day you want to remove: ");
			String dayRemove = sc.nextLine();
			TreeMap<String, DoctorData> docData = docAcc.get(doctorID);
			if(docData.containsKey("data")) {
				DoctorData getDoctorData = docData.get("data");
				List<String> sched = getDoctorData.getSchedule();
				if(sched.isEmpty()) {
					System.out.println("\t \t \t \t \t \t \t The doctor has no more schedule.");
				}
				sched.remove(dayRemove);
			}else {
				System.out.println("\t \t \t \\t \t \t \t No schedule found on this doctor.");
			}
		}else {
			System.out.println("\t \t \t \t \t \t \t There is no match for this doctor with an id of " + doctorID);
		}
	}
	
	public static void accountSettings() {
		boolean cont = true;
		while(cont) {
			System.out.println("\t \t \t \t \t \t \t [1] Account Information");
			System.out.println("\t \t \t \t \t \t \t [2] Edit Account Information");
			System.out.println("\t \t \t \t \t \t \t [3] Back");
			System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
	                accountInformation();
					break;
				case 2:
					editInformation();
					break;
				case 3:
					nurseOption();
					cont = false;
			}
		}
	}
	
	public static void editInformation() {
		List <String> myList = new ArrayList<>();
		for(List<String> list : nurseAcc.values()) {
			myList.addAll(list);
		}
		sc.nextLine();
		System.out.print("\t \t \t \t \t \t \t Enter your ID: ");
		String nurseID = sc.nextLine();
		
		if(nurseAcc.containsKey(nurseID)) {
			System.out.print("\t \t \t \t \t \t \t Enter the information you want to edit: ");
			String editAccInfo = sc.nextLine();
			
			if(editAccInfo.equalsIgnoreCase("full name")) {
				editValue = 0;
				System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
				myList.set(editValue,"Nurse's Full name: " + sc.nextLine());
				nurseAcc.put(nurseID, myList);
				System.out.println("\t \t \t \t \t \t \t Information has been sucessfuly edited.");
			}else if(editAccInfo.equalsIgnoreCase("name")) {
				editValue = 1;
				System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
				myList.set(editValue,"Nurse's Username: " + sc.nextLine());
				nurseAcc.put(nurseID, myList);
				System.out.println("\t \t \t \t \t \t \t Information has been sucessfuly edited.");
			}else if(editAccInfo.equalsIgnoreCase("password")) {
				editValue = 2;
				System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
				myList.set(editValue,"Nurse's Password: " + sc.nextLine());
				nurseAcc.put(nurseID, myList);
				System.out.println("\t \t \t \t \t \t \t Information has been sucessfuly edited.");
			}else {
				System.err.println("There is no " + editAccInfo + " in the account information.");
			}
		}
	}
	
	public static void accountInformation() {
		sc.nextLine();
		System.out.print("\t \t \t \t \t \t \t Enter your ID: ");
		String nurseID = sc.nextLine();
	    if (nurseAcc.containsKey(nurseID)) {
	        System.out.println("\t \t \t \t \t \t \t Nurse ID: " + nurseID);
	        List<String> nurseInfo = nurseAcc.get(nurseID);
	        for (String info : nurseInfo) {
	            System.out.println("\t \t \t \t \t \t \t " + info);
	        }
	    } else {
	        System.err.println("\t \t \t \t \t \t \t Nurse ID not found.");
	    }
	}

	
	public static void printPatient() {
		System.out.println("\t \t \t \t \t \t \t Current Patient/s: " + (key-1));
		over.line();
		for(Map.Entry<String, List> key : patientInfo.entrySet()) {
			List<String> values = key.getValue();
			System.out.println("\t \t \t \t \t \t \t Patient ID: " + key.getKey());
			for(String value : values) {
				System.out.println("\t \t \t \t \t \t \t " + value);
			}
			over.line();
		}
	}
}
