package main.com.ch5.ex1_SSGv1.code;

import java.util.Scanner;

public class GameHelperV1 {
    public int getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
