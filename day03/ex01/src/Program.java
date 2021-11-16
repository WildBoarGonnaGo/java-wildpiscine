public class Program {
	public static void	main(String[] args) throws InterruptedException{
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

		HenAndEgg		obj = new HenAndEgg();
		wildThreadSync	hen = new wildThreadSync("Hen", obj, beginNumber);
		wildThreadSync	egg = new wildThreadSync("Egg", obj, beginNumber);

		egg._wildThread.start();
		hen._wildThread.start();
	}
}
