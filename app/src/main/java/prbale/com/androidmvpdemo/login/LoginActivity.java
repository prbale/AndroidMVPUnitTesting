package prbale.com.androidmvpdemo.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import prbale.com.androidmvpdemo.ActivityUtil;
import prbale.com.androidmvpdemo.R;

import static android.widget.Toast.LENGTH_SHORT;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

  private EditText usernameView;
  private EditText passwordView;
  private LoginPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    usernameView = (EditText) findViewById(R.id.username);
    passwordView = (EditText) findViewById(R.id.password);

    // Create presenter also pass repository instance as a parameter.
    presenter = new LoginPresenter(this, new LoginRepository());
  }

  public void onLoginClicked(View view) {
    presenter.doLogin();
  }

  @Override
  public String getUsername() {
    return usernameView.getText().toString();
  }

  @Override
  public void showUsernameError() {
    usernameView.setError(getString(R.string.error_msg_username_missing));
  }

  @Override
  public String getPassword() {
    return passwordView.getText().toString();
  }

  @Override
  public void showPasswordError() {
    passwordView.setError(getString(R.string.error_msg_password_missing));
  }

  @Override
  public void startMainActivity() {
    new ActivityUtil(this).startMainActivity();
  }

  @Override
  public void showLoginError() {
    Toast.makeText(this, getString(R.string.error_msg_login_failed), LENGTH_SHORT).show();
  }
}
