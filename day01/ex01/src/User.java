public class User {
	final Integer	Identification;
	final String	Name;
	Integer			Balance;

	public			User(String Name, int Balance) {
		this.Identification = UserIdsGenerator.getInstance().generateId();
		this.Name = Name;
		this.Balance =  Balance;

		if (this.Balance < 0) {
			System.err.println("Wrong Balance input: negative values (" + this.Balance.toString()
				+ "), are not allowed");
			System.exit(-1);
		}
	}

	public void		setBalance(Integer Balance) {
		this.Balance = Balance;
	}

	public String	getName() {
		return (this.Name);
	}

	public Integer	getBalance() {
		return (this.Balance);
	}

	public Integer	getIdentification() {
		return (this.Identification);
	}
}
