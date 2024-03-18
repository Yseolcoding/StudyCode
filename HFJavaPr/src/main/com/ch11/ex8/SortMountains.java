package main.com.ch11.ex8;

import java.util.ArrayList;
import java.util.List;

/*
    p.385 리버스 엔지니어링
 */
public class SortMountains {
    public static void main(String[] args) {

        new SortMountains().go();

    }

    public void go() {
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(new Mountain("Longs", 14255));
        mountains.add(new Mountain("Elbert", 14433));
        mountains.add(new Mountain("Maroon", 14156));
        mountains.add(new Mountain("Castle", 14265));
        System.out.println("as entered:\n" + mountains);

        mountains.sort((one, two) -> one.name.compareTo(two.name));
        System.out.println("by name : \n" + mountains);

        mountains.sort((one, two) -> two.height - one.height);
        System.out.println("by height:\n" + mountains);
    }
}

/*
    리뷰 :
    다른 곳의 빈칸들은 수월하게 채워넣었는데,
    높이 내림차순 정렬에서, 어떤 식을 사용해서 비교해야하는지 알지 못했음.
    숫자의 경우, one에서 two를 빼는 방식으로 결과가 양수일때는 앞의 수가 크고, 음수일 경우에는 뒤의 수가 큰다라고 확인하는 방식으로 진행
 */