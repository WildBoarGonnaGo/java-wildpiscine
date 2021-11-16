import java.lang.Runnable;
import java.lang.InterruptedException;
import java.util.LinkedList;

public class wildThreadSync implements Runnable {
	Thread				_wildThread;
	private HenAndEgg	_henEggObj;
	private int			_count;

	public wildThreadSync(String name, HenAndEgg henEggObj, int count) {
		_henEggObj = henEggObj;
		_wildThread = new Thread(this, name);
		_count = count;
	}

	public void 					run()  {
		try {
			if (_wildThread.getName().compareTo("Hen") == 0) {
				for (int i = 0; i < _count; ++i)
					_henEggObj.hen(true);
				_henEggObj.hen(false);
			} else {
				for (int i = 0; i < _count; ++i)
					_henEggObj.egg(true);
				_henEggObj.egg(false);
			}
		} catch (InterruptedException exc) { ; }
	}
}
