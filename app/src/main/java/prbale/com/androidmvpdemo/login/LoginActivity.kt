package prbale.com.androidmvpdemo.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_login.password
import kotlinx.android.synthetic.main.activity_login.username
import prbale.com.androidmvpdemo.R
import prbale.com.androidmvpdemo.extension.launchHomeScreen

class LoginActivity : AppCompatActivity(), LoginContract.View {

  private lateinit var presenter: LoginPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    // Create presenter also pass repository instance as a parameter.
    presenter = LoginPresenter(this, LoginRepository())
  }

  override fun getUsername(): String = username.text.toString()

  override fun getPassword(): String = password.text.toString()

  fun onLoginClicked(view: View) {
    presenter.doLogin()
  }

  override fun showUsernameError() {
    username.error = getString(R.string.error_msg_username_missing)
  }

  override fun showPasswordError() {
    password.error = getString(R.string.error_msg_password_missing)
  }

  override fun startMainActivity() {
    launchHomeScreen()
  }

  override fun showLoginError() {
    Toast.makeText(this, getString(R.string.error_msg_login_failed), LENGTH_SHORT).show()
  }
}
