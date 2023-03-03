package authentication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Patient {
	private String name;
	private String password;
	private String patientID;
//	private String medicalRecord;
//	private ArrayList<String> prescription = new ArrayList<>();
	Map<String, ArrayList<String>> prescription = new HashMap<>(); //map date to prescription
	
	public Patient(String name, String password, String patientID) {
		this.name = name;
		this.password = password;
		this.patientID = patientID;
	}
	
	public void display() {
		System.out.println("Name: " + this.name);
		System.out.println("Password: " + this.password);
		System.out.println("PatientID: " + this.patientID);
	}
	public String getPatientName() {
		return this.name;
	}
	
	public void displayPrescription() {
		for (Map.Entry<String, ArrayList<String>> entry : this.prescription.entrySet()) {
			String date = entry.getKey();
			System.out.println(date);
			System.out.println("==================");
			ArrayList<String>  prescriptionData = entry.getValue();
			for (int i = 0; i < prescriptionData.size(); i++) {
				System.out.println(prescriptionData.get(i));
			}
			
		}
	}
	
	public ArrayList<String> getPriscription(String Date) {
		return this.prescription.get(Date);
	}
	
	public String getPatientID() {
		return this.patientID;
	}
	
	public void updatePrescription(String date, ArrayList<String> prescription) {
		this.prescription.put(date, prescription);
	}
	
	
}
