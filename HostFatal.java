package DastralOOP;
import java.util.Scanner;

public class HostFatal extends Overriding{
	static Overriding over = new Overriding();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[]args) {
		
		over.name();
		loginProcess();
}      
        
        public static void loginProcess(){
		System.out.println ("1 - Log In");
		System.out.println ("2 - Sign up");
		int choice = sc.nextInt();
                over.line();
		if (choice == 1) {
                login();
                } else if (choice == 2) {
                signUp();
                } else {
                System.out.println("Invalid choice, Please enter 1 or 2 only.");
                }
        }
        
	public static void login() {
        System.out.print("Enter your username: ");
        String username = sc.next();
        
        System.out.print("Enter your password: ");
        String password = sc.next();
        

        
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful!");
            afterLogin();
            over.line();
        } else {
            System.out.println("Incorrect username or password.");
            over.line();
        }
    }
	public static void signUp() {
        Overriding over = new Overriding();
        System.out.print("Enter a new username: ");
        String newUsername = sc.nextLine();
        over.line();
        System.out.print("Enter a new password: ");
        String newPassword = sc.nextLine();
        
        System.out.println("Account created successfully for username: " + newUsername);
        over.line();
        
    }
        public static void afterLogin() {
        System.out.println("Welcome! You are now logged in.");

        System.out.println("Select an option:");
        System.out.println("1. View profile");
        System.out.println("2. Modify settings");
        System.out.println("3. Logout");

        int option = sc.nextInt();

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
