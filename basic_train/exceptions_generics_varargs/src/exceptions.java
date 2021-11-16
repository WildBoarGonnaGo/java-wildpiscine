import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class exceptions {

	static class Shmoption<T> {
		T	value;

		public		Shmoption(T value) { this.value = value; }

		public T	get() {
			if (value == null)
				throw new NoSuchElementException();
			return (value);
		}

		public void	set(T value) { this.value = value; }

		public T	orElse(T other) {
			return ((value == null) ? other : value);
		}

		public boolean	isPresent() {
			return (value != null);
		}
	}

	static class MyException extends	Exception {
		public	MyException(String message) { super(message); }

		public	MyException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	static void test() throws			MyException {
		throw new MyException("Test of exception func is ok");
	}

	static void	readFile() throws MyException {
		try {
			byte[]	bytes = Files.readAllBytes(Paths.get("/Users/wildboargonnago/lol.c"));
			System.out.println(Arrays.toString(bytes));
		} catch (IOException ex){
			throw new MyException("Unable to read file", ex);
		}
	}

	//Varargs static function
	private static void					printAllString(String... strings) {
		for (String subj : strings)
			System.out.print(subj);
		System.out.print("\n");
	}

	public static void					main(String[] args) {
		try { test(); }
		catch (MyException ex) { ex.printStackTrace(); }
		try { readFile(); }
		catch (MyException ex) {
			ex.printStackTrace();
		}
		//Option obj = new Option(5);
		//System.out.println(obj.getT());

		Shmoption<String>	present = new Shmoption<>("yes");
		Shmoption<String>	absent = new Shmoption<>(null);
		System.out.println(present.get());
		System.out.println(present.isPresent());
		System.out.println(absent.isPresent());
		System.out.println(absent.orElse("no"));

		Shmoption<Object>	someObj = new Shmoption<>("Evil Islands");
		System.out.println(someObj.isPresent());
		Object	impost = someObj.get();
		System.out.println(impost);
		someObj.set(123);
		System.out.println(someObj.get());

		//Varargs test
		printAllString("Kono ", "Dio ", "Da!");
	}
}
