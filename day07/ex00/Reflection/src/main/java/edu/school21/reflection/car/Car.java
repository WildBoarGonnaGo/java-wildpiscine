package edu.school21.reflection.car;
import edu.school21.reflection.user.User;

import java.util.StringJoiner;

public class Car {
	private String	company;
	private String	name;
	private	String	govID;
	private String	ownerFirstName;
	private String	ownerSecondName;

	public Car() {
		this.company = "Lada";
		this.name = "Kalina";
		this.govID = "ABCD12345";
		this.ownerFirstName = "null";
		this.ownerSecondName = "null";
	}

	public Car(String company, String name, String govId,
			   String ownerFirstName, String ownerSecondName) {
		this.company = company;
		this.name = name;
		this.govID = govID;
		this.ownerFirstName = ownerFirstName;
		this.ownerSecondName = ownerSecondName;
	}

	public String	changeOwner(String ownerFirstName, String ownerSecondName) {
		this.ownerFirstName = ownerFirstName;
		this.ownerSecondName = ownerSecondName;
		return (this.ownerFirstName + ' ' + this.ownerSecondName);
	}

	@Override
	public String	toString() {
		return new StringJoiner(", ", this.getClass().getSimpleName() + "[ ", " ]")
			.add("company = '" + company + "'")
			.add("name = '" + name + "'")
			.add("govID = '" + govID + "'")
			.add("ownerFirstName = " + ownerFirstName)
			.add("ownerSecondName = " + ownerSecondName).toString();
	}
}
