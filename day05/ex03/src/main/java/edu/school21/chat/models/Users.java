package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Users {
	private Long			id;
	private String			login;
	private String			password;
	private List<Chatroom>	createdRooms;
	private List<Chatroom>	socializedChatRooms;

	public Users() { }
	public Users(Long id, String login, String password,
				 List<Chatroom> createdRooms,
				 List<Chatroom> socializedChatRooms) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.createdRooms = createdRooms;
		this.socializedChatRooms = socializedChatRooms;
	}

	public Long				getId() { return id; }
	public String			getLogin() { return login; }
	public String			getPassword() { return password; }
	public List<Chatroom>	getCreatedRooms() { return createdRooms; }
	public List<Chatroom>	getSocializedChatRooms() { return socializedChatRooms; }

	public void				setId(Long id) { this.id = id; }
	public void				setLogin(String login) { this.login = login; }
	public void				setPassword(String password) { this.password = password; }
	public void				setCreatedRooms(List<Chatroom> createdRooms) { this.createdRooms = createdRooms; }
	public void				setSocializedChatRooms(List<Chatroom> socializedChatRooms) {
		this.socializedChatRooms =  socializedChatRooms; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Users)) return false;
		Users users = (Users) o;
		return id.equals(users.id) && login.equals(users.login)
			&& password.equals(users.password)
			&& createdRooms.equals(users.createdRooms)
			&& socializedChatRooms.equals(users.socializedChatRooms);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, login, password, createdRooms, socializedChatRooms);
	}

	@Override
	public String toString() {
		return "{ " +
			"id=" + id +
			", login='" + login + '\'' +
			", password='" + password + '\'' +
			", createdRooms=" + createdRooms +
			", socializedChatRooms=" + socializedChatRooms +
			" }";
	}
}