import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MyFunctions {
    //    function-predicate for second task
    public static Predicate<List<String>> hasUpperStrings = (s) -> {
        int count = (int) s.stream()
                .map(element -> element.substring(0, 1))
                .filter(element -> !element.equals(element.toLowerCase()))
                .count();
        return count > 2;
    };

    //    function for sum of two numbers
    public static BiFunction<Integer, Integer, Integer> plus = (a, b) -> a + b;

//    function for difference between two numbers

    public static BiFunction<Integer, Integer, Integer> minus = (a, b) -> {
        if (a > b) {
            return a - b;
        } else {
            return b - a;
        }
    };

    //    function for multiply of two numbers
    public static BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

    //    function for devide of two numbers
    public static BiFunction<Integer, Integer, Integer> devide = (a, b) -> {
        int result = 0;
        try {
            if (a > b) {
                result = a / b;
            } else {
                result = b / a;
            }
        } catch (ArithmeticException ex) {
            throw new ArithmeticException("One problem: / by zero");
        }
        return result;
    };

    public static Supplier<Integer> returnRandomNumbers = () -> {
        Random rnd = new Random();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rnd.nextInt(10);
    };
}
