package main.com.ch16.ex1;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
    p. 589 클래스를 직렬화하려면 반드시 Serializable 구현
 */
// 구현해야하는 메서드는 없지만 'implements Serializable'이라고 하면 JVM에서 이 타입의 객체는 직렬화할 수 있다는 것을 알 수 있다.
public class Square implements Serializable {
    // 이 두 값이 저장된다.
    private int width;
    private int height;

    public Square(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {
        Square mySquare = new Square(50, 20);

        // 입출력 부분에서 예외를 던질 수 있다.
        try {
            // foo.ser이라는 이름의 파일이 있으면 그 파일에 연결하고 그렇지 않으면 그 이름을 가지는 파일을 새로 만든다.
            FileOutputStream fs = new FileOutputStream("foo.ser");
            // 연결 스트림에 연쇄되는 ObjectOutputStream을 만든다. 그리고 나서 그 객체를 저장하라는 명령을 낼니다.
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(mySquare);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
