import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        fragment for first task
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        List<Integer> newList = filterNumbers(list);
        for (int i : newList) {
            System.out.println(i);
        }

//      fragment for second task
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("candy");
        stringList.add("Pineapple");
        stringList.add("strawberry");
        stringList.add("Pear");
        System.out.println(MyFunctions.hasUpperStrings.test(stringList));

//      fragment for third task
        Map<MathOperations, BiFunction<Integer, Integer, Integer>> mapOfMethods = createMap();
        for (Map.Entry<MathOperations, BiFunction<Integer, Integer, Integer>> entry : mapOfMethods.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().apply(1, 2));
        }

//      fragment for fourth task
        Stream.generate(MyFunctions.returnRandomNumbers)
                .map(element -> (int) Math.pow(element, 3))
                .limit(100)
                .filter(element -> element > 100)
                .forEach(System.out::println);
    }


    //    method for first task
    public static List<Integer> filterNumbers(List<Integer> list) {
        List<Integer> resultList;
        resultList = list.stream()
                .filter(element -> element % 2 == 0)
                .map(element -> element * element)
                .collect(Collectors.toList());
        return resultList;
    }


    public static Map<MathOperations, BiFunction<Integer, Integer, Integer>> createMap() {
        MathOperations enumPlus = MathOperations.PLUS;
        MathOperations enumMinus = MathOperations.MINUS;
        MathOperations enumDevide = MathOperations.DIVIDE;
        MathOperations enumMultiply = MathOperations.MULTYPLY;
        Map<MathOperations, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put(enumPlus, MyFunctions.plus);
        map.put(enumMinus, MyFunctions.minus);
        map.put(enumDevide, MyFunctions.devide);
        map.put(enumMultiply, MyFunctions.multiply);
        return map;
    }


}
