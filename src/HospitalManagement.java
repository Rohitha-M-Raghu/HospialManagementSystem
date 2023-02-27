import java.util.Scanner;


import authentication.*;
import authentication.AuthenticationSystem;

public class HospitalManagement {
	public static void main(String[] args) {
		int choice;
		HomeMenu();
		PatientManagement.display();
		HomeMenu();
		DoctorManagement.display();
		HomeMenu();
		PatientManagement.display();
		
	}
	
	private static void HomeMenu() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Hospital Managment...");
		System.out.println("==========================");
		System.out.println("1. Login");
		System.out.println("2. New Registration");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		switch(choice) {
			case 1:System.out.print("Enter ID: ");
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
				break;
			case 2:System.out.print("Enter Name: ");
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
				break;
			default:System.out.println("Wrong Choice...");
		}
		
	}
}
