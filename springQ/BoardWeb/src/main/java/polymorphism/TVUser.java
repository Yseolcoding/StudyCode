package polymorphism;

public class TVUser {
	public static void main(String[] args) {
		
		SamsungTV tv = new SamsungTV();
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}
}
