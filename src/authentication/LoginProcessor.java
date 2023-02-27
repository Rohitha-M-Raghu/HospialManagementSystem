package authentication;

public interface LoginProcessor {
	void register(String id, String name, String password);
	void login(String id, String password);
}
