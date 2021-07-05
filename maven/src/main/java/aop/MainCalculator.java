package aop;

import chap05.Calculator;
import chap05.ExeCalculator;
import chap05.ImplCalculator2;

public class MainCalculator {

	public static void main(String[] args) {
		Calculator cal = new ExeCalculator(new ImplCalculator2());

		// start = System.currentTimeMillis();
		long r = cal.factorial(5);
		// long end = System.currentTimeMillis();

		// System.out.println("for 문 :" +(end-start));
		System.out.println(r);
	//	System.out.println();
	}

}
