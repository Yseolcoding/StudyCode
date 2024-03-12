package main.com.ch5.ex2;

public class MultiFor {
    public static void main(String[] args) {
        for(int i = 0; i < 4; i++){
            for(int j = 4; j > 2; j--){
                if( i==1 ){
                    i++;
                }
                System.out.println(i + " " + j);
            }
        }
    }
}
