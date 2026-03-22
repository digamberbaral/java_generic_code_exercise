package java_generic_code_exercise.interview_problem;

public class ReverseWordsInString {

    public static String reverseWordsUsingTwoPointers(String sentence){
        sentence = sentence.trim();
        String[] words = sentence.split("\\s+");
        int left = 0;
        int right = words.length - 1;

        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);
    }

    public static String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();
        // Split the string by one or more spaces
        String[] words = s.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        
        // Reverse the order of words
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    }

    public static void main(String[] args) {
       String input = "  Hello   World  ";
       String output = reverseWords(input);
       System.out.println("Reversed Words: '" + output + "'"); 
    }

}
