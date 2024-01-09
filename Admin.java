package hostfatal;
import java.util.HashMap;
import java.util.Scanner;

public class Admin extends Overriding{
	static Scanner sc = new Scanner(System.in);
	static Overriding over = new Overriding();
	static userSide patientInformation = new userSide();
	static HashMap<String, String> username = new HashMap<String, String>();
	private static final String adminUser = "admin";
	
	private static final String adminPass = "admin";
	
	public static void adminLogin(){
		boolean success = true;
        do {
        	System.out.print("Enter Admin Username : ");
        	String enterAdminUsername = sc.next();
        	System.out.print("Enter Password : ");
        	String  enterAdminPassword = sc.next();
    	  
	    	if (isAdminValid(enterAdminUsername, enterAdminPassword)) {
	    		System.out.println("Admin Successfully Logged In");
	    	} else {
	    		System.out.println("Wrong Credentials\nInvalid Username or Password");
	    	}
      } while (!success);
      
        adminActions();
    }
      
      
    private static boolean isAdminValid(String adminUsername, String adminPassword) {
    	return adminUser.equals(adminUsername) && adminPass.equals(adminPassword);
    }
    
    public static void startProgram() {
    		System.out.println ("[1] - Admin");
    		System.out.println ("[2] - User");
    		System.out.print("Enter your choice: ");
    		int choice = sc.nextInt();
    	    over.line();
    		if (choice == 1) {
    	        adminLogin();
    	    } else if (choice == 2) {
    	        userLogin();
    	    } else {
    	    	System.out.println("Invalid choice, Please enter 1 or 2 only.");
    	    }   
    }
    
    public static void userLogin() {
    	System.out.print("Enter username: ");
    	String user = sc.next();
    	System.out.print("Enter password: ");
    	String pass = sc.next();
    	
    	if(username.containsKey(user) && username.containsValue(pass)) {
    		userInside();
    	}else {
    		System.err.println("Username or password is incorrect! Please try again.");
    	}
    }
    
    public static void userInside() {
    	boolean cont = true;
    	while(cont) {
	    	System.out.println("[1] Patients Health Record");
	    	System.out.println("[2] Input new patient record");
	    	System.out.println("[3] Edit patient record");
	    	System.out.println("[4] Bills and payments");
	    	System.out.println("[5] Exit");
	    	int choice = sc.nextInt();
	    		switch(choice) {
	    		case 1:
	    			patientInformation.healthRecord();
	    			break;
	    		case 2:
	    			patientInformation.patientInfoFinal();
	    			break;
	    		case 3:
	    			break;
	    		case 4:
	    			break;
	    		case 5:
	    			break;
	    	}
    }
 }

    private static void adminActions() {

        int choice;
        boolean cont = true;
        
        while(cont) {
            System.out.println("Admin Options");
            System.out.println("[1] Add User");
            System.out.println("[2] Remove User");
            System.out.println("[3] View User");
            System.out.println("[4] Exit");
            System.out.println("Enter your choice");
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
                    break;
            }
        }

    }

    private static void addUser() {
        System.out.println("Enter Username: ");
        String user = sc.next();
        System.out.println("Enter Password: ");
        String pass = sc.next();
        username.put(user, pass);
        System.out.println("Account created successfuly!");
        over.line();
    }

    private static void removeUser() {
        System.out.print("Enter the username you want to remove: ");
        String userRemove = sc.nextLine();
        System.out.println("User" + userRemove + "Removed Successfully!");
        username.remove(userRemove);
        over.line();
    }
    
    private static void viewUser(){
      if(username.isEmpty()) {
    	  System.out.println("No accounts yet.");
      }else {
    	  for(Map.Entry m: username.entrySet()) {
    		  System.out.println("\nUsername: " + m.getKey());
    		  System.out.println("Password: " + m.getValue() + "\n");
    	  }
    	  over.line();
      }
    }
}
