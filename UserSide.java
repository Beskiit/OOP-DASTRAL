package DastralOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserSide extends Admin {
    Map<String, List<String>> patientInfo = new TreeMap<>();
    int key = 1;
    Scanner sc = new Scanner(System.in);

    public void patientInfoFinal() {
        String patientKey = "PT - " + key;
        List<String> patientInformation = new ArrayList<>();

        System.out.println("Enter the name of patient: ");
        patientInformation.add("Patient Name: " + sc.nextLine());
        System.out.println("Enter the age of patient: ");
        patientInformation.add("Patient Age: " + sc.nextLine());
        System.out.println("Enter the gender of patient: ");
        patientInformation.add("Patient Gender: " + sc.nextLine());
        System.out.println("Enter the address of patient: ");
        patientInformation.add("Patient Address: " + sc.nextLine());
        System.out.println("Enter the room of patient: ");
        patientInformation.add("Patient Room: " + sc.nextLine());
        System.out.println("Enter the illness of patient: ");
        patientInformation.add("Patient Illness: " + sc.nextLine());
        System.out.println("Enter the doctor of patient: ");
        patientInformation.add("Patient Doctor: " + sc.nextLine());
        System.out.println("Enter the status of patient: ");
        patientInformation.add("Patient Status: " + sc.nextLine());

        patientInfo.put(patientKey, patientInformation);

        key++;
        System.out.println("Patient input done!");
        over.line();
    }

    public void healthRecord(){
        if (patientInfo.isEmpty()) {
            System.out.println("No patient yet.");
            over.line();
        }else{
            printMap(patientInfo);
            over.line();
        }
    }
    
    public void editKey() {
    	editKeyValues(patientInfo);
    }
    
    public void editKeyValues(Map<String, List<String>> map){
        System.out.print("Enter the patient ID you want to edit: ");
        String editPatient = sc.nextLine();
        
        if(map.containsKey(editPatient)){
            System.out.println("Current patient information of " + editPatient + ":");
            for (String value : map.get(editPatient)) {
                System.out.println("  " + value);
            }
            
            System.out.println("Enter the new patient information for " + editPatient);
            List<String> newPatientInfo = new ArrayList<>();
            
            System.out.println("Enter the name of patient: ");
            newPatientInfo.add("Patient Name: " + sc.nextLine());
            System.out.println("Enter the age of patient: ");
            newPatientInfo.add("Patient Age: " + sc.nextLine());
            System.out.println("Enter the gender of patient: ");
            newPatientInfo.add("Patient Gender: " + sc.nextLine());
            System.out.println("Enter the address of patient: ");
            newPatientInfo.add("Patient Address: " + sc.nextLine());
            System.out.println("Enter the room of patient: ");
            newPatientInfo.add("Patient Room: " + sc.nextLine());
            System.out.println("Enter the illness of patient: ");
            newPatientInfo.add("Patient Illness: " + sc.nextLine());
            System.out.println("Enter the doctor of patient: ");
            newPatientInfo.add("Patient Doctor: " + sc.nextLine());
            System.out.println("Enter the status of patient: ");
            newPatientInfo.add("Patient Status: " + sc.nextLine());
            
            map.put(editPatient, newPatientInfo);

            System.out.println("The patient information has been updated!");
        } else {
            System.out.println("Key not found. Please enter a valid key.");
        }
    }

    public void printMap(Map<String, List<String>> map){
        System.out.println("Current Patient: " + (key-1) + "\n");

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            String key = entry.getKey();
            List<String> values = entry.getValue();
            over.line();
            System.out.println("Key: " + key);
            for (String value : values) {
                System.out.println("  " + value);
            }
        }
    }
}