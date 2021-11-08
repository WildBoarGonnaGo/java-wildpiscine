/*Represents an immutable 3D vector*/

public interface Vector{
	/*	@param n component, number must be:
	* 		0(x), 1(y), 2(z)
	* 	@return a value of the corresponding vector
	* 		component*/
	double	component(int n);
	/*	@return a vector length*/
	double	length();
	/*	@param other - a vector to add to this vector
	* 	@return a result of addition*/
	Vector	plus(Vector other);
	/*	@param o - a other object link or it's inheritance*/
	/*	@return a boolean that represents the results of comparison */
}
