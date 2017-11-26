package prbale.com.androidmvpdemo.extension

import android.content.Context
import android.content.Intent
import prbale.com.androidmvpdemo.home.HomeActivity

fun Context.launchHomeScreen() {
  startActivity(Intent(this, HomeActivity::class.java))
}