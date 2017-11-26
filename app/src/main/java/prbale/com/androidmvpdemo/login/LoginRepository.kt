package prbale.com.androidmvpdemo.login

class LoginRepository : LoginContract.Repository {
  /**
   * Repository method for login. Ideally from here we should make a request to backend
   * for login process. But for this demo, we will have some mock check inline.
   * @param username user name to validate
   * @param password password to validate
   * @return true is credentials matches with the "test/test" else false.
   */
  override fun login(username: String, password: String): Boolean =
    "prashant" == username && "bale" == password

}
