package JavaRush;

import com.sun.source.tree.WhileLoopTree;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class VhodPotok {
    public static void main(String[] args) throws IOException {
        while (true){
//            int x = System.in.read();
//            System.out.print(x);
//            System.out.println();
            InputStreamReader reader = new InputStreamReader(System.in);
            while (true){
                int x = reader.read();
                System.out.println(x);
            }
        }


    }
}
