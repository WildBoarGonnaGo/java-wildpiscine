import java.util.NoSuchElementException;
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
	private static class nodeTrans {
		Transaction	_data;
		nodeTrans	_prev;
		nodeTrans	_next;

		nodeTrans(Transaction data, nodeTrans prev, nodeTrans next) {
			_data = data;
			_prev = prev;
			_next = next;
		}
	}

	nodeTrans	_head;
	nodeTrans	_tail;
	Integer		size;

	public	TransactionsLinkedList( ) {
		size = 0;
	}

	private void	linkLast(Transaction e) {
		final nodeTrans	last = _head;
		nodeTrans		newNode = new nodeTrans(e, last, null);
		_head = newNode;
		if (last == null)
			_tail = last;
		else
			last._next = newNode;
		++size;
	}

	@Override
	public boolean		add(Transaction e) {
		linkLast(e);
		return (true);
	}

	class TransactionNotFoundException extends RuntimeException {
		public TransactionNotFoundException() {
			System.err.println("Transaction with such UUID doesn't exist");
		}

		public TransactionNotFoundException(UUID nonNumExist) {
			System.err.println("There is no such transaction + (UUID " + nonNumExist.toString() + ") in this list");
		}
	}

	@Override
	public Transaction	remove(UUID num) {
		nodeTrans	link = _tail;

		while (link._next != null) {
			if (link._data.getTransactionUUID() == num) {
				Transaction	evac = link._data;
				if (link == _tail) {
					_tail = link._next;
				} else {
					nodeTrans	bridge;

					nodeTrans	prevOfEvac = link._prev;
					bridge = prevOfEvac._next = link._next;
					bridge._prev = prevOfEvac;
				}
				--size;
				return (evac);
			}
			link = link._next;
		}
		throw new TransactionNotFoundException(num);
	}

	@Override
	public Transaction[]	toArray() {
		Transaction[]	transArray = new Transaction[size];
		nodeTrans		link = _tail;

		for (int i = 0; i < size; ++i) {
			transArray[i] = link._data;
			link = link._next;
		}
		return (transArray);
	}
}
