package main.com.beatBox.ch14.ex3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    p. 510 버튼의 ActionEvent를 받는 법
 */
public class SimpleGui2_1 implements ActionListener {     // 인터페이스 구현하기. (= SimpleGui2의 인스턴스는 ActionListener임)
                                                        // 버튼에서는 ActionListener를 구현한 클래스에만 이벤트를 보내줍니다.
    private JButton button;

    public static void main(String[] args) {
        SimpleGui2_1 gui = new SimpleGui2_1();
        gui.go();
    }
    /*
        참고 : 이렇게 메인 GUI 클래스에서 ActionListener를 구현하는 경우는 잘 없습니다.
        그냥 처음이라서 최대한 간단한 방법을 보여 주기 위해서 이렇게 했을 뿐.
     */

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(this);             // 버튼에 등록합니다. 이 코드는 "나도 리스너 목록에 끼워 줘."라고 말하는 역할을 합니다. 이 때 전달되는 인자는 반드시 ActionListener를 구현한 클래스의 객체여야 합니다.

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {      // ActionListener 인터페이스의 actionPerformed 메서드 구현, 이 메서드가 바로 실제 이벤트를 처리하는 메서드입니다.
        button.setText("I've been clicked!");         // 버튼에서는 이 메서드를 호출하여, 이벤트가 일어났다는 것을 알려줌. ActionEvent 객체를 인자로 보내주는데, 여기에서는 그 객체를 쓸 필요가 없음.
    }
}
