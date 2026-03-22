package java_generic_code_exercise.interview_problem;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2; // Number of positions to rotate
        rotateArray(arr, k);
     //   rotateArrayOneByOne(arr, k);
        // int[] rotatedArr = rotateArrayUsingExtraSpace(arr, k);
        // System.out.println("Rotated Array using extra space: ");
        // for (int num : rotatedArr) {
        //     System.out.print(num + " ");
        // }
        System.out.print("Rotated Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // In case k is greater than array length
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static int[] rotateArrayUsingExtraSpace(int[] arr, int k) {
        int n = arr.length;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = arr[i];
        }
        return rotated;
    }

    private static void rotateArrayOneByOne(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // In case k is greater than array length
        for (int i = 0; i < k; i++) {
            int last = arr[n - 1];
            for (int j = n - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = last;
        }
    }
}