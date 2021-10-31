import java.util.Scanner;

public class Program {
	public static void main(String args[]) {
		Scanner	sc = new Scanner(System.in);
		long	value = sc.nextLong();
		int		i = 1, factor = 3;
		boolean	state = true;

		sc.close();
		if (value == 0 || value == 1 || value < 0) {
			System.err.println("Illegal argument");
			System.exit(-1);
		}
		if (value % 2 == 0)
			state = false;
		else {
			while (factor * factor <= value && state == true) {
				++i;
				if ((value % factor) == 0)
					state = false;
				++factor;
			}
			if (state == true)
				++i;
		}
		System.out.print(state);
		System.out.print(' ');
		System.out.println(i);
	}
}
