package java_generic_code_exercise.interview_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Goal: Group strings that are anagrams of each other together.

Input: ["eat", "tea", "tan", "ate", "nat", "bat"] 
Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]
*/

public class GroupAnagram {

    static final int MAX_CHAR = 26;
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            String frequencyKey = frequencyKey(str);
            System.out.println("String: " + str + " Frequency Key: " + frequencyKey);
            anagramMap.putIfAbsent(frequencyKey, new ArrayList<>());
            anagramMap.get(frequencyKey).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

/*    // For string "eat":
int[] freq = new int[26]; // [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
//                           a b c d e f g h i j k l m n o p q r s t u v w x y z

// After counting characters in "eat":
freq[4]++; // 'e' - 'a' = 4, so freq[4] = 1
freq[0]++; // 'a' - 'a' = 0, so freq[0] = 1  
freq[19]++; // 't' - 'a' = 19, so freq[19] = 1

// Final freq array:
// [1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0]
//  a b c d e f g h i j k l m n o p q r s t u v w x y z
//  1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0
 */

/*
StringBuilder keyBuilder = new StringBuilder();

// Loop through freq array [1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0]
for (int count : freq) {
    keyBuilder.append('#');    // Add delimiter
    keyBuilder.append(count);  // Add frequency count
}

// Result: "#1#0#0#0#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#0"
*/ 
    public static String frequencyKey(String str) {
        int[] freq = new int[MAX_CHAR]; // One slot for each letter a-z
        StringBuilder keyBuilder = new StringBuilder();
        // Count frequency of each character
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        // Append the frequency to construct the hash key
        for (int count : freq) {
            keyBuilder.append('#'); // Delimiter to avoid ambiguity
            keyBuilder.append(count);
        }

        return keyBuilder.toString();
    }

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(words));
    }
}
