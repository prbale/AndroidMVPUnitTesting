package prbale.com.androidmvpdemo.login

/**
 * set class as "Open" just because need to run the unit test cases.
 * TODO: Need to solve the issue. Making open is not the right way to achieve this.
 */
open class LoginRepository : LoginContract.Repository {
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
