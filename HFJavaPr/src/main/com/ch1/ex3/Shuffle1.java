package main.com.ch1.ex3;

/*
    p.62 코드 자석
 */
public class Shuffle1 {
    public static void main(String[] args) {
        int x = 3;

        while( x>0 ){

            if(x > 2)  {
                System.out.print("a");
            } else if (x == 2) {
                System.out.print("b c");
            } else if (x == 1) {
                System.out.print("d");
                x = x - 1;
                break;
            }
            x = x - 1;
            System.out.print("-");

        }
    }
}
