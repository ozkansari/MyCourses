package tr.edu.medipol.hafta5.ornek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaInJavaClasses {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; ++i)
			list.add(i + 1);

		Collections.sort(list, (a, b) -> b - a);
		System.out.println(list);
		
		Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
		System.out.println(list);
		
	}
}
