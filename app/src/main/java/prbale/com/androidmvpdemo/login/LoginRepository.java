package prbale.com.androidmvpdemo.login;

public class LoginRepository implements LoginContract.Repository {
  @Override public boolean login(String username, String password) {
    return "test".equals(username) && "test".equals(password);
  }
}
