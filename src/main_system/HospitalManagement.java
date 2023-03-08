package main_system;
import java.util.Scanner;



import authentication.*;
import authentication.AuthenticationSystem;
import in_patient_management.BedManagement;

public class HospitalManagement {
	public static BedManagement bedManagement = new BedManagement();
	public static void main(String[] args) {
		HomeMenu();
	}
	
	public static void HomeMenu() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nWelcome to Hospital Managment...");
		System.out.println("==========================");
		System.out.println("1. Login");
		System.out.println("2. New Registration");
		System.out.println("3. Exit");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		switch(choice) {
			case 1: HospitalManagement.login();
				break;
			case 2: HospitalManagement.register();
				break;
			case 3:	System.out.println("Quitting....");
					System.exit(0);
					break;
			default:System.out.println("Wrong Choice...");
		}
		
	}
	
	private static void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ID: ");
		String id = scanner.next();
		System.out.print("Enter Password: ");
		String password = scanner.next();
		if(id.startsWith("P")) {
			LoginProcessor patientlogin = new PatientManagement();
			AuthenticationSystem patientAuthentication = new AuthenticationSystem(patientlogin);
			patientAuthentication.loginManager(id,password);
		}
		else {
			LoginProcessor doctorLogin = new DoctorManagement();
			AuthenticationSystem doctorAuthentication = new AuthenticationSystem(doctorLogin);
			doctorAuthentication.loginManager(id, password);
		}
	}
	
	private static void register() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String name = scanner.next();
		System.out.print("Enter ID: ");
		String newID = scanner.next();
		System.out.print("Enter password: ");
		String newPassword = scanner.next();
		if(newID.startsWith("P")) {
			LoginProcessor patientlogin = new PatientManagement();
			AuthenticationSystem patientAuthentication = new AuthenticationSystem(patientlogin);
			patientAuthentication.newRegistrationManager(newID, name, newPassword);
		}
		else {
			LoginProcessor doctorLogin = new DoctorManagement();
			AuthenticationSystem doctorAuthentication = new AuthenticationSystem(doctorLogin);
			doctorAuthentication.newRegistrationManager(newID, name, newPassword);
		}
	}
}
