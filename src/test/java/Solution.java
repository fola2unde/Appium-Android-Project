import java.util.HashMap;
import java.util.Map;

public class Solution {

    //    TWO SUMS : Return indices of two sums
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), num};
            } else {
                map.put(nums[num], num);
            }
        }
        throw new IllegalArgumentException("No match");
    }
    }
