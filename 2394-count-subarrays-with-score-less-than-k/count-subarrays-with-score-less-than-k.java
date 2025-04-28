class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        
        long result = 0;
        long sum = 0;
        
        int i = 0;
        int j = 0;
        
        while (j < n) {
            sum += nums[j];
            
            while (i <= j && sum * (j - i + 1) >= k) {
                sum -= nums[i];
                i++;
            }
            
            result += (j - i + 1);
            j++;
        }
        
        return result;
    }
}