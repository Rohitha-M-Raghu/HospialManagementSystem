package authentication;
import java.util.Scanner;

class Patient {
	private String name;
	private String password;
	private String patientID;
	
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
	
}

class Doctor {
	private String name;
	private String doctorID;
	
	public Doctor(String name, String password, String doctorID) {
		this.name = name;
		this.doctorID = doctorID;
	}
	
	public void display() {
		System.out.println("Name: " + this.name);
		System.out.println("DoctorID: " + this.doctorID);
	}
	
}
//public interface LoginProcessor {
//	void register(String id, String name, String password);
//	void login(String id, String password);
//}

//class DoctorManagement implements LoginProcessor{
//	private Map<String, String> doctorLogin = new HashMap<>(); // mapping doctorID to password
//	private Map<String, Doctor> doctorRecords = new HashMap<>(); // mapping ID to Doctor
//	
//	public DoctorManagement() {
//		System.out.println("Doctor Management System");
//	}
//
//	@Override
//	public void register(String id, String name, String password) {
//		System.out.println("\nRegistering a Doctor...");
//		doctorLogin.put(id, password);
//		doctorRecords.put(id, new Doctor(name, password, id));
//		System.out.println("Registerd Doctor " + id + " successfully!!!");
//	}
//
//	@Override
//	public void login(String id, String password) {
//		if(!doctorLogin.containsKey(id)) {
//			System.out.println("Invalid Patient ID");
//		}
//		else if(doctorLogin.get(id).equals(password)) {
//			System.out.println("Doctor"+ id +" logged in Succesfully...");
//		}
//		else {
//			System.out.println("Wrong password...");
//		}
//	}
//	
//}

//class PatientManagement implements LoginProcessor{
//	private Map<String, String> patientLogin = new HashMap<>(); // mapping patientID to password
//	private Map<String, Patient> patientRecords = new HashMap<>(); // mapping ID to Patient 
//	public PatientManagement() {
//		System.out.println("Patient Management System");
//	}
//
//	@Override
//	public void register(String id, String name, String password) {
//		System.out.println("\nRegistering a Patient");
//		patientLogin.put(id, password);
//		patientRecords.put(id, new Patient(name, password, id));
//		System.out.println("Registered Patient " + id + " successfully!!!");
//	}
//
//	@Override
//	public void login(String id, String password) {
//		if (!patientLogin.containsKey(id)) {
//			System.out.println("Invalid Patient ID");
//		}
//		else if (patientLogin.get(id).equals(password)) { 
//			System.out.println("Patient "+ id +" logged in Succesfully...");
//		}
//		else {
//			System.out.println("Wrong password...");
//		}
//	}
//	
//}

public class AuthenticationSystem {
	private final LoginProcessor loginProcessor;
	
	public AuthenticationSystem(LoginProcessor loginProcessor) {
		this.loginProcessor = loginProcessor;
	}
	public void newRegistrationManager(String id, String name, String password) {
		loginProcessor.register(id, name, password);
	}
	public void loginManager(String id, String password) {
		loginProcessor.login(id, password);
	}	
//	public static void main(String[] args) {
//		LoginProcessor patientlogin = new PatientManagement();
//		AuthenticationSystem hm = new AuthenticationSystem(patientlogin);
//		hm.newRegistrationManager();
//		
//		LoginProcessor doctorlogin = new DoctorManagement();
//		AuthenticationSystem hm2 = new AuthenticationSystem(doctorlogin);
//		hm2.newRegistrationManager();
//		
//		hm.loginManager();
//	
//	}

}
