package main.com.ch8.ex1;

/*
    p. 276 수영장 퍼즐
 */
public class Of76 extends Clowns{
    public static void main(String[] args) {
        Nose[] i = new Nose[3];
        i[0] = new Acts();
        i[1] = new Clowns();
        i[2] = new Of76();

        for(int x = 0; x < 3; x++){
            //System.out.println(i[x].iMethod() + " " + i[x].getClass());
            // 예제에서는 패키지를 사용하지 않으나, 예제 업로드를 위해 임의로 패키지를 추가하여 출력문에 패키지 포함 전체 내용이 출력되어 아래처럼 수정함. (24.03.14)
            System.out.println(i[x].iMethod() + " class " + i[x].getClass().getSimpleName());
        }

    }
}

interface Nose {
    public int iMethod();
}

abstract class Picasso implements Nose {
    public int iMethod() {
        return 7;
    }
}

class Clowns extends Picasso {};

class Acts implements Nose {
    @Override
    public int iMethod() {
        return 5;
    }
}