package main.com.beatBox.ch14.ex9;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.*;

/*
    p. 542 버전 2 : ControllerEvent를 등록하고 받는 방법
 */
public class MiniMusicPlayer2 {
    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void go() {
        try{
            /* Sequencer를 만들고 열기 */
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            /* 이벤트를 Sequencer에 등록합니다.
            이 이벤트 등록 메서드에서는 리스너와 필요한 ControllerEvent의 목록을 나타내는 int배열을 인자로 받아들입니다.
            여기에는 127번 이벤트 하나만 필요합니다. */
            int[] eventsIWant = {127};
            // 이벤트를 받을때마다 명령줄에 "la"를 출력합니다. 여기서는 이 ControllerEvent를 처리하기 위해 람다 표현식 사용
            sequencer.addControllerEventListener(event -> System.out.println("la"), eventsIWant);

            /* Sequence와 Track을 하나씩 만들기 */
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            /* 음이 올라가는 순서대로 이벤트 여러 개를 만들기 (피아노로 5번 음에서 61번 음까지) */
            for(int i = 5; i < 61; i += 4) {
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));

                /* 박자를 골라내기 위해 필요한 코드. 이벤트 번호 127번을 인자로 전달하여 별도의 ControllEvent를 추가한다.
                이 이벤트는 사실 아무런 기능도 하지 않지만, 그냥 음이 연주될 때마다 이벤트를 받아오기 위해 집어넣을 뿐이다.
                그냥 음이 연주될때마다 이벤트를 받아오기 위해 집어넣을 뿐입니다.
                NOTE_ON, NOTE_OFF 이벤트는 우리가 받아올 수 없기 떄문에 간접적으로 이벤트 발생여부 확인용
                 */
                track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));

                track.add(makeEvent(NOTE_OFF, 1, i, 100, i + 2));
            }

            /* 시작 */
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chnl, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
