package edu.school21.chat.repositories;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
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
		Message				resObj;
		Optional<Message>	result = Optional.empty();

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
			String	queryStr = "SELECT * FROM message WHERE id=" + id.toString() + ';';
			evilQuery = queryWarlock.executeQuery(queryStr);
			if (evilQuery.next())
				result = Optional.of(new Message(evilQuery.getLong("id"),
					evilQuery.getLong("author"),
					evilQuery.getLong("room"),
					evilQuery.getString("text"),
					evilQuery.getTimestamp("date_time")));
			evilQuery.close();
			queryWarlock.close();
			dbConn.close();
			wildHikariDS.close();
			return result;
		} catch (SQLException exc) {
			System.err.println("SQL query can't be executed.");
			exc.printStackTrace();
			return result;
		}
	}
}
