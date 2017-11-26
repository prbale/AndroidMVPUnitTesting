package prbale.com.androidmvpdemo;

import android.content.Context;
import android.content.Intent;

import prbale.com.androidmvpdemo.home.HomeActivity;

public class ActivityUtil {

  private Context context;

  public ActivityUtil(Context context) {
    this.context = context;
  }

  public void startMainActivity() {
    context.startActivity(new Intent(context, HomeActivity.class));
  }
}
