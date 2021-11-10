package JavaRush.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Array {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int a = Integer.parseInt(reader.readLine());
//        int b = Integer.parseInt(reader.readLine());

        myTwoDimentionalArray(4,4);
//        myArray(a);
    }

    public static int[][] myTwoDimentionalArray (int a, int b){

        int [][] array = new int[a][b];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[j][2] = 5;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    public static int[] myArray(int a){
        int [] array = new int[a];
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);


        }
        return array;
    }

}

