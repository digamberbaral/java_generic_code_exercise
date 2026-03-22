package java_generic_code_exercise.interview_problem;

public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int p1=0;
        int p2=0;
        int k=1;
        int size = nums.length;
        if(size <=0) return 0;
        if(size == 1) return k;

        while(p2 < size){
            if(nums[p1] == nums[p2]){
                p2++;
            }
            if(nums[p1] != nums[p2]){
                k++;
                p1++;
                nums[p1] = nums[p2];
                p2++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,4,5,5};
        RemoveDuplicateFromSortedArray solution = new RemoveDuplicateFromSortedArray();
        int result = solution.removeDuplicates(nums);
        System.out.println("Number of unique elements: " + result);
    }
}
