package prbale.com.androidmvpdemo.login;

public interface LoginContract {

  // View Interface
  interface View {
    String getUsername();
    void showUsernameError(int resId);
    String getPassword();
    void showPasswordError(int resId);
    void startMainActivity();
    void showLoginError(int resId);
  }

  // Presenter / Presentation Interface
  interface Presenter {
    void onLoginClicked();
  }

  // Model - Business Logic Interface
  interface Repository {
    boolean login(String username, String password);
  }
}
