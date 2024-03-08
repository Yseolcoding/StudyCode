package main.com.ch4.ex1;

public class GoodDog {

    // 인스턴스 변수를 private으로 생성
    private int size;

    // getter와 setter 메서드는 public으로 생성
    public int getSize() {
        return size;
    }
    public void setSize(int s) {
        size = s;
    }

    void bark() {
        if (size > 60){
            System.out.println("Wooof! Wooof!");
        } else if (size > 14){
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }
    }

}
