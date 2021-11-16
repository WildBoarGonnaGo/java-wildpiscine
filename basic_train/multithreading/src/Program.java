public class Program {

	public static void main(String[] args) {
		int	beginNumber;
		int	endOfStr;

		if (args.length != 1) {
			System.err.println("Not enough arguments");
			System.exit(-1);
		}
		if (!args[0].matches("--count=(\\d+)")) {
			System.err.printf("Usage of Program: Program --count=<some_number_greater_than_zero>");
			System.exit(-1);
		}
		endOfStr = args[0].length();
		for (beginNumber = endOfStr - 1; beginNumber > 0
			&& Character.isDigit(args[0].charAt(beginNumber)); --beginNumber)
			;
		++beginNumber;
		String	subStr = args[0].substring(beginNumber, endOfStr);
		beginNumber = Integer.valueOf(subStr);

		wildThread egg = new wildThread("Egg", beginNumber);
		wildThread hen = new wildThread("Hen", beginNumber);
		Thread henThread = new Thread(hen);
		Thread eggThread = new Thread(egg);
		henThread.start();
		eggThread.start();
		for (int i = 0; henThread.isAlive() || eggThread.isAlive(); ++i) {
			if (i < 50)
				System.out.println("Human");
		}
	}
}
