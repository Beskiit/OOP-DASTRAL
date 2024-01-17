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
	static Map <String, List<String>> patientInfo = new TreeMap<>();
	static Map<Integer, TreeMap<String, DoctorData>> doctorMap = new TreeMap<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void nurseOption() {
		boolean cont = true;
		while(cont) {
			System.out.println("\t \t \t \t \t \t \t [1] View patient record");
	    	System.out.println("\t \t \t \t \t \t \t [2] Input new patient record");
	    	System.out.println("\t \t \t \t \t \t \t [3] Edit patient record");
	    	System.out.println("\t \t \t \t \t \t \t [4] Doctor Schedule");
	    	System.out.println("\t \t \t \t \t \t \t [5] Edit Doctor Schedule");
	    	System.out.println("\t \t \t \t \t \t \t [6] Account Settings");
	    	System.out.println("\t \t \t \t \t \t \t [7] Back");
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
	    			accountSettings();
	    			break;
	    		case 7:
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
					myList.set(editValue,"Patient Age: " + sc.nextLine());
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
		for(Map.Entry<Integer, TreeMap<String, DoctorData>> entry : doctorMap.entrySet()) {
			int docID = entry.getKey();
			TreeMap<String, DoctorData> docData = entry.getValue();
			DoctorData data = docData.get("data");
			
			System.out.println("Doctor ID: " + docID);
			System.out.println("Doctor Name: " + data.getDoctorName());
			System.out.println("Doctor Expertise: " + data.getExpertise());
			System.out.println("Schedule: ");
			List<String> sched = data.getSchedule();
			for(String schedule : sched) {
				System.out.println(schedule);
				if(sched.indexOf(schedule) < sched.size() - 1){
					System.out.println(",");
				}
			}
		}
		
		over.line();
	}
	
	public static void addDoctors() {
		while(true) {
			System.out.println("\t \t \t \t \t \t \t Enter doctor name (type 'done' if you are done): ");
			String doctorName = sc.nextLine();
			
			if(doctorName.equalsIgnoreCase("done")) {
				break;
			}
			
			System.out.println("\t \t \t \t \t \t \t Enter the expertise of doctor: ");
			String expertise = sc.nextLine();
			
			System.out.println("\t \t \t \t \t \t \t Enter the schedule of doctor (type 'done' if you are done): ");
			List<String> schedule = new ArrayList<>();
			while(true) {
				String days = sc.nextLine();
				
				if(days.equalsIgnoreCase("done")) {
					break;
				}
				schedule.add(days);
			}
			doctorMap.put(docKey, new TreeMap<>());
			doctorMap.get(docKey).put("data", new DoctorData(doctorName, expertise, new ArrayList<>(schedule)));
			docKey++;
		}
		over.line();
	}
	
	public static void doctorEditSchedule() {
		System.out.println("\t \t \t \t \t \t \t Enter the ID of doctor: ");
		int doctorID = sc.nextInt();
		if(doctorMap.containsKey(doctorID)) {
			System.out.println("\t \t \t \t \t \t \t Enter the day you want to remove: ");
			String dayRemove = sc.nextLine();
			TreeMap<String, DoctorData> docData = doctorMap.get(doctorID);
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
		
	}
	
	public static void printPatient() {
		System.out.println("\t \t \t \t \t \t \t Current Patient/s: " + (key-1));
		over.line();
		for(Map.Entry<String, List<String>> key : patientInfo.entrySet()) {
			List<String> values = key.getValue();
			System.out.println("\t \t \t \t \t \t \t Patient ID: " + key.getKey());
			for(String value : values) {
				System.out.println("\t \t \t \t \t \t \t " + value);
			}
			over.line();
		}
	}
}

class DoctorData{
	private String doctorName;
	private String expertise;
	private List<String> schedule;
	
	public DoctorData(String doctorName, String expertise, List<String> schedule) {
		this.doctorName = doctorName;
		this.expertise = expertise;
		this.schedule = schedule;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	
	public String getExpertise() {
		return expertise;
	}
	
	public List<String> getSchedule(){
		return schedule;
	}
}
