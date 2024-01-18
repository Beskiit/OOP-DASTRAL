package DastralOOP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin extends Overriding{
	static Scanner sc = new Scanner(System.in);
	static Overriding over = new Overriding();
	static UserSide patientInformation = new UserSide();
	static int nurKey = 6;
	static String nurseKey = "NURSE - " + nurKey;
	static int docKey = 6;
	static String doctorKey = "DOC - " + docKey;
	static Map<String, String> doctorName = new HashMap<String, String>();
	static Map<String, String> doctorUser = new HashMap<String, String>();
	static Map<String, String> doctorPass = new HashMap<String, String>();
	static Map<String, String> nurseName = new HashMap<String, String>();
	static Map<String, String> nurseUsername = new HashMap<String, String>();
	static Map<String, String> nursePassword = new HashMap<String, String>();
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
	
	public static void defaultDoctor() {
		doctorName.put("DOC - 1", "Dr. Smith");
		doctorUser.put("DOC - 1", "smith@sample.com");
		doctorPass.put("DOC - 1", "password123");
		doctorName.put("DOC - 2", "Dr. Johnson");
		doctorUser.put("DOC - 2", "johnon@sample.com");
		doctorPass.put("DOC - 2", "securePass");
		doctorName.put("DOC - 3", "Dr. Davis");
		doctorUser.put("DOC - 3", "davis@sample.com");
		doctorPass.put("DOC - 3", "pass123");
		doctorName.put("DOC - 4", "Dr. Williams");
		doctorUser.put("DOC - 4", "williams@sample.com");
		doctorPass.put("DOC - 4", "securePass123");
		doctorName.put("DOC - 5", "Dr. Brown");
		doctorUser.put("DOC - 5", "brown@example.com");
		doctorPass.put("DOC - 5", "passSecure");
	}
	
	public static void defaultNurse() {
		nurseName.put("NURSE - 1", "Nurse Anderson");
		nurseUsername.put("NURSE - 1", "nurseanderson@sample.com");
		nursePassword.put("NURSE - 1", "nursePass123");
		nurseName.put("NURSE - 2", "Nurse Miller");
		nurseUsername.put("NURSE - 2", "nursemiller@sample.com");
		nursePassword.put("NURSE - 2", "nurseSecurePass");
		nurseName.put("NURSE - 3", "Nurse Wilson");
		nurseUsername.put("NURSE - 3", "nursewilson@sample.com");
		nursePassword.put("NURSE - 3", "nursePass456");
		nurseName.put("NURSE - 4", "Nurse Carter");
		nurseUsername.put("NURSE - 4", "nursecarter@sample.com");
		nursePassword.put("NURSE - 4", "nurseSecurePass456");
		nurseName.put("NURSE - 5", "Nurse Turner");
		nurseUsername.put("NURSE - 5", "nurseturner@example.com");
		nursePassword.put("NURSE - 5", "nursePassSecure789");
	}
	
	public static void doctorLogin() {
		while(true) {
			System.out.println("Enter your ID: ");
			String doctorID = sc.nextLine();
			if(doctorName.containsKey(doctorID)) {
				System.out.println("\t \t \t \t \t \t \t Enter Username: ");
				String doctorUsername = sc.nextLine();
				System.out.println("\t \t \t \t \t \t \t Enter Password: ");
				String doctorPassword = sc.nextLine();
				
				if(doctorUser.containsValue(doctorUsername) && doctorPass.containsValue(doctorPassword)) {
					doctorActions();
					break;
				}else {
					System.out.println("\t \t \t \t \t \t \t Wrong Credentials\n \t \t \t \t \t \t \t Invalid Username or Password");
				}
			}
		}
	}
	
	public static void nurseLogin() {
		while(true) {
			System.out.println("Enter your ID: ");
			String nurseID = sc.nextLine();
			if(nurseName.containsKey(nurseID)) {
				System.out.println("\t \t \t \t \t \t \t Enter Username: ");
				String nurseUser = sc.nextLine();
				System.out.println("\t \t \t \t \t \t \t Enter Password: ");
				String nursePass = sc.nextLine();
				
				if(nurseUsername.containsValue(nurseUser) && nursePassword.containsValue(nursePass)) {
					NurseAccount.nurseOption();
					break;
				}else {
					System.out.println("\t \t \t \t \t \t \t Wrong Credentials\n \t \t \t \t \t \t \t Invalid Username or Password");
				}
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
            System.out.println("\t \t \t \t \t \t \t [4] Back");
            System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
            int choice = sc.nextInt();
           
            if(choice == 1) {
            	boolean cont = true;
    	    	while(cont) {
    	    		System.out.println("\t \t \t \t \t \t \t [1] Doctor");
        	        System.out.println("\t \t \t \t \t \t \t [2] Nurse");
        	        System.out.println("\t \t \t \t \t \t \t [3] Back");
        	        System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
        	        int choiceAdmin = sc.nextInt();
        	        
        	        switch(choiceAdmin) {
        	        	case 1:
        	        		addUserNurse();
        	        		break;
        	        	case 2:
        	        		addUserDoctor();
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
    	    	while(cont) {
    	    		System.out.println("\t \t \t \t \t \t \t [1] Doctor");
        	        System.out.println("\t \t \t \t \t \t \t [2] Nurse");
        	        System.out.println("\t \t \t \t \t \t \t [3] Back");
        	        System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
        	        int choiceAdmin = sc.nextInt();
        	        
        	        switch(choiceAdmin) {
        	        	case 1:
        	        		removeUserNurse();
        	        		break;
        	        	case 2:
        	        		removeUserDoctor();
        	        		break;
        	        	case 3:
        	        		adminActions();
        	        		cont = false;
        	        }
    	    	}
            }else if(choice == 4) {
            	startProgram();
            	break;
            }else {
            	System.err.println("\t \t \t \t \t \t \t Your input is incorrect. Please try again.");
            }
        }
    }

    public static void addUserNurse() {
    	over.addUserName();
    	System.out.print("\t \t \t \t \t \t \t Enter Full name: ");
    	nurseName.put(nurseKey, sc.next());
        System.out.print("\t \t \t \t \t \t \t Enter Username: ");
        nurseUsername.put(nurseKey, sc.next());
        System.out.print("\t \t \t \t \t \t \t Enter Password: ");
        nursePassword.put(nurseKey, sc.next());
        System.out.println("\t \t \t \t \t \t \t Account created successfuly!");
    }
    
    public static void addUserDoctor() {
    	over.addUserName();
    	System.out.print("\t \t \t \t \t \t \t Enter Full name: ");
    	doctorName.put(doctorKey, sc.next());
        System.out.print("\t \t \t \t \t \t \t Enter Username: ");
        doctorUser.put(doctorKey, sc.next());
        System.out.print("\t \t \t \t \t \t \t Enter Password: ");
        doctorPass.put(doctorKey, sc.next());
        System.out.println("\t \t \t \t \t \t \t Account created successfuly!");
    }

    public static void removeUserNurse() {
    	over.removeUserName();
    	sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the ID of nurse you want to remove: ");
        String nurseKeyRemove = sc.nextLine();
        nurseName.remove(nurseKeyRemove);
        nursePassword.remove(nurseKeyRemove);
        nurseUsername.remove(nurseKeyRemove);
        System.out.println("\t \t \t \t \t \t \t " + nurseKeyRemove + " Removed Successfully!");
    }
    
    public static void removeUserDoctor() {
    	over.removeUserName();
    	sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the ID of doctor you want to remove: ");
        String docKeyRemove = sc.nextLine();
        doctorName.remove(docKeyRemove);
        doctorPass.remove(docKeyRemove);
        doctorUser.remove(docKeyRemove);
        System.out.println("\t \t \t \t \t \t \t " + docKeyRemove + " Removed Successfully!");
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
	    			for(Map.Entry<String, String> entry : doctorName.entrySet()) {
	    				String docID = entry.getKey();
	    				String docName = entry.getValue();
	    				String docUser = doctorUser.get(docID);
	    				String docPass = doctorPass.get(docID);
	    				
	    				System.out.println("\t \t \t \t \t \t \t Doctor ID: " + docID);
	    				System.out.println("\t \t \t \t \t \t \t Doctor Name: " + docName);
	    				System.out.println("\t \t \t \t \t \t \t Doctor Username: " + docUser);
	    				System.out.println("\t \t \t \t \t \t \t Doctor Password: " + docPass);
	    				over.line();
	    			}
	    			break;
	    		case 2:
	    			for(Map.Entry<String, String> entry : nurseName.entrySet()) {
	    				String nurseID = entry.getKey();
	    				String nurseName = entry.getValue();
	    				String nurseUser = nurseUsername.get(nurseID);
	    				String nursePass = nursePassword.get(nurseID);
	    				
	    				System.out.println("\t \t \t \t \t \t \t Nurse ID: " + nurseID);
	    				System.out.println("\t \t \t \t \t \t \t Nurse Name: " + nurseName);
	    				System.out.println("\t \t \t \t \t \t \t Nurse Username: " + nurseUser);
	    				System.out.println("\t \t \t \t \t \t \t Nurse Password: " + nursePass);
	    				over.line();
	    			}
	    			break;
	    		case 3:
	    			adminActions();
	    			cont = false;
	    	}
    	}
    }
}
