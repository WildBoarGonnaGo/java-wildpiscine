public class UserIdsGenerator {
	private static UserIdsGenerator	instance;
	private Integer 				idNumber;
	private UserIdsGenerator() {}
	public static UserIdsGenerator	getInstance() {
		if (instance == null)
			instance = new UserIdsGenerator();
		return (instance);
	}
	public Integer generateId() {
		if (idNumber == null)
			idNumber = -1;
		return (++idNumber);
	}
}
