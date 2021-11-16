import java.util.UUID;

public class Transaction {
	UUID	Identifier;
	User	Recipient;
	User	Sender;
	enum	TransferCategory { debits, credits }
	Integer	transferAmount;

	public Transaction(UUID Identifier, User Recipient,
					   User Sender, TransferCategory transfer, Integer transferAmount) {
		this.Identifier = Identifier;
		this.Recipient = Recipient;
		this.Sender = Sender;
		this.transferAmount = transferAmount;

		if (transferAmount < 0) {
			System.err.println("Wrong transfer value: negative values ("
				+ transferAmount.toString() +") are not allowed");
			System.exit(-1);
		}

		if (transferAmount > Sender.getBalance()) {
			System.err.println("Money can't be sent: " + Sender.getName()
				+ " doesn't have enough money");
			System.exit(-1);
		}
		System.out.println(Sender.getName() + " -> " + Recipient.getName()
			+ ", -" + transferAmount.toString() + ", OUTCOME, " + Identifier.toString());

		System.out.println(Recipient.getName() + " -> " + Sender.getName() + ", +"
			+ transferAmount.toString() + ", INCOME, " + Identifier.toString());

		Sender.setBalance(Sender.getBalance() - transferAmount);
		Recipient.setBalance(Recipient.getBalance() + transferAmount);
	}

	public UUID		getTransactionUUID() { return Identifier; }

	public Integer	getTransferAmount() { return transferAmount; }

	public User		getRecipient() { return Recipient; }

	public User		getSender()	{ return Sender; }
}