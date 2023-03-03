package authentication;

public class Doctor {
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
	
	public String getName() {
		return name;
	}
}
