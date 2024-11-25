package Turing;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter length of number");
        int lengthOfNumber = sc.nextInt();
        int attemptCounter = 0;
        int low = (int) Math.pow(10, lengthOfNumber-1);
        int hi = low * 10;
        int randomNumber = new Random().nextInt(low, hi);
        System.out.println(randomNumber);
        int[] randomNumberArr = new int[lengthOfNumber];
        for (int i = randomNumberArr.length-1; i>=0; i--) {
            randomNumberArr[i] = randomNumber%10;
            randomNumber /=10;
        }
        while (true) {
            attemptCounter++;
            int yellowCounter = 0;
            int greenCounter = 0;
            int userNumber = sc.nextInt();
            int[] userArr = new int[lengthOfNumber];
            for (int i = userArr.length-1; i >=0 ; i--) {
                userArr[i]=userNumber%10;
                userNumber /=10;
            }
            for (int i = 0; i < userArr.length; i++) {
                if(userArr[i] == randomNumberArr[i]){
                    greenCounter++;
                }
                else{
                    for (int j = 0; j < randomNumberArr.length; j++) {
                        if(userArr[i] ==randomNumberArr[j] && i !=j ){
                            yellowCounter++;
                        }
                    }
                }
            }

            if(greenCounter == randomNumberArr.length){
                System.out.println("you win" + "," + "attempt: " + attemptCounter);
                break;
            }
            else
                System.out.println(greenCounter + "green" + ","+ yellowCounter+ "yellow");
        }
    }
}
