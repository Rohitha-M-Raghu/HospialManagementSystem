package authentication;

import java.util.HashMap;

import patient_account.*;
import java.util.Map;

import main_system.HospitalManagement;
import patient_account.PatientAccount;

public class PatientManagement implements LoginProcessor{
	private static Map<String, String> patientLogin = new HashMap<>(); // mapping patientID to password
	private static Map<String, Patient> patientRecords = new HashMap<>(); // mapping ID to Patient 
	public PatientManagement() {
		System.out.println("Patient Management System");
	}

	@Override
	public void register(String id, String name, String password) {
		System.out.println("\nRegistering a Patient");
		patientLogin.put(id, password);
		patientRecords.put(id, new Patient(name, password, id));
		System.out.println("Registered Patient " + id + " successfully!!!");
	}

	@Override
	public void login(String id, String password) {
		if (!patientLogin.containsKey(id)) {
			System.out.println("Invalid Patient ID");
		}
		else if (patientLogin.get(id).equals(password)) { 
			System.out.println("Patient "+ id +" logged in Succesfully...");
			PatientAccount patientAccount = new PatientAccount(patientRecords.get(id));
			//logging out
			
		}
		else {
			System.out.println("Wrong password...");
		}
	}
	
	
	public static Patient getPatientRecords(String id) { //return Patient Object
		return patientRecords.get(id);
	}
}
