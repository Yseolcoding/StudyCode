package polymorphism.ex;

public class TVUser {
	public static void main(String[] args) {
		
		TV tv = new SamsungTVImpl();
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}
}
