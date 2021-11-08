public class Program {
	public static void main(String args[]) {
		int	sample = 479598, res = 0;

		res += sample % 10;
		sample /= 10;
		res += sample % 10;
		sample /= 10;
		res += sample % 10;
		sample /= 10;
		res += sample % 10;
		sample /= 10;
		res += sample % 10;
		sample /= 10;
		res += sample % 10;

		System.out.println(res);
	}
}
