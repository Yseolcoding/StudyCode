package main.com.beatBox.ch13.ex2;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;

/*
    p. 490 버전 1: 첫번째 사운드 애플리케이션 만들기
 */
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
            msg1.setMessage(NOTE_ON, 1, 44, 100);                   // "44번 음표를 연주하는 것을 시작해라"
            MidiEvent noteOn = new MidiEvent(msg1, 1);                              // 지시사항은 메시지에 들어 있지만, MidiEvent에서는 그 지시사항을 가동할 시기를 추가해줍니다. 이 MidiEvent에서는 'a'라는 메시지를 첫번째 박자(1번 비트)에서 가동시키도록 지정했습니다.
            track.add(noteOn);                                                           // Track에 MidiEvent 객체가 저장됩니다. Sequence에서는 각 이벤트가 일어나야할 시기를 바탕으로 Track을 정리하고 Sequencer에서는 그렇게 주어진 순서에 따라 음악을 재생합니다.
                                                                                         // 정확하게 똑같은 시각에 이벤트 여러개가 동시에 일어날 수도 있습니다. 예를 들어서, 음표 두 개를 동시에 연주하거나 서로 다른 악기를 동시에 연주할 수 있습니다.

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

/*
    setMessage의 첫번째 인자는 언제나 메시지 '유형'을 나타내는 값, 나머지 인자 세 개의 의미는 메시지 유형에 따라 바뀜
    NOTE_ON, NOTE_OF (연주시작[144], 연주종료[128])
    Channel : 어떤 악기? (밴드에 있는 연주자라고 생각, 1번 채널은 1번 키보드 연주자, 9번 채널은 드러머처럼)
    data1 : 음 (0 ~ 127, 숫자가 높을수록 높은 음)
    data2 : 건반을 누르는 속도 (0은 가장 부드럽게 누르는 것으로 거의 소리가 들리지 않고, 보통 기본값으로 100 정도를 씁니다.)
 */