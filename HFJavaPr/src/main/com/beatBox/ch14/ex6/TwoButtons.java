package main.com.beatBox.ch14.ex6;

import main.com.beatBox.ch14.ex4.MyDrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {
    private JFrame frame;
    private JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(event -> label.setText("Ouch!"));

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(event -> frame.repaint());

        label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    // 위에 람다로 대체
/*    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            label.setText("Ouch!");                                 // 내부 클래스에서 'label' 변수 사용 가능
        }
    }

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            frame.repaint();                                        // 내부 클래스에서는 외부 클래스 객체에 대한 레퍼런스 없이 그냥 'frame' 인스턴스 변수 사용 가능
        }
    }*/
}
