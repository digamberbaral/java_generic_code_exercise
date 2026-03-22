package java_generic_code_exercise.interview_problem;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] findTwoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] findTwoSumOptimized(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSumOptimized(numbers, target);
        if (result != null) {
            System.out.println("Indices of the two numbers are: " + Arrays.toString(result));
        } else {
            System.out.println("No two numbers found that add up to the target.");
        }
    }
}        
