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

        JButton east = new JButton("East");
        JButton west = new JButton("West");
        JButton north = new JButton("North");
        JButton south = new JButton("South");
        JButton center = new JButton("Center");

        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.CENTER, center);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

/*
   전체 300px X 300px 짜리 프레임에서
   북쪽이나 남쪽에 뭔가를 집어넣으면 너비가 프레임 너비와 똑같아지기 때문에 북쪽과 남쪽지역이 비어있으면
   동쪽과 서쪽에 있는 구성요소의 높이는 원하는대로 맞출 수 없습니다.

   동쪽과 서쪽에 들어가는 구성요소는 너비만 원하는 대로 맞춰집니다.
   북쪽과 남쪽에 들어가는 구성요소는 높이만 원하는 대로 맞춰집니다.

   중앙에 들어가는 구성요소는 프레임 크기를 바탕으로 남는 공간을 할당받습니다.
 */