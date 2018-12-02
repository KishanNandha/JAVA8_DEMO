package LambdaDemo;

@FunctionalInterface
interface Interf {
	public void m1();
}

class MyClass {

	private String name = "MS Dhoni";

	public void MyMethod() {
		Interf i = () -> {
			String name = "Virat";
			System.out.println(name);
			System.out.println(this.name);
		};
		i.m1();
	}
}

public class LambdaProps {
	public static void main(String[] args) {
		MyClass m = new MyClass();
		m.MyMethod();
	}

}
