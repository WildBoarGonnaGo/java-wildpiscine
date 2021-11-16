
public class Program {
	public static void	main(String[] args) {
		UserArrayList	arrUserList = new UserArrayList();
		arrUserList.add(new User("Mike", 500));
		arrUserList.add(new User("Josh", 250));
		arrUserList.add(new User("Tyler", 400));
		arrUserList.add(new User("Trevor", 600));
		arrUserList.add(new User("Nagash", 999));
		arrUserList.add(new User("Archaon", 888));
		arrUserList.add(new User("Glottkin", 7));
		arrUserList.add(new User("Valkia the bloody", 8));
		arrUserList.add(new User("Sigvald the Magnificent", 6));
		arrUserList.add(new User("Melekh the changer", 9));
		arrUserList.add(new User("Abrax the Bloody", 8));

		System.out.println("Let's check out add and get(Integer index) functions with OutOfBoundsException: ");
		for (int i = 0; i <= arrUserList.getNumberOfUsers(); ++i) {
			try {
				User	roll = arrUserList.get(i);

				System.out.println("User's ID: " + roll.getIdentification());
				System.out.println("User's Name: " + roll.getName());
				System.out.println("User's Balance " + roll.getBalance());
				System.out.print('\n');
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Let's check out add and getID(Integer userID) functions with NoSuchElementException: ");
		for (int i = 0; i <= arrUserList.getNumberOfUsers(); ++i) {
			try {
				User	roll = arrUserList.getID(i);

				System.out.println("User's ID: " + roll.getIdentification());
				System.out.println("User's Name: " + roll.getName());
				System.out.println("User's Balance " + roll.getBalance());
				System.out.print('\n');
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
	}
}
