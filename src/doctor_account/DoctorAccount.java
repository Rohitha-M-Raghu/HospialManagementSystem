package doctor_account;
import java.util.ArrayList;

import java.util.Scanner;
import authentication.PatientManagement;

import authentication.Doctor;
import authentication.Patient;
import appointments.*;
import main_system.HospitalManagement;

public class DoctorAccount {
	Doctor doctor;
	public DoctorAccount(Doctor doctor) {
		this.doctor = doctor;
		this.doctorMenu();
	}
	
	public void doctorMenu() {
		int choice = 0;
		while(choice != 9) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nDoctor Menu");
			System.out.println("---------------");
			System.out.println("1. Check-in");
			System.out.println("2. View My Patients");
			System.out.println("3. Consult Patients");
			System.out.println("4. View Patient Records");
			System.out.println("5. Write Prescription");
			System.out.println("6. Admit Patient");
			System.out.println("7. Discharge Patient");
			System.out.println("8. Check-out");
			System.out.println("9. Logout");
			// 7. Cancel Appointment
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			
			switch(choice) {
				case 1: AppointmentHandling.doctorCheckIn(doctor.getName());
						break;
				case 2: AppointmentHandling.viewWaitingPatients(doctor.getName());
						break;
				case 3: this.consultPatients();
						break;
				case 4: System.out.println("Enter PatientID: ");
				        String patientID = scanner.next();
						viewPatientRecords(patientID);
						break;
				case 5: this.writePriscriptionForPatient();
						break;
				case 6: this.admittingPatient();
						break;
				case 7: this.dischargingPatient();
						break;
				case 8: AppointmentHandling.checkOutDoctor(doctor.getName());
						break;
				case 9: System.out.println("Logging Out...");
						break;
				default: System.out.println("Wrong Choice");
			}
			
		}
	}
	public void consultPatients() {
		PatientToken consultingPatient = AppointmentHandling.getFirstPatient(doctor.getName());
		if(consultingPatient == null) {
			System.out.println("No Patient...");
			return;
		}
		System.out.println("Consulting Patient" +consultingPatient.getPatientName()+ "...");
		this.viewPatientRecords(consultingPatient.getPatientID());
		
		
	}
		//TODO
	public void viewPatientRecords(String patientID) {
		try {
			Patient patientDetails = PatientManagement.getPatientRecords(patientID);
			System.out.println("Patient Details");
			System.out.println("--------------------");
			patientDetails.displayPrescription();
		}
		catch(Exception e) {
			System.out.println("No Such Patient Available...");
		}
	}
	
	public void writePriscriptionForPatient() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter patientID: ");
		String patientID = scanner.next();
		System.out.print("Enter date: ");
		String date = scanner.next();
		ArrayList<String> prescription = new ArrayList<>();
		char choice = 'y';
		while(choice == 'y') {
			System.out.print("Enter presciption: ");
			prescription.add(scanner.next());
			System.out.print("Do you want to add more(y/n): ");
			choice = scanner.next().charAt(0);
		}
		try {
			PatientManagement.getPatientRecords(patientID).updatePrescription(date, prescription);
		}
		catch(Exception e) {
			System.out.println("Invalid Patient ID...");
		}
		
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void admittingPatient() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter patientID: ");
		String patientID = scanner.next();
		HospitalManagement.bedManagement.admitPatient(patientID);
	}
	
	public void dischargingPatient() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter patientID: ");
		String patientID = scanner.next();
		HospitalManagement.bedManagement.admitPatient(patientID);
	}
	
}
