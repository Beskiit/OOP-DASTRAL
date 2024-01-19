package DastralOOP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Doctors extends Admin {
	
    static Scanner sc = new Scanner(System.in);
    static Queue<String> appointment = new LinkedList<String>();
    public static void doctorOptions() {
    		boolean cont = true;
        	over.doctors();
        	while(cont) {
	            System.out.println("\t \t \t \t \t \t \t [1] View patient");
	            System.out.println("\t \t \t \t \t \t \t [2] View schedule");
	            System.out.println("\t \t \t \t \t \t \t [3] Account Settings");
	            System.out.println("\t \t \t \t \t \t \t [4] Back");
	            System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
	            int choice = sc.nextInt();
	            
	            switch(choice) {
	            	case 1:
	            		NurseAccount.viewPatient();
	            		break;
	            	case 2:
	            		appointmentSched();
	            		break;
	            	case 3:
	            		accountSettings();
	            		break;
	            	case 4:
	            		startProgram();
	            		cont = false;
	            	default:
	            		System.err.println("Your input is incorrect. Please try again.");	
	            }
        	}
    }
    
    public static void appointmentSched() {
    	List <String> myList = new ArrayList<>();
		for(List<String> list : NurseAccount.patientInfo.values()) {
			myList.addAll(list);
		}
    	System.out.println("\t \t \t \t \t \t \t Doctor's Schedule");
    	System.out.println("\t \t \t \t \t \t \t " + myList.get(0));
    	System.out.println("\t \t \t \t \t \t \t Day of appointment: " + appointment.peek());
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
        			accountInfo();
        			break;
        		case 2:
        			editAccInfo();
        			break;
        		case 3:
        			doctorOptions();
        			cont = false;
        	}
    	}
    }
    
    public static void accountInfo() {
    	sc.nextLine();
		System.out.print("\t \t \t \t \t \t \t Enter your ID: ");
		String docID = sc.nextLine();
	    if (doctorAcc.containsKey(docID)) {
	        System.out.println("\t \t \t \t \t \t \t Doctor ID: " + docID);
	        List<String> docInfo = doctorAcc.get(docID);
	        for (String info : docInfo) {
	            System.out.println("\t \t \t \t \t \t \t " + info);
	        }
	    } else {
	        System.err.println("\t \t \t \t \t \t \t Nurse ID not found.");
	    }
    }
    
    public static void editAccInfo() {
    	List <String> myList = new ArrayList<>();
		for(List<String> list : doctorAcc.values()) {
			myList.addAll(list);
		}
		int editValue;
		sc.nextLine();
		System.out.print("\t \t \t \t \t \t \t Enter your ID: ");
		String docID = sc.nextLine();
		
		if(doctorAcc.containsKey(docID)) {
			System.out.print("\t \t \t \t \t \t \t Enter the information you want to edit: ");
			String editAccInfo = sc.nextLine();
			
			if(editAccInfo.equalsIgnoreCase("full name")) {
				editValue = 0;
				System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
				myList.set(editValue,"Doctor's Full name: " + sc.nextLine());
				doctorAcc.put(docID, myList);
				System.out.println("\t \t \t \t \t \t \t Information has been sucessfuly edited.");
			}else if(editAccInfo.equalsIgnoreCase("name")) {
				editValue = 1;
				System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
				myList.set(editValue,"Doctor's Username: " + sc.nextLine());
				doctorAcc.put(docID, myList);
				System.out.println("\t \t \t \t \t \t \t Information has been sucessfuly edited.");
			}else if(editAccInfo.equalsIgnoreCase("password")) {
				editValue = 2;
				System.out.print("\t \t \t \t \t \t \t Enter your new information: ");
				myList.set(editValue,"Doctor's Password: " + sc.nextLine());
				doctorAcc.put(docID, myList);
				System.out.println("\t \t \t \t \t \t \t Information has been sucessfuly edited.");
			}else {
				System.err.println("There is no " + editAccInfo + " in the account information.");
			}
		}
    }
    
    public static void editDoctorSched() {
    	sc.nextLine();
    	System.out.println("\t \t \t \t \t \t \t Enter the ID of doctor: ");
		String doctorID = sc.nextLine();
		if(docAcc.containsKey(doctorID)) {
			System.out.println("\t \t \t \t \t \t \t Enter the day you want to remove: ");
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
}