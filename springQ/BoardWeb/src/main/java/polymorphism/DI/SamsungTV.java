package polymorphism.DI;

import polymorphism.DIchange.Speaker;

public class SamsungTV implements TV{

	private Speaker speaker;
	private int price;


	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성 ");
	}

	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성 ");
		this.speaker = speaker;
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생");
		this.speaker = speaker;
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다. (가격 : " +price+" )");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}
