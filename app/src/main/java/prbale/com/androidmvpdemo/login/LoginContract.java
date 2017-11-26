package prbale.com.androidmvpdemo.login;

public interface LoginContract {

  // View Interface
  interface View {
    String getUsername();
    void showUsernameError();
    String getPassword();
    void showPasswordError();
    void startMainActivity();
    void showLoginError();
  }

  // Presenter / Presentation Interface
  interface Presenter {
    void doLogin();
  }

  // Model - Business Logic Interface
  interface Repository {
    boolean login(String username, String password);
  }
}
