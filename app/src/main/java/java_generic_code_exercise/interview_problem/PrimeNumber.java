package java_generic_code_exercise.interview_problem;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    // A number who is divisible by 1 & itself and only have two factors is called a prime number.
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Found a factor, so it's not prime
            }
        }
        return true; // No factors found, so it's prime
    }

    public static List<Integer> findAllPrimeNumber(int range) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= range; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;

    }

    public static void main(String[] args) {
        int range = 100; // You can change this to any range you want
        List<Integer> primeNumbers = findAllPrimeNumber(range);
        System.out.println("Prime numbers up to " + range + ": " + primeNumbers);
    }
}
