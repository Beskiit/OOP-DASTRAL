package DastralOOP;
import java.util.Scanner;

public class HostFatal extends Overriding{
	static Overriding over = new Overriding();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[]args) {
		
		over.name();
		loginProcess();
        }      
}
        
        public static void loginProcess(){
		System.out.println ("Do you want to:");
		System.out.println ("1 - Log In");
		System.out.println ("2 - Sign up");
                over.line();
		System.out.println ("Press(1 or 2):");
                over.line();
                System.out.println("Your answer: ");
		int choice = scn.nextInt();
                over.line();
		if (choice == 1) {
                login();
                } else if (choice == 2) {
                signUp();
                } else {
                System.out.println("Invalid choice, Please enter 1 or 2 only.");
	}
        
	public static void login() {	
        Overriding over = new Overriding();
        Scanner scn = new Scanner(System.in);
        over.line();
        System.out.print("Enter your username: ");
        String username = scn.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scn.nextLine();
        

        
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful!");
            afterLogin();
        } else {
            System.out.println("Incorrect username or password.");
        }
    }
	public static void signUp() {
        Overriding over = new Overriding();
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a new username: ");
        String newUsername = scn.nextLine();
        over.line();
        System.out.print("Enter a new password: ");
        String newPassword = scn.nextLine();
        over.line();
        
        System.out.println("Account created successfully for username: " + newUsername);
        
    }
        public static void afterLogin() {
        System.out.println("Welcome! You are now logged in.");

        System.out.println("Select an option:");
        System.out.println("1. View profile");
        System.out.println("2. Modify settings");
        System.out.println("3. Logout");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Viewing profile...");

                break;
            case 2:
                System.out.println("Modifying settings...");

                break;
            case 3:
                System.out.println("Logging out...");

                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }
        

}
