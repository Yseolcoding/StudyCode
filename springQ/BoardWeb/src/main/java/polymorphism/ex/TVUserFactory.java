package polymorphism.ex;

public class TVUserFactory {
	public static void main(String[] args) {
		
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]); 
		//TV tv = new SamsungTVImpl();
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
	}
}
/*
 * 프로그램을 실행할 때 매개변수를 전달하지 않으면 예외 발생
 * 
 * [Run as] -> [Run Configurations...] -> [Arguments]를 선택하고,
 * 설정해 뒀던 매개변수 값을 입력하고 Run을 실행한다.
 */
