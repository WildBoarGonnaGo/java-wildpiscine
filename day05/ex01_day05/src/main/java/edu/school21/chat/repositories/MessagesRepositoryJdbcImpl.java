package edu.school21.chat.repositories;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.*;

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

	@Override
	public Optional<Message> findById(Long id){
		Long				idTmp = (long)0;
		ResultSet			evilQuery;
		Optional<Message>	result = Optional.empty();
		Users 				author;
		Chatroom			room;

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
}
