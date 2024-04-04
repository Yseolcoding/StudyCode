package main.com.beatBox.ch15.ex4;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.sound.midi.ShortMessage.*;

/*
    p. 572 비트박스 코드
 */
public class BeatBox {
    // checkbox를 ArrayList에 저장
    private ArrayList<JCheckBox> checkBoxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    // GUI 레이블을 만들 때 사용할 악기명을 String 배열로 저장
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
                                "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
                                "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Tonga"};
    // 실제 드럼 '건반'을 나타냅니다. 드럼 채널은 피아노랑 비슷한데, 각 '건반'이 서로 다른 드럼이라고 보면 됩니다.
    // 35번 건반은 베이스 드럼, 42번 건반은 클로즈 하이햇 같은 식입니다.
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    public void buildGUI() {
        JFrame frame = new JFrame("Cyber Beatbox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        // '빈 경계선'을 사용하면 패널의 모소리와 구성요소가 배치되는 자리 사이에 빈 공간을 만들 수 있습니다.
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e -> buildTrackAndStart());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> sequencer.stop());
        buttonBox.add(stop);

        /* 기본 템포는 1.0이기 때문에 클릭할 때마다 +/- 3%씩 바꿔줍니다. */
        JButton unTempo = new JButton("Tempo Up");
        unTempo.addActionListener(e -> changeTempo(1.03f));
        buttonBox.add(unTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(e -> changeTempo(0.97f));
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String instrumentName : instrumentNames) {
            JLabel instrumentLabel = new JLabel(instrumentName);
            // 각 악기 이름마다 경계선을 더해 주면 checkbox랑 줄을 맞추는 데 도움이 됩니다.
            instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
            nameBox.add(instrumentLabel);
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

        // 또 다른 레이아웃 관리자. 이 관리자는 구성요소들을 행과 열이 있는 격자에 집어넣을 수 있게 해줍니다.
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);

        JPanel mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        // checkbox를 만들고 몬든 값을 (체크되지 않도록) false로 설정하고 ArrayList에 추가한 다음 GUI 패널에 집어 넣습니다.
        checkBoxList = new ArrayList<>();
        for (int i = 0; i< 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 여기부터가 중요. checkbox의 상태를 미디 이벤트로 바꾼 다음 그 이벤트를 Track에 추가합니다.
    // 각 악기의 열여섯 개의 박자에 대한 값을 원소가 16개인 배열에 저장합니다.
    // 어떤 악기가 특정 박자에서 연주되어야 하면 그 원소의 값에 건반 번호를 넣습니다.
    // 그 박자에서 그 악기가 연주되어야 하지 않는다면 0을 집어넣습니다.
    private void buildTrackAndStart() {
        int[] trackList;

        // 기존 Track 제거 후 새 Track 생성
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        // 16개의 열(베이스, 콩가(타악기의 일종) 등) 각각에 대해 같은 작업을 처리합니다.
        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            // 이 악기가 무엇(베이스, 하이햇 등) 인지를 나타내는 '건반'을 설정합니다. instruments 배열에 각 악기의 실제 미디 번호가 저장되어있습니다.
            int key = instruments[i];

            // 이 행의 각 박자에 대해 같은 작업을 반복합니다.
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkBoxList.get(j + 16 * i);

                // 이 박자의 checkbox가 선택되었는지 확인.
                // 선택됐으면 배열의 해당 칸(이 박자를 나타내는 칸)에 건반 값을 집어넣습니다.
                // 선택되지 않았으면 그 악기를 이 박자에서 연주하면 안 되기 때문에 0으로 설정합니다.
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            // 이 악기의 열여섯 박자 전체에 대해서 이벤트를 만들고 Track에 추가합니ㅏㄷ.
            makeTracks(trackList);
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16));
        }

        // 16번째 박자에는 반드시 이벤트가 있어야합니다. 이렇게 하지 않으면 다시 시작하기 전에 16박자가 모두 끝나지 않을수도 있습니다.
        track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 15));

        try {
            sequencer.setSequence(sequence);
            // 루프 반복 횟수를 지정하기 위한 메서드 여기에서는 계속 반복할 수 있도록 sequencer.LOOP_CONTINUOUSLY를 인자로 넘깁니다.
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();  // 재생
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void changeTempo(float tempoMultiplier) {
        // tempoFactor는 주어진 인수만큼 Sequencer의 템포를 바꿔 줍니다. 박자를 느리거나 빠르게 조절할 수 있죠.
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
    }

    // 한 악기의 16박자 전체에 대해 이벤트를 만듭니다.
    // 예를 들어, 베이스 드럼을 위한 int[] 배열을 받아오면 그 안에는 배열의 각 인덱스별로 그 악기의 건반 번호 또는 0이 들어있습니다.
    // 그 값이 0이면 그 박자에서는 그 악기를 연주하지 않는 것이고, 0이 아니면 이벤트를 만들고 Track에 추가해 줍니다.
    private void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(NOTE_ON, 9, key, 100, i));
                track.add(makeEvent(NOTE_OFF, 9, key, 100, i + 1));
            }
        }
    }

    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        MidiEvent event = null;

        try{
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chnl, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return event;
    }

}
