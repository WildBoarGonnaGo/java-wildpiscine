package edu.school21.chat.app;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
	public static void main(String[] args) {
		Users 		creator = new Users(3L, "lchantel", "qwerty123",
						new ArrayList(), new ArrayList());
		Users 		author = creator;
		Chatroom	room = new Chatroom(1L, "burger_spam", creator, new ArrayList());
		Message		message = new Message(null, author, room, "Hello!",
			Timestamp.valueOf(LocalDateTime.now()));
		try {
			MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl();
			messagesRepository.save(message);
			System.out.println("ID of the new saved message: " + message.getId());
		} catch (SQLException exc) {
			System.err.println("Message can't be saved in message table!");
			exc.printStackTrace();
			System.exit(-1);
		}
	}
}
