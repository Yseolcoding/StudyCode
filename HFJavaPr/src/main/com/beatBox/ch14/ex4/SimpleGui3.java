package main.com.beatBox.ch14.ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui3 implements ActionListener {
    private JFrame frame;

    public static void main(String[] args) {
        SimpleGui3 gui = new SimpleGui3();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change colors");
        button.addActionListener(this);                             // 리스너(this)를 버튼에 추가합니다.

        MyDrawPanel drawPanel = new MyDrawPanel();

        // 위젯(버튼과 그림 패널) 두 개를 프레임의 두 지역에 추가합니다.
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 사용자가 버튼을 클릭할 때마다 그림 패널의 paintComponent() 메서드가 호출됩니다.
        frame.repaint();
    }
}
