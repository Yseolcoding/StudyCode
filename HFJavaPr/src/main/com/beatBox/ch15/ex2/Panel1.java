package main.com.beatBox.ch15.ex2;

import javax.swing.*;
import java.awt.*;

/*
    p.560 패널 그리기
 */
public class Panel1 {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.blue);

        JButton button = new JButton("shock me");
        JButton buttonTwo = new JButton("bliss");
        JButton buttonThree = new JButton("Huh?");

        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);

        frame.getContentPane()
             .add(BorderLayout.EAST, panel);
        frame.setSize(250, 200);
        frame.setVisible(true);
    }
}

/*
    의도한 버튼의 배치는 수직으로 배치되는 것인데, 현재는 가로로 모든 버튼이 놓여지고 있습니다.
 */