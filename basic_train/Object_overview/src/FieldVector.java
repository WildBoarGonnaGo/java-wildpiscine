import java.util.Arrays;
import java.util.logging.FileHandler;
import java.lang.Object;

public class FieldVector implements Vector {
	double x, y, z;

	FieldVector(double x, double y, double z) {
		this.x = x; this.y = y; this.z = z;
	}

	@Override
	public double	component(int n) {
		switch (n) {
			case (0): return (x);
			case (1): return (y);
			case (2): return (z);
			default: throw new IllegalArgumentException();
		}
	}

	@Override
	public double	length() {
		return ( java.lang.Math.sqrt( x * x + y * y + z * z) );
	}

	@Override
	public Vector	plus(Vector other) {
		return new FieldVector(
			x + other.component(0),
			y + other.component(1),
			z + other.component(2)
		);
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
