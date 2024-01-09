package DastralOOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HostFatal extends Admin{
	static Overriding over = new Overriding();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[]args)throws InputMismatchException {
		try {
			Admin.startProgram();
		}catch(InputMismatchException ioe) {
			ioe.getMessage();
		}
	}
}
