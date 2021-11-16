package edu.school21.chat.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Message {
	private Long							id;
	private Long							author;
	private Long							room;
	private String							text;
	private Timestamp						date_time;

	public Message() { }
	public Message(Long id, Long author, Long room, String text, Timestamp date_time) {
		this.id = id;
		this.author = author;
		this.room = room;
		this.text = text;
		this.date_time = date_time;
	}
	private static final SimpleDateFormat	sqlDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Long								getId() { return id; }
	public Long								getAuthor() { return author; }
	public Long								getRoom() { return room; }
	public String							getText() { return text; }
	public Timestamp						getDate_time() { return date_time; }

	public void								setId(Long id) { this.id = id; }
	public void								setAuthor(Long author) { this.author = author; }
	public void								setRoom(Long room) { this.room = room; }
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
		return "{" +
			"id = " + id +
			", author = " + author +
			", room = " + room +
			", text = '" + text + '\'' +
			", date_time = " + sqlDateTimeFormat.format(date_time) +
			'}';
	}
}
