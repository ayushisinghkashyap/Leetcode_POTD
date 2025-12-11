class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        
        for (int i = 0; i < nums.length - 1; i++) {
            int s = i + 1, e = nums.length - 1;
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (sum < target) s++;
                else e--;
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}