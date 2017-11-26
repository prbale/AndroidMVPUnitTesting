package prbale.com.androidmvpdemo.login;

public class LoginRepository implements LoginContract.Repository {
  /**
   * Repository method for login. Ideally from here we should make a request to backend
   * for login process. But for this demo, we will have some mock check inline.
   * @param username user name to validate
   * @param password password to validate
   * @return true is credentials matches with the "test/test" else false.
   */
  @Override public boolean login(String username, String password) {
    return "prashant".equals(username) && "bale".equals(password);
  }
}
