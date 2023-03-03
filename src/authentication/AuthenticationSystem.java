package authentication;
import java.util.Scanner;
import main_system.HospitalManagement;

public class AuthenticationSystem {
	private final LoginProcessor loginProcessor;
	
	public AuthenticationSystem(LoginProcessor loginProcessor) {
		this.loginProcessor = loginProcessor;
	}
	public void newRegistrationManager(String id, String name, String password) {
		loginProcessor.register(id, name, password);
		HospitalManagement.HomeMenu();
	}
	public void loginManager(String id, String password) {
		loginProcessor.login(id, password);
		HospitalManagement.HomeMenu();
	}	
}
