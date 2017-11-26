package prbale.com.androidmvpdemo.login

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

  @Mock
  private val view: LoginContract.View? = null

  @Mock
  private lateinit var service: LoginRepository

  private lateinit var presenter: LoginPresenter

  @Before
  @Throws(Exception::class)
  fun setUp() {
    presenter = LoginPresenter(view as LoginContract.View, service)
  }

  @Test
  fun shouldShowErrorMessageWhenUsernameIsEmpty() {
    `when`(view?.getUsername()).thenReturn("")
    presenter.doLogin()
    verify(view)?.showUsernameError()
  }

  @Test
  fun shouldShowErrorMessageWhenPasswordIsEmpty() {
    `when`(view?.getUsername()).thenReturn("prashant")
    `when`(view?.getPassword()).thenReturn("")
    presenter.doLogin()
    verify(view)?.showPasswordError()
  }

  @Test
  fun shouldStartMainActivityWhenUsernameAndPasswordAreCorrect() {
    `when`(view?.getUsername()).thenReturn("prashant")
    `when`(view?.getPassword()).thenReturn("bale")
    `when`(service.login("prashant", "bale")).thenReturn(true)
    presenter.doLogin()

    verify(view)?.startMainActivity()
  }

  @Test
  fun shouldShowLoginErrorWhenUsernameAndPasswordAreInvalid() {
    `when`(view?.getUsername()).thenReturn("prashant")
    `when`(view?.getPassword()).thenReturn("bale")
    `when`(service.login("prashant1", "bale1")).thenReturn(false)
    presenter.doLogin()

    verify(view)?.showLoginError()
  }
}