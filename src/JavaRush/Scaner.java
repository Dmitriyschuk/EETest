package JavaRush;

import java.util.Scanner;

public class Scaner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       System.out.println("Введите число ");
        if (scan.hasNextInt()) {
            int number = scan.nextInt();
            System.out.println("Вы ввели число " + number);
        }
        else {
            System.out.println("Нужно ввести число");
        }
        scan.close();
    }
}
