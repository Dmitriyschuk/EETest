


public class SummaChisla {
    public static void main(String[] args) {
//        sumFor(1234);
        System.out.println(sum(1234));
        System.out.println(sumFor(1234));
        System.out.println(1234%10);

    }

    public static int sum(int value){
        int result=0;

        while (value !=0){
            result +=value % 10;
            value /=10;
        }
        return result;
    }


    public static int sumFor(int value) {
        int result = 0;
        int currentValue = value;
        for (int correntValue = value; correntValue != 0; correntValue /= 10) {
            result += correntValue % 10;
        }
        return result;


    }

}