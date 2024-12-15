package Turing;


import java.util.Scanner;

public class weekPlanner {
   static String[][] schedule = new String[][] {
        {"Monday", "asda"},
           {"Tuesday","ajf"},
           {"Wednesday,","31312"},
           {"Thursday","dsfadsf"},
           {"Friday","uer"},
           {"Saturday","999"},
           {"Sunday","111"}
    };


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Please, input the day of the week");

            String text = sc.nextLine().toLowerCase().trim();
            if(text.contains("change")){
                set(text);
            }
            else{
                get(text);
            }
        }


    }
    public static void get(String text){
        String day=text.split(" ")[0];
        switch (day){
            case "monday":
                System.out.println(schedule[0][1]);
                break;
            case  "tuesday":
                System.out.println(schedule[1][1]);
                break;
            case "wednesday":
                System.out.println(schedule[2][1]);
                break;
            case "thursday":
                System.out.println(schedule[3][1]);
                break;
            case "friday":
                System.out.println(schedule[4][1]);
                break;
            case "saturday":
                System.out.println(schedule[5][1]);
                break;
            case "sunday":
                System.out.println(schedule[6][1]);
                break;
            default:
                System.out.println("dosent exist");
        }
    }
    public static void set(String text){
        Scanner sc = new Scanner(System.in);
        String day=text.split(" ")[1];
        switch (day){
            case "monday":

                schedule[0][1]=sc.nextLine();
                break;
            case  "tuesday":
                schedule[1][1]=sc.nextLine();
                break;
            case "wednesday":
                schedule[2][1]=sc.nextLine();
                break;
            case "thursday":
                schedule[3][1]=sc.nextLine();
                break;
            case "friday":
                schedule[4][1]=sc.nextLine();
                break;
            case "saturday":
                schedule[5][1]=sc.nextLine();
                break;
            case "sunday":
                schedule[6][1]=sc.nextLine();
                break;
            default:
                System.out.println("dosent exist");
        }
    }
}
