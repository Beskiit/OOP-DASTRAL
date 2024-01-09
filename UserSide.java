package DastralOOP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserSide extends Admin{
    Map<String, List<String>> patientInfo = new TreeMap<>();
    static Map<String, Double> patientBalances = new HashMap<>();
    int key = 1;
    Scanner sc = new Scanner(System.in);

    public void patientInfoFinal() {
    	over.addPatientRecord();
        String patientKey = "PT - " + key;
        List<String> patientInformation = new ArrayList<>();

        System.out.print("\t \t \t \t \t \t \t Enter the name of patient: ");
        patientInformation.add("Patient Name: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the age of patient: ");
        patientInformation.add("Patient Age: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the gender of patient: ");
        patientInformation.add("Patient Gender: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the address of patient: ");
        patientInformation.add("Patient Address: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the room of patient: ");
        patientInformation.add("Patient Room: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the illness of patient: ");
        patientInformation.add("Patient Illness: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the doctor of patient: ");
        patientInformation.add("Patient Doctor: " + sc.nextLine());
        System.out.print("\t \t \t \t \t \t \t Enter the status of patient: ");
        patientInformation.add("Patient Status: " + sc.nextLine());

        patientInfo.put(patientKey, patientInformation);
        patientBalances.put(patientKey, 0.0);

        key++;
        System.out.println("\t \t \t \t \t \t \t Patient input done!");
    }

    public void healthRecord(){
    	over.viewPatientRecord();
        if (patientInfo.isEmpty()) {
            System.out.println("\t \t \t \t \t \t \t No patient yet.");
        }else{
            printPatient(patientInfo);
        }
    }
    
    public void editKey() {
    	editKeyValues(patientInfo);
    }
    
    public void editKeyValues(Map<String, List<String>> map){
    	over.editPatientRecord();
        System.out.print("\t \t \t \t \t \t \t Enter the patient ID you want to edit: ");
        String editPatient = sc.nextLine();
        over.line();
        if(map.containsKey(editPatient)){
            System.out.println("\t \t \t \t \t \t \t Current patient information of " + editPatient + ":");
            for (String value : map.get(editPatient)) {
                System.out.println("\t \t \t \t \t \t \t " + value);
            }
            over.line();
            System.out.println("\t \t \t \t \t \t \t Enter the new patient information for " + editPatient);
            List<String> newPatientInfo = new ArrayList<>();
            
            System.out.print("\t \t \t \t \t \t \t Enter the name of patient: ");
            newPatientInfo.add("Patient Name: " + sc.nextLine());
            System.out.print("\t \t \t \t \t \t \t Enter the age of patient: ");
            newPatientInfo.add("Patient Age: " + sc.nextLine());
            System.out.print("\t \t \t \t \t \t \t Enter the gender of patient: ");
            newPatientInfo.add("Patient Gender: " + sc.nextLine());
            System.out.print("\t \t \t \t \t \t \t Enter the address of patient: ");
            newPatientInfo.add("Patient Address: " + sc.nextLine());
            System.out.print("\t \t \t \t \t \t \t Enter the room of patient: ");
            newPatientInfo.add("Patient Room: " + sc.nextLine());
            System.out.print("\t \t \t \t \t \t \t Enter the illness of patient: ");
            newPatientInfo.add("Patient Illness: " + sc.nextLine());
            System.out.print("\t \t \t \t \t \t \t Enter the doctor of patient: ");
            newPatientInfo.add("Patient Doctor: " + sc.nextLine());
            System.out.print("\t \t \t \t \t \t \t Enter the status of patient: ");
            newPatientInfo.add("Patient Status: " + sc.nextLine());
            
            map.put(editPatient, newPatientInfo);

            System.out.println("\t \t \t \t \t \t \t The patient information has been updated!");
            over.line();
        } else {
            System.out.println("\t \t \t \t \t \t \t Key not found. Please enter a valid key.");
        }
    }

    public void printPatient(Map<String, List<String>> map){
        System.out.println("\t \t \t \t \t \t \t Current Patient: " + (key-1) + "\n");

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            String key = entry.getKey();
            List<String> values = entry.getValue();
            over.line();
            System.out.println("\t \t \t \t \t \t \t Patient ID: " + key);
            for (String value : values) {
                System.out.println("\t \t \t \t \t \t \t " + value);
            }
        }
    }
    
    public static void viewBalances() {
        System.out.println("\t \t \t \t \t \t \t Patient Balances:");
        for (Map.Entry<String, Double> entry : patientBalances.entrySet()) {
            String patientID = entry.getKey();
            Double balance = entry.getValue();
            System.out.println("\t \t \t \t \t \t \t Patient ID: " + patientID + ", Balance: " + balance);
        }
    }
}
