package appointments;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.*;

public class AppointmentHandling {
	
	private static Map<String, ArrayList<String>> doctorsAvailable = new HashMap<>(); //Mapping  Date to Doctors Array
	private static Map<String, Queue<PatientToken>> patientWaiting = new HashMap<>(); //Mapping Doctor to PatientWaitingQueue
	
	public static ArrayList<String> getDoctorsAvailable(String date) {
		return doctorsAvailable.get(date);
	}
	
	public static boolean checkDoctorAvailablilty(String date, String name) {
		ArrayList<String> doctors = new ArrayList<>();
		doctors = doctorsAvailable.get(date);
		if(doctors.contains(name)) {
			return true;
		}
		return false;
	}
	
	public static void setAppointment(String patientName, String doctorName, String patientID) {
		patientWaiting.get(doctorName).add(new PatientToken(patientName, patientID));
	}
	
	public static void doctorCheckIn(String doctorName) {
		if(patientWaiting.containsKey(doctorName)){
			System.out.println("Already Checked-in");
		}
		else {
			Scanner scanner = new Scanner(System.in);
			patientWaiting.put(doctorName, new PriorityQueue<>()); //move to another function later
			System.out.print("Enter Date: ");
			String date = scanner.next();
			if(doctorsAvailable.containsKey(date)) {
				doctorsAvailable.get(date).add(doctorName);
			}
			else {
				doctorsAvailable.put(date, new ArrayList<>());
				doctorsAvailable.get(date).add(doctorName);
			}
			System.out.println("Checked-in Successfully");
		}
	}
	
	public static void viewWaitingPatients(String doctorName) {
		int i=0;
		if(patientWaiting.get(doctorName).isEmpty()) {
			System.out.println("No patients Waiting...");
		}
		else {
			System.out.println("Patient Waiting List");
			System.out.println("======================");
			for(PatientToken patient:patientWaiting.get(doctorName)) {
				System.out.println(i + "\t" + patient.getToken() + "\t" + patient.getPatientName());
				i++;
			}
		}
	}
	
	public static PatientToken getFirstPatient(String doctorName) {
		try {
			PatientToken firstPatient = patientWaiting.get(doctorName).element(); 
			patientWaiting.get(doctorName).remove();
			return firstPatient;
		}
		catch(Exception e) {
			return null;
		}		
	}
	
	public static void checkOutDoctor(String doctorName) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter date: ");
		String date = scanner.next();
		doctorsAvailable.get(date).remove(doctorName);
		patientWaiting.remove(doctorName);
		System.out.println("Checked-out Successfully...");
	}
}
