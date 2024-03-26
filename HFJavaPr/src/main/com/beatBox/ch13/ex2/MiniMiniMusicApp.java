package main.com.beatBox.ch13.ex2;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;

public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
    }

    public void paly() {
        try{
            // 1. Sequencer를 받아서 엽니다. Sequencer는 자동으로 열리지 않기 때문에 그래야만 쓸 수 있습니다.
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            // 2. Sequence 생성자로 넘기는 인자에 대해서는 신경쓰지 않아도 됩니다.
            // 그냥 그대로 입력해서 쓰세요 (그냥 원래 이런 인자를 쓴다고 생각하면 됩니다.)
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            // 3. Sequence에 Track을 요청합니다.
            // Track은 Sequence에 들어있고, 미디 데이터는 Track에 들어 있으니까요.
            Track track = seq.createTrack();

            // 4. Track에 MidiEvent를 집어넣습니다. 이 부분은 거의 인스턴스 코드라고 보면 됩니다.
            // 중요한 부분은 setMessage() 메서드에 대한 인자와 MidiEvent 생성자에 대한 인자입니다.
            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(NOTE_ON, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(msg1, 1);
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(NOTE_OFF, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 16);
            track.add(noteOff);

            // Sequencer에 Sequence를 보냅니다. (CD 플레이어에 CD를 집어넣는 것과 마찬가지입니다.)
            player.setSequence(seq);

            // Sequencerdp start() 메서드를 호출합니다. (CD 플레이어의 재생 버튼을 누르는 것과 비슷합니다.)
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
