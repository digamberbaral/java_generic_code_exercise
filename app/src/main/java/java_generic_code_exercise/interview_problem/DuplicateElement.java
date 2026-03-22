package java_generic_code_exercise.interview_problem;

import java.util.HashSet;

public class DuplicateElement {
    
    public static boolean containsDuplicate(int[] nums) { // [1, 2, 3, 4, 5, 3, 6, 7, 8, 2]
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                System.out.println("Duplicate element found: " + num);
                return true;
            } else {
                set.add(num);
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 6, 7, 8, 2};
        System.out.println(containsDuplicate(arr));
    }

}
