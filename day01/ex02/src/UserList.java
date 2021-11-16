import java.util.Iterator;

interface UserList {
	boolean	add(User e);
	User	getID(Integer userID);
	User	get(Integer indx);
	Integer	getNumberOfUsers();
}
