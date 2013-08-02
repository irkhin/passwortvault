package de.irkhin.android.passwortvault.db.wrapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLLiteDBWrapper extends SQLiteOpenHelper {
	private final String TABLENAME = "PasswortVault";
	private String[] COLUMNNAMES = {"id", "name", "password"};
	private SQLiteDatabase database;

	public SQLLiteDBWrapper(Context context) {
		super(context, "PasswortVaultDB", null, 1);
	}

	public void open() {
		if (database==null||!database.isOpen()) {
			database = this.getWritableDatabase();
		}
	}
	
	public void close(){
		database.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		final String createVaultTable = "CREATE TABLE "+TABLENAME+" ("
				+ COLUMNNAMES[0]+" INTEGER PRIMARY KEY,"+COLUMNNAMES[1]+" TEXT, "+COLUMNNAMES[2]+"  TEXT)";
		db.execSQL(createVaultTable);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		final String createVaultTable = "DROP TABLE IF EXISTS "+TABLENAME;
		db.execSQL(createVaultTable);
		onCreate(db);
	}

	public void insert(String name, String password) {
		this.open();
		database.beginTransaction();
		ContentValues contentValues = new ContentValues();
		contentValues.put(COLUMNNAMES[1], name);
		contentValues.put(COLUMNNAMES[2], password);
		database.insert(TABLENAME, null, contentValues);
		database.setTransactionSuccessful();
		database.endTransaction();
		this.close();
	}

	public Cursor select() {
		this.open();
		Cursor cursor = null;
		cursor = database.query(TABLENAME, COLUMNNAMES, null, null, null, null, null);
		if (cursor !=null)
			cursor.moveToFirst();
		this.close();
		return cursor;
	}

}