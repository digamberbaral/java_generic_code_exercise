package java_generic_code_exercise.interview_problem;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Palindrome {

    public static boolean isPalindrome(String str){
        int p1 = 0;
        int p2 = str.length() - 1;
        while(p1 <= p2){
            if (str.charAt(p1) != str.charAt(p2)){
                return false;
            }
            p1++;

            p2--;
        }

        return true;
    }
    public static boolean isPalindrome2(String str){
        return IntStream.range(0, str.length()/2).
                noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i -1));
    }

    public static void main(String[] args) {
    final int[] arr = new int[5];
    arr[0] = 1;
    arr[1] = 2;
        System.out.println(Arrays.toString(arr));
    String str = "madam";
    if(isPalindrome2(str)){
        System.out.println(str + "' is a palindrome...");
    } else {
        System.out.println(str + "' is not a palindrome...");
    }

    }

}
