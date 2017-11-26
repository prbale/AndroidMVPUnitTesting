package prbale.com.androidmvpdemo.extension

import android.content.Context
import android.content.Intent
import android.widget.Toast
import prbale.com.androidmvpdemo.home.HomeActivity

/**
 * Context extensions
 */
fun Context.launchHomeScreen() {
  startActivity(Intent(this, HomeActivity::class.java))
}

fun Context.showLongToast(message: String) {
  Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}