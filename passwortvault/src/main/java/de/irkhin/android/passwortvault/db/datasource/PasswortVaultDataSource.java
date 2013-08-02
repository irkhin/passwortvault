package de.irkhin.android.passwortvault.db.datasource;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import de.irkhin.android.passwortvault.db.model.PasswordVaultRecord;
import de.irkhin.android.passwortvault.db.wrapper.SQLLiteDBWrapper;

public class PasswortVaultDataSource {

	private SQLLiteDBWrapper dbWrapper;

	public PasswortVaultDataSource(Context context) {
		dbWrapper = new SQLLiteDBWrapper(context);
	}

	public void insert(PasswordVaultRecord record) {
		dbWrapper.insert(record.getName(), record.getPassword());
	}

	public List<PasswordVaultRecord> getAllRecords() {
		Cursor cursor = dbWrapper.select();
		List<PasswordVaultRecord> result = new ArrayList<PasswordVaultRecord>();
		if (cursor != null) {
			while (!cursor.isAfterLast()) {
				PasswordVaultRecord passwordVaultRecord = cursorToPasswordVaultRecord(cursor);
				if (passwordVaultRecord != null) {
					result.add(cursorToPasswordVaultRecord(cursor));
				}
				cursor.moveToNext();

			}
		}
		return result;
	}

	private PasswordVaultRecord cursorToPasswordVaultRecord(Cursor cursor) {

		PasswordVaultRecord result = null;
		if (cursor != null) {
			result = new PasswordVaultRecord();
			result.setName(cursor.getString(cursor.getColumnIndex("name")));
			result.setPassword(cursor.getString(cursor
					.getColumnIndex("password")));
		}
		return result;

	}

}
