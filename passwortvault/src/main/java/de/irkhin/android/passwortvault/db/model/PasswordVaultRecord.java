package de.irkhin.android.passwortvault.db.model;

public class PasswordVaultRecord {
private String name;
private String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public PasswordVaultRecord(String name, String password) {
	super();
	this.name = name;
	this.password = password;
}
public PasswordVaultRecord() {
	super();
}


}
