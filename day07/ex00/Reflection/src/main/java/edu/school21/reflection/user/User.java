package edu.school21.reflection.user;

import java.util.StringJoiner;

public class User {
	private String	firstName;
	private String	lastName;
	private int		height;

	public 		User() {
		this.firstName = "Vasya";
		this.lastName = "Pupkin";
		this.height = 180;
	}

	public		User(String firstName, String lastName, int height) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
	}

	public int	grow(int value) {
		height += value;
		return (height);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", this.getClass().getSimpleName() + "[ ", " ]")
			.add("firstName = '" + firstName + "'")
			.add("lastName = '" + lastName + "'")
			.add("height = " + height).toString();
	}
}
