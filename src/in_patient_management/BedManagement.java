package in_patient_management;

import java.util.HashMap;
import java.util.Map;

public class BedManagement {
	private Map<Integer, String> bedToPatientMapping;
	private final int numberOfBeds = 100; //  101 - 200
	private int numberOfAvailableBeds;
	
	public BedManagement() {
		bedToPatientMapping = new HashMap<>();
		numberOfAvailableBeds = 100;
	}
	public boolean checkAvailability(int bedNumber) {
		if(bedToPatientMapping.containsKey(bedNumber)) {
			return false;
		}
		return true;
	}
	
	public void admitPatient(String patientID) {
		if(numberOfAvailableBeds == 0) {
			System.out.println("Sorry... No Beds Available");
			return;
		}
		for(int bedNumber = 100; bedNumber <= 200; bedNumber++) {
			if(this.checkAvailability(bedNumber)) {
				bedToPatientMapping.put(bedNumber, patientID);
				numberOfAvailableBeds --;
				return;
			}
		}
	}
	
	public void dischargePatient(String patientID) {
		if(!bedToPatientMapping.containsValue(patientID)) {
			System.out.println("Patient Not Found!!!");
			return;
		}
		for(int bedNumber: bedToPatientMapping.keySet()) {
			if(bedToPatientMapping.get(bedNumber).equals(patientID)) {
				bedToPatientMapping.remove(bedNumber);
				numberOfAvailableBeds --;
				return;
			}
		}
	}
}
