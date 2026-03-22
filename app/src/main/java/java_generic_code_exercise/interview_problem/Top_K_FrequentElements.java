package java_generic_code_exercise.interview_problem;
import java.util.Scanner;

public class Top_K_FrequentElements {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        for(int i=0; i<3; i++){
            System.out.println("Enter a number: ");
            int number = scanner.nextInt();
            System.out.println("You entered: " + number);
            numbers[i] = number;
        }
        System.out.println("Numbers entered: ");
        for(int num : numbers){
            System.out.println(num);
        }
    }
}
