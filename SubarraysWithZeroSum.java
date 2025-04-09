import java.util.*;

public class SubarraysWithZeroSum {
    public static void findSubarrays(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(sum, new ArrayList<>());
        map.get(sum).add(-1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                for (int index : map.get(sum)) {
                    System.out.println("Subarray: [" + (index + 1) + ", " + i + "]");
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, -1, 3, -2, 4, -3};
        findSubarrays(nums);
    }
}
