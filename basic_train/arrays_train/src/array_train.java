import java.util.Arrays;

public class array_train {
	public static void main(String args[]) {
		int[]	ints = {1, 2, 3, 4, 5};

		System.out.println(ints.length);
		System.out.println(ints.length);
		ints[1] += 1;
		int[]	copy = ints.clone();
		System.out.println(ints == copy);
		System.out.println(ints.equals(copy));
		System.out.println(Arrays.equals(ints, copy));
		System.out.println(Arrays.toString(ints));
		Arrays.sort(ints);
 	}
}
