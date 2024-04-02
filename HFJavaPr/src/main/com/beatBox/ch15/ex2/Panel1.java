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
        panel.add(button);

        frame.getContentPane()
             .add(BorderLayout.EAST, panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}

/*
    패널의 레이아웃 관리자(FlowLayout 관리자)가 버튼을 제어하고 프레임의 레이아웃 관리자(BorderLayout 관리자)가 패널을 관리합니다.

    패널이 확장되었습니다. 그리고 버튼은 너비와 높이가 모두 버튼이 원하는 크기로 맞춰집니다.
 */