package prbale.com.androidmvpdemo.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import prbale.com.androidmvpdemo.R;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

  @Mock
  private LoginContract.View view;

  @Mock
  private LoginRepository service;

  private LoginPresenter presenter;

  @Before
  public void setUp() throws Exception {
    presenter = new LoginPresenter(view, service);
  }

  @Test
  public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception {
    when(view.getUsername()).thenReturn("");
    presenter.doLogin();
    verify(view).showUsernameError();
  }

  @Test
  public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
    when(view.getUsername()).thenReturn("prashant");
    when(view.getPassword()).thenReturn("");
    presenter.doLogin();
    verify(view).showPasswordError();
  }

  @Test
  public void shouldStartMainActivityWhenUsernameAndPasswordAreCorrect() throws Exception {
    when(view.getUsername()).thenReturn("prashant");
    when(view.getPassword()).thenReturn("bale");
    when(service.login("prashant", "bale")).thenReturn(true);
    presenter.doLogin();

    verify(view).startMainActivity();
  }

  @Test
  public void shouldShowLoginErrorWhenUsernameAndPasswordAreInvalid() throws Exception {
    when(view.getUsername()).thenReturn("prashant");
    when(view.getPassword()).thenReturn("bale");
    when(service.login("prashant1", "bale1")).thenReturn(false);
    presenter.doLogin();

    verify(view).showLoginError();
  }
}