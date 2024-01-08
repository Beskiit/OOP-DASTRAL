package package1;

class HealthRecord {
    private String patientName;
    private int age;
    private String gender;
    private String allergies;
    private String medications;
    private String medicalHistory;

    public HealthRecord(String patientName, int age, String gender) {
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void displayHealthRecord() {
    	System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Patient Name        Age        Gender       Allergies      Medications     Medical History");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(patientName + "\t            " + age + "\t       " + gender + "\t      " + allergies + "\t       " +
        					medications + "\t        " + medicalHistory);
    }
}

