package edu.school21.chat.app;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.sql.*;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner 			sc = new Scanner(System.in);
		Long				inputId = (long)0;
		Optional<Message>	messageEntity;
		Message				result = null;

		sc.useDelimiter("\\u000A");
		if (sc.hasNextLong())
			inputId = sc.nextLong();
		try {
			MessagesRepositoryJdbcImpl	getInfoTool = new MessagesRepositoryJdbcImpl();
			messageEntity = getInfoTool.findById(inputId);

			if (messageEntity.isPresent()) {
				result = messageEntity.get();
				System.out.println(result.toString());
			}
		} catch (SQLException exc) {
			System.err.println("SQL entity can't be handled. Here's why:");
			exc.printStackTrace();
			System.exit(-1);
		}
	}
}
