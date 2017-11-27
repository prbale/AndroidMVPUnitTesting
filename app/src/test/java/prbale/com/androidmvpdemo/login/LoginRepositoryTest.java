package prbale.com.androidmvpdemo.login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Prashant on 27-11-2017.
 */
public class LoginRepositoryTest {

  private LoginRepository service;

  @Before public void setUp() {
    // Setup before test case execution
    service = new LoginRepository();
  }

  @After public void tearDown() {
    // Something to be done after test case executed.
  }

  @Test public void loginSuccessTest() {
    // Service call will return true as correct credentials are provided.
    // Test should PASS
    assertTrue(service.login("prashant", "bale"));
  }

  @Test public void loginFailureTest() {
    // Service call will return false as wrong credentials are provided.
    // Test should PASS as we are expecting false from service call.
    assertFalse(service.login("ajit", "bale"));
  }
}
