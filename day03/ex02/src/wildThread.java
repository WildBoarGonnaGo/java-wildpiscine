import java.lang.Runnable;

public class wildThread implements Runnable {
	String	_threadName;
	int		_count;

	public	wildThread(String threadName, int count) {
		_threadName = threadName;
		_count = count;
	}

	public void run() {
		for (int i = 0; i < _count; ++i)
			System.out.println(_threadName);
	}
}
