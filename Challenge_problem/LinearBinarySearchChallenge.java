import java.util.Arrays;

public class LinearBinarySearchChallenge {

    // Linear Search: Find first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct index position
        for (int i = 0; i < n; i++) {
            while (
                nums[i] > 0 &&
                nums[i] <= n &&
                nums[nums[i] - 1] != nums[i]
            ) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first index where the value is not correct
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Binary Search: Find index of target in sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        // Copy original array for binary search (since we modify it during linear search)
        int[] numsForBinary = Arrays.copyOf(nums, nums.length);

        // Linear Search Part
        int missing = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missing);

        // Binary Search Part
        Arrays.sort(numsForBinary);
        int index = binarySearch(numsForBinary, target);
        System.out.println("Index of " + target + " after sorting: " + index);
    }
}
