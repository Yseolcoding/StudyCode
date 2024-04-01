package main.com.beatBox.ch14.ex7;

import main.com.beatBox.ch14.ex4.MyDrawPanel;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SimpleAnimation {

    // 메인 GUI 클래스에 원의 x와 y 좌표를 저장하기 위한 인스턴스 변수 두 개를 만듭니다.
    private int xPos = 70;
    private int yPos = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for(int i = 0; i < 130; i++){
            xPos++;
            yPos++;

            // 스스로 다시 칠하기
            drawPanel.repaint();

            try{
                // 그림을 다시 그릴 때 마다 잠깐씩 쉬기
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class MyDrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillOval(xPos, yPos, 40, 40);
        }
    }

}

/*
    예제에서는 이 코드대로 동작시키면, 그려졌던 원이 지워지지 않아 길게 선이 그어졌었는데
    실제로 실행시에는 원래 의도대로 원이 동작하기만 함.
    gpt 확인시에도,
    기본적으로 paintComponent 메소드는 컴포넌트를 다시 그릴 때마다 전체 화면을 지우고 다시 그리도록 설계되어 있습니다.
    따라서, 이전의 원들이 화면에 남아있게 하려면, 이전에 그렸던 원들의 위치를 저장하고, 각각을 다시 그리는 방식으로 구현해야 합니다.
    이렇게 확임됨.
 */