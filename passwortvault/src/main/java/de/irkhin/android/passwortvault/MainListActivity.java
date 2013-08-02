package de.irkhin.android.passwortvault;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import de.irkhin.android.passwortvault.db.datasource.PasswortVaultDataSource;
import de.irkhin.android.passwortvault.db.model.PasswordVaultRecord;

public class MainListActivity extends Activity {

	PasswortVaultDataSource datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_list);
		datasource = new PasswortVaultDataSource(this);
		List<PasswordVaultRecord> values = datasource.getAllRecords();
		List<String> test = new ArrayList<String>();
		for (PasswordVaultRecord elem : values) {
			test.add(elem.getName());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1, test);
		ListView passwordList = (ListView) findViewById(R.id.listview1);
		passwordList.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_list, menu);

		return true;
	}

	public void addData(View view) {
		Intent intent = new Intent(this, PasswortVaultMainActivity.class);
		startActivity(intent);
	}

}
