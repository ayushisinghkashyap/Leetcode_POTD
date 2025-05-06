class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int sum =0;
        int poss = 0;
        if(poss ==0){
            for(int i=0;i<nums.length;i++){
                
                if(nums[i]>0){
                    poss = 1;
                    break;
                }
                else{
                    maxsum = Math.max(nums[i],maxsum);
                }
            }
        }
        if (poss == 1){
            for(int i =0;i<nums.length;i++){
                sum += nums[i];
                if(sum <0){
                    sum = 0;
                }

                maxsum = Math.max(sum,maxsum);
            }
        }


        return maxsum;
    }
}