package LambdaDemo;

@FunctionalInterface
interface Interf1 {
	public void m1();
}

@FunctionalInterface
interface Interf2 {
	public int m2(int num1, int num2);
}

@FunctionalInterface
interface Interf3 {
	public void m3(String s);
}

public class FirstLambda {

	public static void main(String[] args) {
		Interf1 i1 = () -> System.out.println("First Lambda");
		Interf2 i2 = (a, b) -> {
			return (a + b);
		};
		Interf3 i3 = a -> {
			System.out.println("Lambda " + a);
		};
		i1.m1();
		System.out.println(i2.m2(3, 3));
		i3.m3("kishan");
	}

}
