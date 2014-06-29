package com.anirudh.smsmom;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final String smsMessage = "Call Me";
		final String phoneNumber = "ENTER YOUR MOM's PHONE NUMBER";
		
		/* Alert dialog to make sure you really want to message your mom.*/
		
		/* Strings are hard coded. which is really bad, will fix this shortly.*/
		new AlertDialog.Builder(this)
		.setTitle("Send sms")
		.setMessage("Are you sure?")
		.setPositiveButton("Yes", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				// TODO Auto-generated method stub
				SmsManager sms = SmsManager.getDefault();
				sms.sendTextMessage(phoneNumber, null, smsMessage, null, null);
				dialog.dismiss();
				Toast.makeText(getApplicationContext(), "Message successfully sent to mom", Toast.LENGTH_LONG).show();
				finish();
			}
		})
		.setNegativeButton("No", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				finish();
			}
		}).create().show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
