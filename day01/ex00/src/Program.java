import java.util.UUID;

public class Program {
	public static void	main(String[] args) {
		User		Mike = new User(1, "Mike", 1000);
		User		John = new User(2, "John", 1000);
		UUID		firstTransaction = UUID.nameUUIDFromBytes(new byte[]{1, 2, 3});
		UUID		secondTransaction = UUID.nameUUIDFromBytes(new byte[]{4, 5, 6});
		UUID		evilTransaction = UUID.nameUUIDFromBytes(new byte[]{6, 6, 6});

		System.out.println("Mike and John Balances before transaction: ");
		System.out.println("Mike's balance (ID = " + Mike.getIdentification() + "): $" + Mike.getBalance());
		System.out.println("John's balance (ID = " + John.getIdentification() + "): $" + John.getBalance());
		System.out.print('\n');

		Transaction	debt = new Transaction(firstTransaction, John, Mike, Transaction.TransferCategory.debits, 500);

		System.out.print('\n');
		System.out.println("Mike and John Balances after transaction:");
		System.out.println("Mike's balance (ID = " + Mike.getIdentification() + "): $" + Mike.getBalance());
		System.out.println("John's balance (ID = " + John.getIdentification() + "): $" + John.getBalance());

		Transaction	debt2 = new Transaction(secondTransaction, John, Mike, Transaction.TransferCategory.debits, 500);

		System.out.print('\n');
		System.out.println("Mike and John Balances after transaction:");
		System.out.println("Mike's balance (ID = " + Mike.getIdentification() + "): $" + Mike.getBalance());
		System.out.println("John's balance (ID = " + John.getIdentification() + "): $" + John.getBalance());

		Transaction	joke = new Transaction(evilTransaction, John, Mike, Transaction.TransferCategory.debits, -500);
		User		Joker = new User(-666, "Joker", -666);
	}
}
