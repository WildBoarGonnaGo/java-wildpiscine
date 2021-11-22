package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
	private	Long			id;
	private	String			name;
	private	Users			owner;
	private List<Message>	messages;

	public Chatroom() {}
	public Chatroom(Long id, String name, Users owner, List<Message> messages) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.messages = messages;
	}
	public Long				getId() { return id; }
	public String			getName() { return name; }
	public Users			getOwner() { return owner; }
	public List<Message>	getMessages() { return messages; }

	public void		setId(Long id) { this.id = id; }
	public void		setName(String name) { this.name = name; }
	public void		setOwner(Users owner) { this.owner = owner; }
	public void		setMessages(List<Message> messages) { this.messages = messages; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Chatroom)) return false;
		Chatroom chatroom = (Chatroom) o;
		return id.equals(chatroom.id) && name.equals(chatroom.name)
			&& owner.equals(chatroom.owner)
			&& messages.equals(chatroom.messages);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, owner, messages);
	}

	@Override
	public String toString() {
		return "{ " +
			"id = " + id +
			",name = '" + name + '\'' +
			", owner = " + owner.toString() +
			", messages = " + messages +
			" }";
	}
}
