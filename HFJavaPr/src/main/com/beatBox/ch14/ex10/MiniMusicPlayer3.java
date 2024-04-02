package main.com.beatBox.ch14.ex10;

import javax.sound.midi.*;
import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.sound.midi.ShortMessage.*;

/*
    p. 543 버전 3 : 음악에 맞춰서 그래픽을 표시하는 프로그램
 */
public class MiniMusicPlayer3 {
    private MyDrawPanel panel;
    private Random random = new Random();

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui() {
        JFrame frame = new JFrame("My First Music Video");
        panel = new MyDrawPanel();
        frame.setContentPane(panel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
        setUpGui();

        try{
            /* Sequencer를 만들고 열기 */
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(panel, new int[]{127});

            /* Sequence와 Track을 하나씩 만들기 */
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int note;
            for(int i = 0; i < 60; i += 4) {
                note = random.nextInt(50) + 1;
                track.add(makeEvent(NOTE_ON, 1, note, 100, i));
                track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));
                track.add(makeEvent(NOTE_OFF, 1, note, 100, i + 2));
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

    public class MyDrawPanel extends JPanel implements ControllerEventListener {

        // 일단 플래그를 false로 설정한 다음 이벤트를 받을 때만 true로 설정합니다.
        private boolean msg = false;

        /* (ControllerEvent 리스너 인터페이스의) 이벤트 핸들러 메서드.
            패널에서 ControllerEvent를 기다려야 하기 때문에 이번에는 람다 표현식을 쓰지 않아요.
         */
        @Override
        public void controlChange(ShortMessage event) {
            msg = true;         // 이벤트를 받았으므로 플래그를 true로 설정하고
            repaint();          // repaint()를 호출
        }

        public void paintComponent(Graphics g) {
            // 다른 이유로 인해 repaint()가 호출될 수도 있는데, ControllerEvent가 발생한 경우에만 그림을 다시 그려야 하므로 플래그를 써야합니다.
            if (msg) {
                int r = random.nextInt(250);
                int gr = random.nextInt(250);
                int b = random.nextInt(250);

                g.setColor(new Color(r, gr, b));

                int height = random.nextInt(120) + 10;
                int width = random.nextInt(120) + 10;

                int xPos = random.nextInt(40) + 10;
                int yPos = random.nextInt(40) + 10;

                g.fillRect(xPos, yPos, width, height);
                msg = false;
            }
        }
    }

}
