package LambdaDemo;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorLambda {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList();
		list.add(5);
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(3);
		System.out.println("Before list: " + list);
		Collections.sort(list, (i1, i2) -> (i1 > i2) ? -1 : (i2 > i1) ? 1 : 0);
		System.out.println("After list: " + list);
	}

}
