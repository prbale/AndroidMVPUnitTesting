package prbale.com.androidmvpdemo.login

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class LoginPresenterTest {

  @Mock
  private val view: LoginContract.View? = null

  @Mock
  private lateinit var service: LoginRepository

  private lateinit var presenter: LoginPresenter

  @Before
  fun setUp() {

    // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
    // inject the mocks in the test the initMocks method needs to be called.
    MockitoAnnotations.initMocks(this)

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