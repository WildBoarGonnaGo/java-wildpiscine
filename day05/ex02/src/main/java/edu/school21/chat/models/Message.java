package edu.school21.chat.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Message {
	private Long							id;
	private Users							author;
	private Chatroom						room;
	private String							text;
	private Timestamp						date_time;

	public Message() { }
	public Message(Long id, Users author, Chatroom room, String text, Timestamp date_time) {
		this.id = id;
		this.author = author;
		this.room = room;
		this.text = text;
		this.date_time = date_time;
	}
	public static final SimpleDateFormat	sqlDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Long								getId() { return id; }
	public Users							getAuthor() { return author; }
	public Chatroom							getRoom() { return room; }
	public String							getText() { return text; }
	public Timestamp						getDate_time() { return date_time; }

	public void								setId(Long id) { this.id = id; }
	public void								setAuthor(Users author) { this.author = author; }
	public void								setRoom(Chatroom room) { this.room = room; }
	public void								setText(String text) { this.text = text; }
	public void								setDate(Timestamp date_time) { this.date_time = date_time; }

	@Override
	public boolean 							equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Message)) return false;
		Message message = (Message) o;
		return id.equals(message.id) && author.equals(message.author) && room.equals(message.room)
			&& text.equals(message.text) && date_time.equals(message.date_time);
	}

	@Override
	public int 								hashCode() {
		return Objects.hash(id, author, room, text, date_time);
	}

	@Override
	public String 							toString() {
		return "{ " +
			"id = " + id +
			", author = " + author.toString() +
			", room = " + room.toString() +
			", text = '" + text + '\'' +
			", date_time = " + sqlDateTimeFormat.format(date_time) +
			" }";
	}
}
