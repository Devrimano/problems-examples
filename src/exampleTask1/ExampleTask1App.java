package exampleTask1;

import java.util.Scanner;

public class ExampleTask1App {
       public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int foo = sc.nextInt();
            sc.close();
            if (foo > 0)
                System.out.println("input is positive");
            else
                System.out.println("input is negative");
        }
    }


