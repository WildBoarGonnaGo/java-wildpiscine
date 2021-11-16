import java.util.UUID;

public interface TransactionsList {
	boolean			add(Transaction e);
	Transaction		remove(UUID num);
	Transaction[]	toArray();
}
