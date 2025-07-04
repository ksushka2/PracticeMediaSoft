package Lambda;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//Задание 1
        System.out.println("\nN1:");
        Printable printer = () -> System.out.println("Hello world!");
        printer.print();

//Задание 2
        Predicate<String> Check1 = str -> str != null;
        Predicate<String> Check2 = str -> !str.isEmpty();
        Predicate<String> Check3 = Check1.and(Check2);

        String check1 = null;
        String check2 = "";
        String check3 = "Hello";

        System.out.println("\nN2:");
        System.out.println("Check1 null: " + Check1.test(check1));
        System.out.println("Check2 null: " + Check2.test(check2));
        System.out.println("Check3 null: " + Check3.test(check3));

//Задание 3
        Predicate<String> FirstChar = str -> {
            if (str.isEmpty() || str == null)
            {
                return false;
            }
            char first = str.charAt(0);
            return first == 'J' || first == 'N';
        };

        Predicate<String> EndChar = str -> {
            if (str.isEmpty() || str == null)
            {
                return  false;
            }
            char end = str.charAt(str.length()-1);
            return end == 'A';
        };

        Predicate<String> CheckNJA = FirstChar.and(EndChar);

        System.out.println("\nN3:");
        System.out.println(CheckNJA.test("JAVA"));
        System.out.println(CheckNJA.test("Null"));
        System.out.println(CheckNJA.test("NAVA"));
        System.out.println(CheckNJA.test("zero"));

//Задание 4
        Consumer<HeavyBox> Shipment = box -> System.out.println("Отгрузили ящик с весом " + box.getWeight());
        Consumer<HeavyBox> Send = box -> System.out.println("Отправляем ящик с весом " + box.getWeight());

        Consumer<HeavyBox> andThen = Shipment.andThen(Send);

        HeavyBox Box = new HeavyBox(49);

        System.out.println("\nN4:");
        andThen.accept(Box);

//Задание 5
        Function<Integer, String> NumberCheck = num ->{
            if (num > 0)
            {
                return "Положительное число";
            }
            else if (num < 0)
            {
                return "Отрицательное число";
            }
            else
            {
                return "Ноль";
            }
        };
        System.out.println("\nN5:");
        System.out.println(NumberCheck.apply(11));
        System.out.println(NumberCheck.apply(0));
        System.out.println(NumberCheck.apply(-11));

//Задание 6
        Supplier<Integer> NumberRandom = () ->{
            Random random = new Random();
            return  random.nextInt(26);
        };
        System.out.println("\nN6:");
        System.out.println("Random test 1: " + NumberRandom.get());
        System.out.println("Random test 2: " + NumberRandom.get());
    }
}