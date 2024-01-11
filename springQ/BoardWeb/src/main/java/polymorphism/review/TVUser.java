package polymorphism.review;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContextRv.xml");
	
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(LookUp)한다.
		TV tv = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		
		
		// 3. Spring 컨테이너를 종료한다.
		factory.close();
	}
}
