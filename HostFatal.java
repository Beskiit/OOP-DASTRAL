package DastralOOP;
import Java.util.Scanner;

public class HostFatal extends Overriding{
	public static void main(String[]args) {
		Overriding over = new Overriding();
		
		over.name();
	}
	{
	Scanner scn = new Scanner(System.in);

		System.out.println("Welcome!");
		System.out.println ("Do you want to:");
		System.out.println ("1. Log In");
		System.out.println ("2. Sign up");
		System.out.println ("Enter your choice (1 or 2):");

		int choice = scn.nextInt();

		if(choice == 1){
			System.out.println("You chose to log in.");
		}else if (choice == 2){
			System.out.println("You chose to sign up.");
		}else {
			System.out.println("Invalid choice, Please enter 1 or 2 only.");
		}
	}
}
}
