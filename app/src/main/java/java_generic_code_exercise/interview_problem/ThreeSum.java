package java_generic_code_exercise.interview_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> bruteForceSolution(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		HashSet<List<Integer>> set = new HashSet<>();
		int n = nums.length;
		if(n<3)return result;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				for(int k=j+1; k<n; k++){
					if(nums[i]+nums[j]+nums[k] == 0){
						List<Integer> tempList = new ArrayList<>();
						tempList.add(nums[i]);
						tempList.add(nums[j]);
						tempList.add(nums[k]);
						Collections.sort(tempList);
						if(set.add(tempList)){
							result.add(tempList);
						}
					}
				}
			}
		}
		return result;
	}

	public List<List<Integer>> twoPointerSolution(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length;
		for(int i=0; i<n-2; i++){
			if(i>0 && nums[i] == nums[i-1]) continue; // skip duplicates
			int left = i+1;
			int right = n-1;
			while(left < right){
				int sum = nums[i] + nums[left] + nums[right];
				if(sum == 0){
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while(left < right && nums[left] == nums[left+1]) left++; // skip duplicates
					while(left < right && nums[right] == nums[right-1]) right--; // skip duplicates
					left++;
					right--;
				}else if(sum < 0){
					left++;
				}else{
					right--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
	//	List<List<Integer>> result = threeSum.bruteForceSolution(nums);
		List<List<Integer>> result = threeSum.twoPointerSolution(nums);
		System.out.println(result);
	}
    
}