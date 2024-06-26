package main.com.ch16.ex3;

import java.io.*;

/*
    p. 596 객체 저장 및 불러오기
 */
public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big ex"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[]{"spells", "invisibility"});

        // 캐릭터의 상태 값을 바꿔 주는 작업을 하는 코드가 있다고 해 봅시다.

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("One's type: " + oneRestore.getType());
            System.out.println("Two's type: " + twoRestore.getType());
            System.out.println("Three's type: " + threeRestore.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
