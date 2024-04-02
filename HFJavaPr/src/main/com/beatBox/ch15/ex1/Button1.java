package main.com.beatBox.ch15.ex1;

import javax.swing.*;
import java.awt.*;

/*
    p. 556 버튼 추가
 */
public class Button1 {
    public static void main(String[] args) {
        Button1 gui = new Button1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}

/*
    BorderLayout은 java.awt 패키지에 들어있습니다.
 */