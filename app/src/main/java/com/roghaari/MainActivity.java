package com.roghaari;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
	private static FragmentManager fragmentManager;
	//public static Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	//	toolbar = (Toolbar) findViewById(R.id.toolbar2) ;
	//	setSupportActionBar(toolbar);



		fragmentManager = getSupportFragmentManager();

		Button shotcut = (Button) findViewById(R.id.button);
		shotcut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this,TabBarActivity.class));
			}
		});



		// If savedinstnacestate is null then replace login fragment
		if (savedInstanceState == null) {
			fragmentManager
					.beginTransaction()
					.replace(R.id.frameContainer, new Login_Fragment(),
							Utils.Login_Fragment).commit();
		}

		// On close icon click finish activity

	}

	// Replace Login Fragment with animation
	protected void replaceLoginFragment() {
		fragmentManager
				.beginTransaction()
				.setCustomAnimations(R.anim.left_enter, R.anim.right_out)
				.replace(R.id.frameContainer, new Login_Fragment(),
						Utils.Login_Fragment).commit();
	}

	@Override
	public boolean useNavDrawer() {
		return false;
	}


	boolean doubleBackToExitPressedOnce = false;

	@Override
	public void onBackPressed() {

		// Find the tag of signup and forgot password fragment
		Fragment SignUp_Fragment = fragmentManager
				.findFragmentByTag(Utils.SignUp_Fragment);
		Fragment ForgotPassword_Fragment = fragmentManager
				.findFragmentByTag(Utils.ForgotPassword_Fragment);

		// Check if both are null or not
		// If both are not null then replace login fragment else do backpressed
		// task

		if (SignUp_Fragment != null)
			replaceLoginFragment();
		else if (ForgotPassword_Fragment != null)
			replaceLoginFragment();
		else if (doubleBackToExitPressedOnce) {
			super.onBackPressed();
			return;
		}


		this.doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleBackToExitPressedOnce=false;
			}
		}, 2000);
	}
}
