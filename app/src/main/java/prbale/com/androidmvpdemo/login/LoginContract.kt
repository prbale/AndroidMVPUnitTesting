package prbale.com.androidmvpdemo.login

interface LoginContract {

  // View Interface
  interface View {
    fun getUsername(): String
    fun getPassword(): String
    fun showUsernameError()
    fun showPasswordError()
    fun startMainActivity()
    fun showLoginError()
  }

  // Presenter / Presentation Interface
  interface Presenter {
    fun doLogin()
  }

  // Model - Business Logic Interface
  interface Repository {
    fun login(username: String, password: String): Boolean
  }
}
