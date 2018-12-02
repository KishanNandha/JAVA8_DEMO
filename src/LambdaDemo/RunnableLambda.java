package LambdaDemo;

public class RunnableLambda {

	public static void main(String[] args) {
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread " + i);
			}
		};
		r.run();
	}

}
