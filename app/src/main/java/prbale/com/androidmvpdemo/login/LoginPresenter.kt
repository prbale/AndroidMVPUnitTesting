package prbale.com.androidmvpdemo.login

/**
 * Primary Constructor
 * @param view View with which this presenter is connected.
 * @param repository Repository instance which will be responsible for business logic.
 */
class LoginPresenter(
    private val view: LoginContract.View,
    private val repository: LoginRepository) : LoginContract.Presenter {

  /**
   * Method which will interact with repository for login process.
   * It will get the username and password from view and pass it to repository.
   */
  override fun doLogin() {
    val username = view.getUsername()
    if (username.isEmpty()) {
      view.showUsernameError()
      return
    }
    val password = view.getPassword()
    if (password.isEmpty()) {
      view.showPasswordError()
      return
    }
    val loginSucceeded = repository.login(username, password)
    if (loginSucceeded) {
      view.startMainActivity()
    }
    else {
      view.showLoginError()
    }
  }
}
