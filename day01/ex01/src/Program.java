import java.util.UUID;

public class Program {
	public static void	main(String[] args) {
		User		Mike = new User("Mike", 1000);
		User		John = new User("John", 1000);

		System.out.println("Mike's identification number is: " + Mike.getIdentification());
		System.out.println("John's identification number is: " + John.getIdentification());
	}
}
