package edu.school21.chat.repositories;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.Users;

import java.text.ParseException;
import java.util.Optional;
import java.sql.*;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
	private final static String		dbUrl = "jdbc:postgresql://localhost:5432/wildboargonnago";
	private final static String		user = "wildboargonnago";
	private final static String 	password = "";
	private Connection				dbConn;
	private Statement				queryWarlock;
	private static HikariConfig		wildHikari = new HikariConfig();
	private static HikariDataSource	wildHikariDS;

	public MessagesRepositoryJdbcImpl() throws SQLException {
		wildHikari.setJdbcUrl(dbUrl);
		wildHikari.setUsername(user);
		wildHikari.setPassword(password);
		wildHikariDS = new HikariDataSource(wildHikari);
		dbConn = wildHikariDS.getConnection();
		queryWarlock = dbConn.createStatement();
	}

	public class NotSavedSubEntityException extends RuntimeException {
		public NotSavedSubEntityException() {
			System.err.println("Entity can't be added: it's null or message table already has it...");
		}
	}

	@Override
	public Optional<Message> findById(Long id){
		Long				idTmp = (long)0;
		ResultSet			evilQuery;
		Optional<Message>	result = Optional.empty();
		Users author;
		Chatroom room;

		if (id < 0)
			return result;
		try {
			evilQuery = queryWarlock.executeQuery("SELECT COUNT(*) FROM message;");
			if (evilQuery.next())
				idTmp = evilQuery.getLong("count");
			if (id > idTmp) {
				System.err.println("Id number exceeds the total amount of messages.");
				return Optional.empty();
			}
			String	queryStr = "SELECT * FROM message RIGHT JOIN users " +
				"ON message.author = users.idusers RIGHT JOIN chatroom ON " +
				"message.room = chatroom.idchatroom WHERE message.idmessage = " + id.toString() + ';';
			evilQuery = queryWarlock.executeQuery(queryStr);
			if (evilQuery.next()) {
				author = new Users(evilQuery.getLong("idusers"),
					evilQuery.getString("login"),
					evilQuery.getString("password"), null, null);
				room = new Chatroom(evilQuery.getLong("idchatroom"),
					evilQuery.getString("name"),
					author, null);
				result = Optional.of(new Message(evilQuery.getLong("idmessage"),
					author, room, evilQuery.getString("text"),
					evilQuery.getTimestamp("date_time")));
			}
			evilQuery.close();
			return result;
		} catch (SQLException exc) {
			System.err.println("SQL query can't be executed.");
			exc.printStackTrace();
			return result;
		}
	}

	@Override
	public void					save(Message message) {
		Long			id = message.getId();
		String			queryTool;
		ResultSet		evilQuery;
		Long			usersId;
		Long			chatoomId;
		Statement		insertWarlock;
		java.util.Date	parsedDate;
		Timestamp		timestamp = null;

		if (message.getAuthor().getId() == null || message.getRoom().getId() == null)
			throw new NotSavedSubEntityException();
		usersId = message.getAuthor().getId();
		chatoomId = message.getRoom().getId();
		queryTool = "SELECT * FROM users WHERE idusers = " + usersId + ';';
		try {
			evilQuery = queryWarlock.executeQuery(queryTool);
			if (!evilQuery.next())
				throw new NotSavedSubEntityException();
			queryTool = "SELECT * FROM chatroom WHERE idchatroom = " + chatoomId + ';';
			evilQuery = queryWarlock.executeQuery(queryTool);
			if (!evilQuery.next())
				throw new NotSavedSubEntityException();
			queryTool = "INSERT INTO message(author, room, text, date_time) VALUES(" +
				message.getAuthor().getId() + ", " + message.getRoom().getId() + ", '"
				+ message.getText() + "', '"
				+ Message.sqlDateTimeFormat.format(message.getDate_time()) + "');";
			insertWarlock = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			evilQuery = insertWarlock.executeQuery("SELECT * FROM message");
			try {
				if (message.getDate_time() != null) {
					parsedDate = Message.sqlDateTimeFormat.parse(
						Message.sqlDateTimeFormat.format(message.getDate_time()));
					timestamp = new java.sql.Timestamp(parsedDate.getTime());
				}
			} catch (ParseException exc) { exc.printStackTrace(); }
			evilQuery.last();
			evilQuery.moveToInsertRow();
			evilQuery.updateLong("author", usersId);
			evilQuery.updateLong("room", chatoomId);
			evilQuery.updateString("text", message.getText());
			evilQuery.updateTimestamp("date_time", timestamp);
			evilQuery.insertRow();
			message.setId(evilQuery.getLong("idmessage"));
			insertWarlock.close();
			evilQuery.close();
		} catch (SQLException exc) {
			System.err.println("And so the message entity can't be saved");
			exc.printStackTrace();
		}

	}
}