package ac.za.mycput.security;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String email, String password);
}
