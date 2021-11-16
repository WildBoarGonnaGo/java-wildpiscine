package edu.school21.chat.app;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Optional;
import java.sql.*;
import java.util.Scanner;

public class Program {

	private final static String		dbUrl = "jdbc:postgresql://localhost:5432/wildboargonnago";
	private final static String		user = "wildboargonnago";
	private final static String 	password = "";
	private static HikariConfig		wildHikari = new HikariConfig();
	private static HikariDataSource	wildHikariDS;

	public static void main(String[] args) {
		Chatroom			grepChatroomById = null;
		Users				grepUsersById = null;
		Message				grepMessageById = null;
		Scanner 			sc = new Scanner(System.in);
		Long				inputId = (long)0;
		Optional<Message>	messageEntity;
		Connection			addConnection = null;
		Statement			someStatement = null;
		ResultSet			usersAndChatrooms = null;

		sc.useDelimiter("\\u000A");
		if (sc.hasNextLong())
			inputId = sc.nextLong();
		try {
			MessagesRepositoryJdbcImpl	getInfoTool = new MessagesRepositoryJdbcImpl();
			messageEntity = getInfoTool.findById(inputId);
			grepMessageById = messageEntity.get();

			inputId = grepMessageById.getId();
			wildHikari.setJdbcUrl(dbUrl);
			wildHikari.setUsername(user);
			wildHikari.setPassword(password);
			wildHikariDS = new HikariDataSource(wildHikari);
			addConnection = wildHikariDS.getConnection();
			someStatement = addConnection.createStatement();
			String			finalQueries = "SELECT * FROM users WHERE id=" + grepMessageById.getAuthor() + ';';
			usersAndChatrooms = someStatement.executeQuery(finalQueries);

			if (usersAndChatrooms.next())
				grepUsersById = new Users(usersAndChatrooms.getLong("id"),
					usersAndChatrooms.getString("login"),
					usersAndChatrooms.getString("password"),
					null,
					null);
			else
				throw new SQLException();


			finalQueries = "SELECT * FROM chatroom WHERE id=" + grepMessageById.getRoom() + ';';
			usersAndChatrooms = someStatement.executeQuery(finalQueries);
			if (usersAndChatrooms.next())
				grepChatroomById = new Chatroom(usersAndChatrooms.getLong("id"),
					usersAndChatrooms.getString("name"),
					usersAndChatrooms.getLong("owner"),
					null);
			else
				throw new SQLException();

			System.out.println("Message : { \n" + "id = " + inputId + ",\nauthor = "
				+ grepUsersById.toString() + ",\nroom = " + grepChatroomById.toString()
				+ ",\ntext = \"" + grepMessageById.getText() + "\",\ndate_time = "
				+ Message.sqlDateTimeFormat.format(grepMessageById.getDate_time()) + " }");
			usersAndChatrooms.close();
			someStatement.close();
			addConnection.close();
			wildHikariDS.close();
		} catch (SQLException exc) {
			System.err.println("SQL entity can't be handled. Here's why:");
			exc.printStackTrace();
			System.exit(-1);
		}
	}
}
