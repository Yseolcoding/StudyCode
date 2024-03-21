package main.com.ch11.ex12;

import java.util.Set;
import java.util.TreeSet;

/*
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

        Set<Book> tree = new TreeSet<>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
    }
}

/*
    1. 이 코드를 컴파일하면 어떻게 될까?
    - 컴파일은 정상적으로 실행된다.
    2.
 */