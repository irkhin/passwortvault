package de.irkhin.android.passwortvault;

import de.irkhin.android.passwortvault.db.datasource.PasswortVaultDataSource;
import de.irkhin.android.passwortvault.db.model.PasswordVaultRecord;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class PasswortVaultMainActivity extends Activity {

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datainput);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(de.irkhin.android.passwortvault.R.menu.main,
				menu);
		return true;
	}

	public void saveData(View view) {
		Intent intent = new Intent(this, MainListActivity.class);
		EditText username = (EditText) findViewById(R.id.editText1);
		EditText password = (EditText) findViewById(R.id.editText2);
		//TODO save data
		PasswortVaultDataSource datasource = new PasswortVaultDataSource(this);
		PasswordVaultRecord record = new PasswordVaultRecord(username.getText().toString(), password.getText().toString());
		datasource.insert(record );
		startActivity(intent);
	}

}
