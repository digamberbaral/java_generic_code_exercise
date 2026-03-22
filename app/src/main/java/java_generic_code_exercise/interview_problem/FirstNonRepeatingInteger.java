package java_generic_code_exercise.interview_problem;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingInteger {

    public static Integer findFirstNonRepeating(int[] nums) { // [1, 2, 3, 4, 5, 3, 6, 7, 8, 2]
        int[] count = new int[10]; // Assuming the integers are in the range 0-9

        for (int num : nums) {
            count[num]++;
        }

        for (int num : nums) {
            if (count[num] == 1) {
                System.out.println("First non-repeating element found: " + num);
                return num;
            }
        }

        System.out.println("No non-repeating element found.");
        return null; // Return null if there is no non-repeating element
    }

    public static Integer findFirstNonRepeatingUsingHashMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // for (int num : nums) {
        // countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        // }
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }

        for (int num : nums) {
            if (countMap.get(num) == 1) {
                System.out.println("First non-repeating element found using HashMap: " + num);
                return num;
            }
        }

        System.out.println("No non-repeating element found using HashMap.");
        return null; // Return null if there is no non-repeating element
    }

    public static void main(String[] args) {
        int[] arr = { 5,5,6,6,7,8,9,9 };
    //    System.out.println(findFirstNonRepeating(arr));
        System.out.println(findFirstNonRepeatingUsingHashMap(arr));
    }
}
