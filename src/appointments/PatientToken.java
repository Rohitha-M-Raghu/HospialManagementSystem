package appointments;

public class PatientToken {
	private static float numberOfTokens = 0;
	private String token;
	private String id;
	private String name;
	
	public PatientToken(String name, String id) {
		PatientToken.numberOfTokens ++;
		this.token = "P".concat(String.valueOf(numberOfTokens));
		this.name = name;
		this.id = id;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public String getPatientName() {
		return name;
	}
	
	public String getPatientID() {
		return id;
	}
}
