package main.com.beatBox.ch14.ex1;

import javax.swing.*;

/*
    p.505 GUI 버튼
 */
public class SimpleGui1 {
    public static void main(String[] args) {

        // 프레임과 버튼 만들기
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");           // (버튼 생성자에, 버튼에 표시할 텍스트를 전달할 수 있습니다.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // 이렇게 하면 창을 닫을 때 프로그램이 바로 종료, 이 행을 빼먹으면 화면에 계속 남아 있음

        frame.getContentPane().add(button);                      // 버튼을 프레임의 내용 틀(content pane)에 추가합니다.

        frame.setSize(300, 300);                   // 프레임의 크기를 픽셀 단위로 지정합니다.

        frame.setVisible(true);                                 // 마지막으로 화면에 표시되도록 설정 (이 단계를 추가하지 않으면 코드를 실행했을 때 아무것도 표시되지 않음)
    }
}
