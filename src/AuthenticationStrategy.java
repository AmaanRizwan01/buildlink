public interface AuthenticationStrategy {
    public boolean authenticate(String email, String password);
    public boolean authenticateLogin(String email, String password);
    public boolean authenticateAnswer(String email, String password);
}