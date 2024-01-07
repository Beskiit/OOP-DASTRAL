package DastralOOP;
import java.util.Scanner;

public class HostFatal extends Overriding{
	public static void main(String[]args) {
		Overriding over = new Overriding();
		
		over.name();
        Scanner scn = new Scanner(System.in);
		System.out.println ("Do you want to:");
		System.out.println ("1. Log In");
		System.out.println ("2. Sign up");
		System.out.println ("Enter your choice (1 or 2):");

		int choice = scn.nextInt();

		if (choice == 1) {
                login();
                } else if (choice == 2) {
                signUp();
                } else {
                System.out.println("Invalid choice, Please enter 1 or 2 only.");
        }      
	}
	public static void login() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scn.nextLine();
        System.out.println("Enter your password: ");
        String password = scn.nextLine();

        
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful!");
            
        } else {
            System.out.println("Incorrect username or password.");
        }
    }
	public static void signUp() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a new username: ");
        String newUsername = scn.nextLine();
        System.out.println("Enter a new password: ");
        String newPassword = scn.nextLine();

        
        System.out.println("Account created successfully for username: " + newUsername);
        
    }
	
}
