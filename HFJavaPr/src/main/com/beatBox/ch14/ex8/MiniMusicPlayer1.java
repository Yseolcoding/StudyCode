package main.com.beatBox.ch14.ex8;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;
/*
    p. 541 버전 1: 정적 makeEvent() 메서드 활용법
 */
public class MiniMusicPlayer1 {
    public static void main(String[] args) {
        try{
            /* Sequencer를 만들고 열기 */
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            /* Sequence와 Track을 하나씩 만들기 */
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            /* 음이 올라가는 순서대로 이벤트 여러 개를 만들기 (피아노로 5번 음에서 61번 음까지) */
            for(int i = 5; i < 61; i += 4) {
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));
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
