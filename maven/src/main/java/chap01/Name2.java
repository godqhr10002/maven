package chap01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Name2 {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chap01/beans.xml"); // greeter라는 이름으로 빈 등록
		
		//Greeter g = (Greeter)ctx.getBean("greeter");
		Greeter g = ctx.getBean("greeter", Greeter.class);
		System.out.println(g.greet("홍길동"));
	}
}
