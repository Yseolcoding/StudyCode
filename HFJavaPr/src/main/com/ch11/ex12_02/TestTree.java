package main.com.ch11.ex12_02;

import java.util.Set;
import java.util.TreeSet;

/*
    p.396 Comparator를 인자로 받아들이는 TreeSet의 오버로드된 생성자 사용
    p.395 TreeSet에 관해 꼭 알아야 할 것들
 */
public class TestTree {
    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go() {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your body");
        Book b3 = new Book("Finding Emo");
        BookCompare bookCompare = new BookCompare();
        Set<Book> tree = new TreeSet<>(bookCompare);
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
    }
}

/*
    1. 이 코드를 컴파일하면 어떻게 될까?
    - 컴파일은 정상적으로 실행된다.
    2. 컴파일하고 나서 Test Tree 클래스를 실행하면 어떤 결과가 나올까요?
    - 예외가 발생됩니다.
    Exception in thread "main" java.lang.ClassCastException: class main.com.ch11.ex12.Book cannot be cast to class java.lang.Comparable (main.com.ch11.ex12.Book is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
	at java.base/java.util.TreeMap.compare(TreeMap.java:1569)
	at java.base/java.util.TreeMap.addEntryToEmptyMap(TreeMap.java:776)
	at java.base/java.util.TreeMap.put(TreeMap.java:785)
	at java.base/java.util.TreeMap.put(TreeMap.java:534)
	at java.base/java.util.TreeSet.add(TreeSet.java:255)
	at main.com.ch11.ex12.TestTree.go(TestTree.java:20)
	at main.com.ch11.ex12.TestTree.main(TestTree.java:11)
	3. (컴파일할 때나 실행할 때) 이 코드에 문제가 있다면 어떻게 고쳐야 할까요?
	- Book을 Compara ble로 만들거나 TreeSet에 Comparator를 전달합니다.
 */