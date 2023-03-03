package authentication;

import java.util.HashMap;
import java.util.Map;

import appointments.AppointmentHandling;
import doctor_account.DoctorAccount;

public class DoctorManagement implements LoginProcessor{
	private static Map<String, String> doctorLogin = new HashMap<>(); // mapping doctorID to password
	private static Map<String, Doctor> doctorRecords = new HashMap<>(); // mapping ID to Doctor
	
	public DoctorManagement() {
		System.out.println("Doctor Management System");
	}

	@Override
	public void register(String id, String name, String password) {
		System.out.println("\nRegistering a Doctor...");
		doctorLogin.put(id, password);
		doctorRecords.put(id, new Doctor(name, password, id));
		System.out.println("Registerd Doctor " + id + " successfully!!!");
	}

	@Override
	public void login(String id, String password) {
		if(!doctorLogin.containsKey(id)) {
			System.out.println("Invalid Patient ID");
		}
		else if(doctorLogin.get(id).equals(password)) {
			System.out.println("Doctor"+ id +" logged in Succesfully...");
			DoctorAccount doctorAccount = new DoctorAccount(doctorRecords.get(id));
			//logging out...
			
			AppointmentHandling.checkOutDoctor(doctorAccount.getDoctor().getName());
		}
		else {
			System.out.println("Wrong password...");
		}
	}
	
	public static void display() {
		System.out.println(doctorLogin);
	}

}
