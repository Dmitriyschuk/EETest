package JavaRush.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class FirstBigCharacters {
    public static void main(String[] args) throws Exception{


                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String string = reader.readLine();
                string = string.trim();
                String[] list = string.split("\\s+");

                String bigWords = "";

                for (String str: list
                ) {
                    String charBig= str.substring(0,1).toUpperCase();
//            System.out.println(charBig);
                    StringBuilder strBuilder = new StringBuilder(str);
                    strBuilder.replace(0,1, charBig);
                    String result = strBuilder.toString();
                    bigWords = bigWords.concat(result + " ");

                }
                System.out.println(bigWords);
            }
        }


