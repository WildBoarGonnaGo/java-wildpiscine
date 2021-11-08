import java.lang.Math;
import java.util.Arrays;
import java.lang.Object;

public class ArrayVector implements Vector {
	double	arr[];

	ArrayVector(double x, double y, double z) {
		arr = new double[] { x, y, z };
	}

	@Override
	public double	component(int n) { return (arr[n]); }

	@Override
	public double	length() {
		return ( Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1] + arr[2] * arr[2]) );
	}

	@Override
	public Vector	plus(Vector other) {
		return new ArrayVector(
			this.component(0) + other.component(0),
			this.component(1) + other.component(1),
			this.component(2) + other.component(2)
		);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(arr);
	}

	@Override
	public boolean 		equals(Object o) {
		if (this == o) { return (true); }
		else if (!(o instanceof Vector)) { return (false); }
		Vector that = (Vector)o;
		return (this.component(0) == that.component(0) &&
			this.component(1) == that.component(1) &&
			this.component(2) == that.component(2));
	}

}
