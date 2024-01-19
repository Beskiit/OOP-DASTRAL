package DastralOOP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Admin extends Overriding{
	static Scanner sc = new Scanner(System.in);
	static Overriding over = new Overriding();
	static int nurKey = 1;
	static int docKey = 1;
	static String doctorKey = "DOC - " + docKey;
	static Map <String, List<String>> doctorAcc = new HashMap<>();
	static TreeMap<String, TreeMap<String, DoctorData>> docAcc = new TreeMap<>();
	static Map<String, List<String>> nurseAcc = new HashMap<>();
	private static final String adminUser = "admin";
	
	private static final String adminPass = "admin";
	
	public static void adminLogin(){
		over.admin();
		while(true) {
			System.out.print("\t \t \t \t \t \t \t Enter Admin Username : ");
        	String enterAdminUsername = sc.next();
        	System.out.print("\t \t \t \t \t \t \t Enter Password : ");
        	String  enterAdminPassword = sc.next();
    	  
	    	if (isAdminValid(enterAdminUsername, enterAdminPassword)) {
	    		System.out.println("\t \t \t \t \t \t \t Admin Successfully Logged In");
	    		adminActions();
	    		break;
	    	} else {
	    		System.out.println("\t \t \t \t \t \t \t Wrong Credentials\n \t \t \t \t \t \t \t Invalid Username or Password");
	    	}
		}
    }
	
	public static void doctorLogin() {
			List<List<String>> docInfo = new ArrayList<>();
			for(List<String> values : doctorAcc.values()) {
				docInfo.add(values);
			}
			while(true) {
				sc.nextLine();
				System.out.print("\t \t \t \t \t \t \t Enter your ID: ");
				String doctorID = sc.nextLine();
				if(doctorAcc.containsKey(doctorID)) {
					System.out.print("\t \t \t \t \t \t \t Enter Username: ");
					String doctorUsername = "Doctor's Username: " + sc.next();
					System.out.print("\t \t \t \t \t \t \t Enter Password: ");
					String doctorPassword = "Doctor's Password: " + sc.next();
					
					String storedUser = doctorAcc.get(doctorID).get(1);
					String storedPass = doctorAcc.get(doctorID).get(2);
					
					if(storedUser.equals(doctorUsername) && storedPass.equals(doctorPassword)) {
						Doctors.doctorOptions();
						break;
					}else {
						System.out.println("\t \t \t \t \t \t \t Your username or password is incorrect. Please try again.");
					}
				}else {
					System.out.println("\t \t \t \t \t \t \t Your ID is invalid. Please try again.");
				}
		}
	}
	
	public static String nurseLogin() {
		List<List<String>> nurseInfo = new ArrayList<>();
		for(List<String> values : nurseAcc.values()) {
			nurseInfo.add(values);
		}
		while(true) {
			sc.nextLine();
			System.out.print("\t \t \t \t \t \t \t Enter your ID: ");
			String nurseID = sc.nextLine();
			if(nurseAcc.containsKey(nurseID)) {
				System.out.print("\t \t \t \t \t \t \t Enter Username: ");
				String nurseUsername = "Nurse's Username: " + sc.next();
				System.out.print("\t \t \t \t \t \t \t Enter Password: ");
				String nursePassword = "Nurse's Password: " + sc.next();
				
				String storedUser = nurseAcc.get(nurseID).get(1);
				String storedPass = nurseAcc.get(nurseID).get(2);
				
				if(nurseUsername.equals(storedUser) && nursePassword.equals(storedPass)) {
					NurseAccount.nurseOption();
					return nurseID;
				}else {
					System.out.println("\t \t \t \t \t \t \t Your username or password is incorrect. Please try again.");
				}
			}else {
				System.err.println("\t \t \t \t \t \t \t Your ID is invalid. Please try again.");
			}
		}
	}
      
    public static boolean isAdminValid(String adminUsername, String adminPassword){
    	return adminUsername.equals(adminUser) && adminPassword.equals(adminPass);
    }
    
    public static void startProgram(){
    		over.name();
    		while(true) {
    			System.out.println("\t \t \t \t \t \t \t [1] - Admin");
        		System.out.println("\t \t \t \t \t \t \t [2] - User");
        		System.out.println("\t \t \t \t \t \t \t [3] - Exit");
        		System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
        		int choice = sc.nextInt();
        	    over.line();
        		if(choice == 1){
        	        adminLogin();
        	    }else if (choice == 2){
        	    	boolean cont = true;
        	    	while(cont) {
        	    		System.out.println("\t \t \t \t \t \t \t [1] Doctor");
            	        System.out.println("\t \t \t \t \t \t \t [2] Nurse");
            	        System.out.println("\t \t \t \t \t \t \t [3] Back");
            	        System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
            	        int choiceUser = sc.nextInt();
            	        
            	        switch(choiceUser) {
            	        	case 1:
            	        		doctorLogin();
            	        		break;
            	        	case 2:
            	        		nurseLogin();
            	        		break;
            	        	case 3:
            	        		startProgram();
            	        		cont = false;
            	        }
        	    	}
        	    }else if(choice == 3){
        	    	System.out.println("\t \t \t \t \t \t \t Thank you for using our program!");
        	    	System.exit(0);
        	    }else {
        	    	System.err.println("\t \t \t \t \t \t \t Your input is wrong! Please try again.");
        	    }
    		}
    }

    public static void adminActions() {
        while(true) {
        	over.adminOptions();
            System.out.println("\t \t \t \t \t \t \t [1] Add Account");
            System.out.println("\t \t \t \t \t \t \t [2] View Account");
            System.out.println("\t \t \t \t \t \t \t [3] Remove Account");
            System.out.println("\t \t \t \t \t \t \t [4] View Patients");
            System.out.println("\t \t \t \t \t \t \t [5] Back");
            System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
            int choice = sc.nextInt();
           
            if(choice == 1) {
            	boolean cont = true;
            	over.addOption();
    	    	while(cont) {
    	    		System.out.println("\t \t \t \t \t \t \t [1] Doctor");
        	        System.out.println("\t \t \t \t \t \t \t [2] Nurse");
        	        System.out.println("\t \t \t \t \t \t \t [3] Back");
        	        System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
        	        int choiceAdmin = sc.nextInt();
        	        
        	        switch(choiceAdmin) {
        	        	case 1:
        	        		addAccDoctor();
        	        		break;
        	        	case 2:
        	        		addAccNurse();
        	        		break;
        	        	case 3:
        	        		adminActions();
        	        		cont = false;
        	        }
    	    	}
            }else if(choice == 2) {
            	viewUser();
            }else if(choice == 3) {
            	boolean cont = true;
            	over.removeOption();
    	    	while(cont) {
    	    		System.out.println("\t \t \t \t \t \t \t [1] Doctor");
        	        System.out.println("\t \t \t \t \t \t \t [2] Nurse");
        	        System.out.println("\t \t \t \t \t \t \t [3] Back");
        	        System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
        	        int choiceAdmin = sc.nextInt();
        	        
        	        switch(choiceAdmin) {
        	        	case 1:
        	        		removeUserDoctor();
        	        		break;
        	        	case 2:
        	        		removeUserNurse();
        	        		break;
        	        	case 3:
        	        		adminActions();
        	        		cont = false;
        	        }
    	    	}
            }else if(choice == 4) {
            	NurseAccount.viewPatient();
            	break;
            }else if(choice == 5){
            	startProgram();
            	break;
            }else {
            	System.err.println("\t \t \t \t \t \t \t Your input is incorrect. Please try again.");
            }
        }
    }

    public static void addAccNurse() {
    	over.addUserName();
    	String nurseKey = "NURSE - " + nurKey;
    	List<String> nurseInfo = new ArrayList<String>();
    	sc.nextLine();
    	System.out.print("\t \t \t \t \t \t \t Enter Full name: ");
    	nurseInfo.add("Nurse's Name: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter Username: ");
        nurseInfo.add("Nurse's Username: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter Password: ");
        nurseInfo.add("Nurse's Password: " + sc.nextLine());
        nurseAcc.put(nurseKey, nurseInfo);
        nurKey++;
        System.out.println("\t \t \t \t \t \t \t Account created successfuly!");
    }
    
    public static void addAccDoctor() {
    	over.addUserName();
    	List<String> docInfo = new ArrayList<>();
    	sc.nextLine();
    	System.out.print("\t \t \t \t \t \t \t Enter Name: ");
    	String docName = sc.nextLine();
    	docInfo.add("Doctor's Name:" + docName);
        System.out.print("\t \t \t \t \t \t \t Enter Username: ");
        docInfo.add("Doctor's Username: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter Password: ");
        docInfo.add("Doctor's Password: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the expertise of doctor: ");
		String expertise = sc.nextLine();
		System.out.print("\t \t \t \t \t \t \t Enter the schedule of doctor (type 'done' if you are done): ");
		List<String> schedule = new ArrayList<>();
		while(true) {
			String days = sc.nextLine();
			
			if(days.equalsIgnoreCase("done")) {
				break;
			}
			schedule.add(days);
		}
		docAcc.put(doctorKey, new TreeMap<>());
		docAcc.get(doctorKey).put("data", new DoctorData(docName, expertise, new ArrayList<>(schedule)));
        doctorAcc.put(doctorKey, docInfo);
        docKey++;
        System.out.println("\t \t \t \t \t \t \t Account created successfuly!");
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
			docAcc.put(doctorKey, new TreeMap<>());
			docAcc.get(doctorKey).put("data", new DoctorData(doctorName, expertise, new ArrayList<>(schedule)));
		}
		over.line();
	}

    public static void removeUserNurse() {
    	over.removeUserName();
    	sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the ID of nurse you want to remove: ");
        String nurseKeyRemove = sc.nextLine();
        if(nurseAcc.containsKey(nurseKeyRemove)) {
        	nurseAcc.remove(nurseKeyRemove);
            System.out.println("\t \t \t \t \t \t \t " + nurseKeyRemove + " Removed Successfully!");
        }else {
        	System.err.println("\t \t \t \t \t \t \t " + nurseKeyRemove + " not found. Please try again.");
        }
    }
    
    public static void removeUserDoctor() {
    	over.removeUserName();
    	sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the ID of doctor you want to remove: ");
        String docKeyRemove = sc.nextLine();
        if(doctorAcc.containsKey(docKeyRemove)) {
        	doctorAcc.remove(docKeyRemove);
            System.out.println("\t \t \t \t \t \t \t " + docKeyRemove + " Removed Successfully!");
        }else {
        	System.err.println("\t \t \t \t \t \t \t " + docKeyRemove + " not found. Please try again.");
        }
    }
    
    public static void viewUser(){
    	boolean cont = true;
    	over.viewUserName();
    	while(cont) {
	    	System.out.println("\t \t \t \t \t \t \t [1] Doctor Account/s");
	    	System.out.println("\t \t \t \t \t \t \t [2] Nurse Account/s");
	    	System.out.println("\t \t \t \t \t \t \t [3] Back");
	    	System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
	    	int choice = sc.nextInt();
	    	switch(choice) {
	    		case 1:
	    			if(doctorAcc.isEmpty()) {
	    				System.out.println("\t \t \t \t \t \t \t There is no doctor yet.");
	    			}else {
	    				printDoctor();
	    			}
	    			break;
	    		case 2:
	    			if(nurseAcc.isEmpty()) {
	    				System.out.println("\t \t \t \t \t \t \t There is no nurse yet.");
	    			}else {
	    				printNurse();
	    			}
	    			break;
	    		case 3:
	    			adminActions();
	    			cont = false;
	    	}
    	}
    }
    
    public static void printDoctor() {
    	for(Map.Entry<String, List<String>> key : doctorAcc.entrySet()) {
			List<String> values = key.getValue();
			System.out.println("\t \t \t \t \t \t \t Doctor ID: " + key.getKey());
			for(String value : values) {
				System.out.println("\t \t \t \t \t \t \t " + value);
			}
			over.line();
		}
    }
    
    public static void printNurse() {
    	for(Map.Entry<String, List<String>> key : nurseAcc.entrySet()) {
			List<String> values = key.getValue();
			System.out.println("\t \t \t \t \t \t \t Nurse ID: " + key.getKey());
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