package java_generic_code_exercise.interview_problem;

public class First_Last_SortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);

        return result;
    }

    public static int findFirst(int[] nums, int target){
        int left  = 0;
        int right = nums.length - 1;
        int result = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                result = mid;
                right = mid - 1; // continue searching in the left half
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findLast(int[] nums, int target){
        int left  = 0;
        int right = nums.length - 1;
        int result = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                result = mid;
                left = mid + 1; // continue searching in the right half
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = searchRange(nums, target);
        for(int value : result) {
            System.out.print(value + " ");
        }
    }
}
