import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		long	someNum;
		int		count = 0;
		Scanner sc = new Scanner(System.in);

		while ((someNum = sc.nextLong()) != 42) {
			long	primeCandi = 0;
			int		idx = 3;
			boolean	state = false;

			while (someNum > 0) {
				primeCandi += someNum % 10;
				someNum /= 10;
			}
			if (primeCandi % 2 != 0 && primeCandi != 1 && primeCandi > 0) {
				state = true;
				while (idx * idx <= primeCandi && state == true) {
					if (primeCandi % idx == 0)
						state = false;
					++idx;
				}
			}
			if (state == true)
				++count;
		}
		System.out.print("Count of coffee-request ");
		System.out.println(count);
		sc.close();
	}
}
