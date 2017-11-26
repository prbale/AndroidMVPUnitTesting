package prbale.com.androidmvpdemo.login;

import prbale.com.androidmvpdemo.R;

public class LoginPresenter implements LoginContract.Presenter {
  private LoginContract.View view;
  private LoginRepository repository;

  public LoginPresenter(LoginContract.View view, LoginRepository repository) {
    this.view = view;
    this.repository = repository;
  }

  @Override public void onLoginClicked() {
    String username = view.getUsername();
    if (username.isEmpty()) {
      view.showUsernameError(R.string.username_error);
      return;
    }
    String password = view.getPassword();
    if (password.isEmpty()) {
      view.showPasswordError(R.string.password_error);
      return;
    }
    boolean loginSucceeded = repository.login(username, password);
    if (loginSucceeded) {
      view.startMainActivity();
      return;
    }
    view.showLoginError(R.string.login_failed);
  }


}
