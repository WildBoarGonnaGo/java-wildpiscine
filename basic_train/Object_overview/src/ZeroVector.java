import java.util.Arrays;
import java.lang.Object;

public class ZeroVector implements Vector{
	final public static ZeroVector INSTANCE = new ZeroVector();

	@Override
	public double		component(int n) { return (0); }

	@Override
	public double		length() { return (0); }

	@Override
	public Vector		plus(Vector other) { return (other); }

	@Override
	public boolean 		equals(Object o) {
		if (this.INSTANCE == o) { return (true); }
		else if (!(o instanceof Vector)) { return (false); }
		Vector that = (Vector)o;
		return (this.component(0) == that.component(0) &&
			this.component(1) == that.component(1) &&
			this.component(2) == that.component(2));
	}
}
