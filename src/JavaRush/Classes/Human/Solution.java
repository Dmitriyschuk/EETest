package JavaRush.Classes.Human;

public class Solution {
        public static void main(String[] args) {
            // напишите тут ваш код
            Human grandPa = new Human("Aleksei", true, 90);
            Human grandMa = new Human("Tatyana", false, 85);
            Human grandPa2 = new Human("Grigory", true, 87);
            Human grandMa2 = new Human("Olesya", false, 81);
            Human father = new Human("Dima", true, 34,grandPa,grandMa);
            Human mother = new Human("Anna", false, 33,grandPa2,grandMa2);
            Human sunVlad = new Human("Vladislav", true, 7,father,mother);
            Human sunAndr = new Human("Andrey", true, 7,father,mother);
            Human doughterPolya = new Human("Polya", false, 1,father,mother);

            System.out.println(grandPa);
            System.out.println(grandMa);
            System.out.println(grandPa2);
            System.out.println(grandMa2);
            System.out.println(father);
            System.out.println(mother);
            System.out.println(sunVlad);
            System.out.println(sunAndr);
            System.out.println(doughterPolya);
        }
}
