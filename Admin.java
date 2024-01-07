package hostfatal;
import java.util.Scanner;

public class Admin {
	private static final String adminUsername = "Admin";
	
	private static final String adminPassword = "Pogiako123";
	
	public void login(){
		boolean success = true;
        Scanner sc = new Scanner(System.in);
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
      
      
    private boolean isAdminValid(String adminUsername, String adminPassword) {
    	return this.adminUsername.equals(adminUsername) && this.adminPassword.equals(adminPassword);
    }

    private void adminActions() {
        Scanner sc = new Scanner(System.in);

        int choice;
        
        do {
            System.out.println("Admin Options");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. Register a Doctor ");
            System.out.println("4. Remove a Doctor ");
            System.out.println("5. List Register Doctor");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            choice = sc.next().charAt(0);
           
            switch (choice) { 
                case 1:
                    addPatient();
                    break;

                case 2:
                    removePatient();
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;
            }
        } while (choice != 6);

    }

    private void addPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Patient name : ");
        String patientName = sc.nextLine();
        System.out.println("Enter Patient Contact : ");
        String patientContact = sc.nextLine();
        System.out.println("Patient added Name: " + patientName + ", Contact: " + patientContact);
    }

    private void removePatient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name Patient to Remove : ");
        String namePatientToRemove = sc.nextLine();
        System.out.println("Patient Removed Successfully");
    }
    
    private void registerDoctor(){
      
    }
    
    private void removeDoctor(){
        
    }
}

        
