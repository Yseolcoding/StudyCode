package main.com.ch16.ex2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
    p. 590 직렬화 불가 케이스
 */
public class Pond implements Serializable {             // Pond 객체는 직렬화될 수 있는 것으로 선언되어 있습니다.
    // Pond 클래스에는 Duck 인스턴스 변수 한 개가 있습니다.
    private Duck duck = new Duck();

    public static void main(String[] args) {
        Pond myPond = new Pond();
        try {
            FileOutputStream fs = new FileOutputStream("Pond.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(myPond);
            os.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/*
발생하는 Exception :
/Library/Java/JavaVirtualMachines/zulu-17.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=50794:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/seollucia/Practice/SpringPractice/HFJavaPr/out/production/HFJavaPr main.com.ch16.ex2.Pond
java.io.NotSerializableException: main.com.ch16.ex2.Duck
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1187)
	at java.base/java.io.ObjectOutputStream.defaultWriteFields(ObjectOutputStream.java:1572)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1529)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1438)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1181)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:350)
	at main.com.ch16.ex2.Pond.main(Pond.java:19)

Process finished with exit code 0

==> Pond도 Serializable이 안되어 있을 때
/Library/Java/JavaVirtualMachines/zulu-17.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=50785:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/seollucia/Practice/SpringPractice/HFJavaPr/out/production/HFJavaPr main.com.ch16.ex2.Pond
java.io.NotSerializableException: main.com.ch16.ex2.Pond
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1187)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:350)
	at main.com.ch16.ex2.Pond.main(Pond.java:18)

Process finished with exit code 0
 */