package main.com.ch16.ex4;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
    p. 604 전자식 암기장 만들기
 */
public class QuizCardBuilder {
    private ArrayList<QuizCard> cardList = new ArrayList<>();
    private JTextArea question;
    private JTextArea answer;
    private JFrame frame;

    public static void main(String[] args) {
        new QuizCardBuilder().go();
    }

    public void go() {
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        question = createTextArea(bigFont);
        JScrollPane qScroller = createScroller(question);
        answer = createTextArea(bigFont);
        JScrollPane aScroller = createScroller(answer);

        mainPanel.add(new JLabel("Question: "));
        mainPanel.add(qScroller);
        mainPanel.add(new JLabel("Answer: "));
        mainPanel.add(aScroller);

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(e -> nextCart());
        mainPanel.add(nextButton);

        /* 메뉴 막대를 만들고 File 메뉴를 만들고 File 메뉴에 New와 Save 메뉴 항목을 집어넣습니다.
           메뉴를 메뉴 막대에 추가하고, 프레임에 이 메뉴 막대를 사용하라고 알려줍니다.
           메뉴 항목에서는 ActionEvent를 시작할 수 있습니다. */
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(e -> clearAll());

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> saveCard());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    private JScrollPane createScroller(JTextArea textArea) {
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }

    private JTextArea createTextArea(Font font) {
        JTextArea textArea = new JTextArea(6, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(font);
        return textArea;
    }

    private void nextCart() {
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cardList.add(card);
        clearCard();
    }

    private void saveCard() {
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cardList.add(card);

        /* 파일 대화상자를 불러오고 사용자가 대화 상자에서 save를 선택할 때까지 이 행에서 대기합니다.
           파일 선택과 같이 파일 대화상자에서 진행되는 여러 작업은 JFileChooser가 처리해 줍니다.*/
        JFileChooser fileSave = new JFileChooser();
        fileSave.showSaveDialog(frame);
        saveFile(fileSave.getSelectedFile());
    }

    // 새로운 카드 세트가 필요할 떄는 카드 리스트와 텍스트 영역을 깨끗하게 지워버려야 합니다.
    private void clearAll() {
        cardList.clear();
        clearCard();
    }

    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    /* 실제 파일에 대한 쓰기 작업을 처리하는 메서드입니다.
    *  SaveMenuListener의 이벤트 핸들러에서 이 메서드를 호출합니다.
    *  이 메서드에 대한 인자는 사용자가 저장하고자 하는 File 객체입니다.
    *  File 클래스에 대한 내용은 다음 페이지에서 살펴보겠습니다. */
    private void saveFile(File file) {
        try {
            // 쓰기 작업을 더 효율적으로 진행하기 위해 BufferedWriter를 새로운 FileWriter에 연결시킵니다.
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            // 카드 내용이 저장된 ArrayList를 전부 훑어 보면서 한 행에 한 카드 씩, 질문과 정답을 '/'로 구분하고 맨 뒤에는 줄바꿈 문자(\n)를 추가하여 저장합니다.
            for (QuizCard card : cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Couldn't write the cardList out: " + e.getMessage());
        }
    }

}
