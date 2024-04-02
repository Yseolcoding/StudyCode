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
        frame.getContentPane()
             .add(BorderLayout.EAST, panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
