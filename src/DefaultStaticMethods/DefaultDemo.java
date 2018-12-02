package DefaultStaticMethods;

interface Left {
	default void m1() {
		System.out.println("LEFT");
	}
}

interface Right {
	default void m1() {
		System.out.println("RIGHT");
	}
}

class MyClass implements Left, Right {

	@Override
	public void m1() {
		Left.super.m1();
		// Right.super.m1();
		// or our own code
	}

}

public class DefaultDemo {

	public static void main(String[] args) {

	}

}
