package patient_account;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;

import authentication.*;
import appointments.*;

public class PatientAccount {
	Patient patient;
	public PatientAccount(Patient patient) {
		this.patient = patient;
		this.Patientmenu();
	}
	
	public void Patientmenu() {
		int choice = 0;
		while(choice != 5) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Patient Menu");
			System.out.println("---------------");
			System.out.println("1. Get Doctor's Appointment");
			System.out.println("2. View Available Doctors");
			System.out.println("3. Access My Medical Records");
			System.out.println("4. Medicine from Pharmacy");
			System.out.println("5. Logout");
			// 5. Cancel Appointment
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			
			switch(choice) {
				case 1: this.getAppointment();
						break;
				case 2: this.viewAvailableDoctors();
						break;
				case 3: this.accessMedicalRecords();
						break;
				case 4: this.getMedicine();
						break;
				case 5: System.out.println("Logging Out...");
						break;
				default: System.out.println("Wrong Choice");
			}
			
		}
	}
	
	public String viewAvailableDoctors() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date: ");
		String date = scanner.next();
		
		try {
			ArrayList<String> doctorList = new ArrayList<>();
			doctorList = AppointmentHandling.getDoctorsAvailable(date);
			
			System.out.println("Available Doctors");
			System.out.println("----------------------");
			for (int i = 0; i < doctorList.size(); i++) {
				System.out.println(doctorList.get(i));
			
				}
			return date;
		}
		catch(Exception e) {
			System.out.println("No doctors Available...");
			return null;
		}
		
	}
	
	public void getAppointment() {
		Scanner scanner = new Scanner(System.in);
		String date = this.viewAvailableDoctors();
		try {
			if(date.isEmpty()) {
				return;
			}
		}
		catch(Exception e) {
			System.out.println("Try Again Later...");
			return;
		}
		System.out.println("Enter the doctor's name: ");
		String doctorName = scanner.next();
		if(AppointmentHandling.checkDoctorAvailablilty(date, doctorName)) {
			AppointmentHandling.setAppointment(patient.getPatientName(), doctorName, patient.getPatientID());
		}
		else {
			System.out.println("Doctor Not Available...");
		}
		
	}
	
	public void accessMedicalRecords() {
		patient.displayPrescription();
	}
	
	public void getMedicine() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter date: ");
		String dateOfPrescription = scanner.next();
		patient.getPriscription(dateOfPrescription);
		//MODIFY
		System.out.println("Medicines obtained...");
	}
}
