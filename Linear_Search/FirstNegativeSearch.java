

public class FirstNegativeSearch {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, -2, 6, -7};
        int index = findFirstNegative(numbers);
        System.out.println("First negative number index: " + index);
    }
}
