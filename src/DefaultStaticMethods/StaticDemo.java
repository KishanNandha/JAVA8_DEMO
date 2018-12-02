package DefaultStaticMethods;

interface Interf {
	public static void m1() {
		System.out.println("static method");
	}
}

public class StaticDemo implements Interf {

	public static void main(String[] args) {
		StaticDemo s = new StaticDemo();
		// s.m1() error
		// StaticDemo.m1(); error
		Interf.m1();
	}
}
