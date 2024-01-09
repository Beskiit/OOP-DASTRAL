package DastralOOP;

import java.util.HashMap;
import java.util.Scanner;

public class Admin extends Overriding{
	static Scanner sc = new Scanner(System.in);
	static Overriding over = new Overriding();
	static UserSide patientInformation = new UserSide();
	static HashMap<String, String> username = new HashMap<String, String>();
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
	    		break;
	    	} else {
	    		System.out.println("\t \t \t \t \t \t \t Wrong Credentials\n \t \t \t \t \t \t \t Invalid Username or Password");
	    	}
		}
      
        adminActions();
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
        	        userLogin();
        	    }else if(choice == 3){
        	    	System.out.println("\t \t \t \t \t \t \t Thank you for using our program!");
        	    	System.exit(0);
        	    }else {
        	    	System.err.println("\t \t \t \t \t \t \t Your input is wrong! Please try again.");
        	    }
    		}
    }
    
    public static void userLogin() {
    	over.userLoginName();
    	System.out.print("\t \t \t \t \t \t \t Enter username: ");
    	String user = sc.next();
    	System.out.print("\t \t \t \t \t \t \t Enter password: ");
    	String pass = sc.next();
    	
    	if(username.containsKey(user) && username.containsValue(pass)) {
    		userInside();
    	}else {
    		sc.nextLine();
    		System.err.println("\t \t \t \t \t \t \t Username or password is incorrect! Please try again.");
    		over.line();
    	}
    }
    
    public static void userInside() {
    	boolean cont = true;
    	while(cont) {
    		over.userOptions();
	    	System.out.println("\t \t \t \t \t \t \t [1] View patient record");
	    	System.out.println("\t \t \t \t \t \t \t [2] Input new patient record");
	    	System.out.println("\t \t \t \t \t \t \t [3] Edit patient record");
	    	System.out.println("\t \t \t \t \t \t \t [4] Bills and payments");
	    	System.out.println("\t \t \t \t \t \t \t [5] Doctors");
	    	System.out.println("\t \t \t \t \t \t \t [6] Back");
	    	System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
	    	int choice = sc.nextInt();
	    	over.line();
	    		switch(choice) {
	    		case 1:
	    			patientInformation.healthRecord();
	    			break;
	    		case 2:
	    			patientInformation.patientInfoFinal();
	    			break;
	    		case 3:
	    			patientInformation.editKey();
	    			break;
	    		case 4:
	    			BillsPayment.billOption();
	    			break;
	    		case 5:
	    			Doctors.doctorOptions();
	    			break;
	    		case 6:
	    			startProgram();
	    			cont = false;
	    		default:
	    			System.out.println("\t \t \t \t \t \t \t Your input is wrong! Please try again.");
	    	}
    }
 }

    public static void adminActions() {
        int choice;
        boolean cont = true;
        
        while(cont) {
        	over.adminOptions();
            System.out.println("\t \t \t \t \t \t \t [1] Add User");
            System.out.println("\t \t \t \t \t \t \t [2] Remove User");
            System.out.println("\t \t \t \t \t \t \t [3] View User");
            System.out.println("\t \t \t \t \t \t \t [4] Back");
            System.out.print("\t \t \t \t \t \t \t Enter your choice: ");
            choice = sc.nextInt();
           
            switch (choice) { 
                case 1:
                    addUser();
                    break;

                case 2:
                    removeUser();
                    break;

                case 3:
                	viewUser();
                    break;

                case 4:
                	startProgram();
                	cont = false;
                default:
                	System.err.println("\t \t \t \t \t \t \t Your input is wrong! Please try again.");
            }
        }
    }

    public static void addUser() {
    	over.addUserName();
        System.out.print("\t \t \t \t \t \t \t Enter Username: ");
        String user = sc.next();
        System.out.print("\t \t \t \t \t \t \t Enter Password: ");
        String pass = sc.next();
        username.put(user, pass);
        System.out.println("\t \t \t \t \t \t \t Account created successfuly!");
    }

    private static void removeUser() {
    	over.removeUserName();
    	sc.nextLine();
        System.out.print("\t \t \t \t \t \t \t Enter the username you want to remove: ");
        String userRemove = sc.nextLine();
        username.remove(userRemove);
        System.out.println("\t \t \t \t \t \t \t User " + userRemove + " Removed Successfully!");
    }
    
    private static void viewUser(){
    	over.viewUserName();
      if(username.isEmpty()) {
    	  System.out.println("\t \t \t \t \t \t \t No accounts yet.");
      }else {
    	  for(String n : username.keySet()) {
    		  System.out.println("\n \t \t \t \t \t \t \t Username: " + n);
    		  System.out.println("\t \t \t \t \t \t \t Password: " + n + "\n");
    	  }
      }
    }
}
