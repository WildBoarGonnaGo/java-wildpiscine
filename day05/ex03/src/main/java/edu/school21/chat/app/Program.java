package edu.school21.chat.app;

import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.models.*;

import java.sql.SQLException;
import java.util.Optional;

public class Program {
	public static void main(String[] args) {
		try {
			MessagesRepository	messagesRepository = new MessagesRepositoryJdbcImpl();
			Optional<Message>	messageOptional = messagesRepository.findById(7L);
			if (messageOptional.isPresent()) {
				Message message = messageOptional.get();
				message.setText("Bye");
				message.setDate(null);
				messagesRepository.update(message);
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}
}
