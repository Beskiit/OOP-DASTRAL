package DastralOOP;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Doctors extends UserSide {

    private static int doctorCounter = 6;
    private static Scanner sc = new Scanner(System.in);
    
    public static void doctorOptions() {
        boolean cont = true;
        Map<String, Doctor> doctorMap = new TreeMap<>();

        while(cont){
        	over.doctors();
            System.out.println("\t \t \t \t \t \t \t [1] View doctors");
            System.out.println("\t \t \t \t \t \t \t [2] Add doctor");
            System.out.println("\t \t \t \t \t \t \t [3] Back");
            System.out.print("\t \t \t \t \t \t \t Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\t \t \t \t \t \t \t Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                	defaultDoctors(doctorMap);
                    printDoctorInformation(doctorMap);
                    break;
                case 2:
                    addDoctor(doctorMap);
                    break;
                case 3:
                    Admin.userInside();
                    cont = false;
                    break;
                default:
                    System.out.println("\t \t \t \t \t \t \t Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void printDoctorInformation(Map<String, Doctor> doctorMap) {
        over.viewDoctors();
        for (Map.Entry<String, Doctor> entry : doctorMap.entrySet()) {
            String doctorID = entry.getKey();
            Doctor doctorInfo = entry.getValue();
            
            System.out.println("\t \t \t \t \t \t \t Doctor ID: " + doctorID);
            System.out.println("\t \t \t \t \t \t \t Doctor: " + doctorInfo.getName());
            System.out.println("\t \t \t \t \t \t \t Expertise: " + doctorInfo.getExpertise());
            System.out.println("\t \t \t \t \t \t \t Schedule: " + doctorInfo.getSchedule());
            System.out.println();
            over.line();
        }
    }

    public static void defaultDoctors(Map<String, Doctor> doctorMap) {
        doctorMap.put("DOC-1", new Doctor("Dr. Smith", "Cardiology", "Monday, Wednesday, Friday"));
        doctorMap.put("DOC-2", new Doctor("Dr. Johnson", "Orthopedics", "Tuesday, Thursday"));
        doctorMap.put("DOC-3", new Doctor("Dr. Davis", "Pediatrics", "Monday, Friday"));
        doctorMap.put("DOC-4", new Doctor("Dr. Williams", "Dermatology", "Wednesday, Thursday"));
        doctorMap.put("DOC-5", new Doctor("Dr. Brown", "Internal Medicine", "Monday, Tuesday, Thursday"));
    }

    public static void addDoctor(Map<String, Doctor> doctorMap) {
        over.addDoctor();
        System.out.println("\t \t \t \t \t \t \t Enter the name of the new doctor: ");
        String name = sc.nextLine();

        System.out.println("\t \t \t \t \t \t \t Enter the expertise of the new doctor: ");
        String expertise = sc.nextLine();

        System.out.println("\t \t \t \t \t \t \t Enter the schedule of the new doctor: ");
        String schedule = sc.nextLine();

        String doctorID = "DOC-" + doctorCounter;
        doctorMap.put(doctorID, new Doctor(name, expertise, schedule));

        doctorCounter++;

        System.out.println("\t \t \t \t \t \t \t New doctor added successfully!");
    }
}

class Doctor {
    private String name;
    private String expertise;
    private String schedule;

    public Doctor(String name, String expertise, String schedule) {
        this.name = name;
        this.expertise = expertise;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public String getSchedule() {
        return schedule;
    }
}

