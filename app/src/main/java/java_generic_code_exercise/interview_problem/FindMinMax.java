package java_generic_code_exercise.interview_problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMinMax {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 1, 8, 50, 2, 90, 3, 1, 100, 4, 20);

        List<Integer> minList = numbers.stream().distinct().sorted().limit(3).toList();
        List<Integer> maxList = numbers.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).toList();

        System.out.println("Min: " + minList);
        System.out.println("Max: " + maxList);
    }
}
