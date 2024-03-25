package main.com.beatBox.ch13.ex1;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/*
    p. 466 Sequencer 만들기
 */

public class MusicTest1 {
    public void play() {
        try{
            // Sequencer 객체가 필요합니다. 이 객체는 우리가 사용할 미디 장치, 미디 악기의 중십부입니다.
            // 모든 미디 정보를 '곡'으로 만들어주는 역할을 합니다. 하지만 새로운 객체를 직접 만들지 않고 MidiSystem에 객체를 요구하는 방법을 사용합니다.
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Successfully got a sequencer");
        } catch (MidiUnavailableException e) {
            System.out.println("Bummer");
        }
    }

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}

/*
    catch 문 없이 실행할 경우,
    컴파일러에서 예외를 잡아내거나 처리하지 않았다고 하면서 오류를 발생시킴.

    메서드 선언에서 throws 구문이 있다면, 위험 가능성이 있는 메서드입니다.
    따라서 그 메서드를 호출했을 때 생길 수 있는 위험 요인을 선언해야합니다.

 */