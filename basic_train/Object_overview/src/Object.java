import java.lang.Math;

public class Object {
	public static void main(String args[]) {
		class Point {
			int x, y;

			Point( ) { }
			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

			class 			AnotherClass {
				void	print() {
					System.out.println("From another class < " + x + " , " + y + " >");
				}
			}

			AnotherClass	getAnotherClass() { return (new AnotherClass()); }

			void			shift(int dx, int dy) {
				x += dx;
				y += dy;
			}
			void			print() { System.out.println("Point <" + x + ", " + y + ">"); }
			double			norm() {
				return (Math.sqrt(x * x + y * y));
			}
		}
		Point p = new Point();
		p.x = 5;
		p.y = 6;
		Point p2 = new Point(7, 8);
		p.print();
		p2.print();

		System.out.println("p.norm() = " + p.norm());
		System.out.println("p2.norm() = " + p2.norm());
		System.out.println("Before shift:");
		p.print();
		p2.print();

		System.out.println("After shift:");
		p.shift(2, 2);
		p2.shift(2, 2);
		p.print();
		p2.print();

		Point.AnotherClass	kek = p.getAnotherClass();
		kek.print();
		Point.AnotherClass	kek2 = p2.getAnotherClass();
		kek2.print();

		/*Перестраховываемся от утечек памяти со стороны внутренних классов*/
		kek = null;
		kek2 = null;

		/*Посмотрим что у нас получилось с ArrayVector, FieldVector и ZeroVector*/
		Vector zero1 = ZeroVector.INSTANCE;
		Vector zero2 = new ArrayVector(0, 0, 0);
		Vector zero3 = new FieldVector(0, 0, 0);
		System.out.println(zero2.equals(zero1));
		System.out.println(zero2.equals(zero3));
		System.out.println(zero3.equals(zero2));

		/*Работаем с перечислениями*/
		for (WeekDays roll : WeekDays.values())
			System.out.println(roll.name() + " (" + roll.getWeekDayName() + ") "
				+ ((!roll.getIsVacation()) ? "arbeiten!" : "relax and enjoy."));
	}
}
