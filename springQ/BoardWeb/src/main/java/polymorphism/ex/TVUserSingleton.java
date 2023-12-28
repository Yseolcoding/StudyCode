package polymorphism.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserSingleton {
	public static void main(String[] args) {

		// 1.Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");


		// 3. 컨테이너를 종료한다.
		factory.close();

		/*
		 * 결과값 :
		 * DEBUG : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loaded 1 bean definitions from class path resource [applicationContext.xml]
DEBUG : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@78a773fd
DEBUG : org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'tv'
===> SamsungTV 객체 생성
객체 초기화 작업 처리..
DEBUG : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@78a773fd, started on Wed Dec 27 15:19:24 KST 2023

		==> 객체는 한번만 생성
		 */

	}

}
