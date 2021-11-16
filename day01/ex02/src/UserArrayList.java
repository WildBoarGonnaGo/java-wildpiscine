import java.util.NoSuchElementException;

public class UserArrayList implements UserList {
	private Integer _size;
	private Integer _elemNum;
	User[] _arr;

	public UserArrayList() {
		_size = 10;
		_arr = new User[_size];
		_elemNum = 0;
	}

	@Override
	public boolean add(User e) {
		if (_elemNum < _size)
			_arr[_elemNum++] = e;
		else {
			User[] oldArr = _arr;
			Integer i = 0;
			Integer oldSize = _size;

			_size += _size / 2;
			_arr = new User[_size];
			for (; i < oldSize; ++i)
				_arr[i] = oldArr[i];
			_arr[i] = e;
			oldArr = null;
			++_elemNum;
		}
		return (true);
	}

	@Override
	public User getID(Integer userID) {
		for (User subj : _arr) {
			if (subj == null)
				throw new NullPointerException("There is no such ID within this array, and current subject is 'null'");
			if (subj.getIdentification() == userID)
				return (subj);
		}
		throw new NoSuchElementException("There is no such ID within this array list of users.");
	}

	@Override
	public User get(Integer indx) {
		if (indx < 0 || indx >= _elemNum)
			throw new IndexOutOfBoundsException("Index is out of this User array bounds!");
		return (_arr[indx]);
	}

	@Override
	public Integer getNumberOfUsers() {
		return (_elemNum);
	}
}