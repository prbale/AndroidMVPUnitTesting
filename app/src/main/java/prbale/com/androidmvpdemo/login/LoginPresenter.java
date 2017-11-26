package prbale.com.androidmvpdemo.login;

public class LoginPresenter implements LoginContract.Presenter {
  private LoginContract.View view;
  private LoginRepository repository;

  /**
   * Constructor
   * @param view View with which this presenter is connected.
   * @param repository Repository instance which will be responsible for business logic.
   */
  public LoginPresenter(LoginContract.View view, LoginRepository repository) {
    this.view = view;
    this.repository = repository;
  }

  /**
   * Method which will interact with repository for login process.
   * It will get the username and password from view and pass it to repository.
   */
  @Override public void doLogin() {
    String username = view.getUsername();
    if (username.isEmpty()) {
      view.showUsernameError();
      return;
    }
    String password = view.getPassword();
    if (password.isEmpty()) {
      view.showPasswordError();
      return;
    }
    boolean loginSucceeded = repository.login(username, password);
    if (loginSucceeded) {
      view.startMainActivity();
      return;
    }
    view.showLoginError();
  }
}
