class Solution {
    public int singleNonDuplicate(int[] nums) {
        int num =0;
        int s = 0;
        int e = nums.length -1;
        if(nums.length == 1){
            return nums[0];
        }
        else{
        while (s < e){
            int count =0;
            if(nums[s] == nums[s+1] && s%2 == 0){
                s += 2;
            } 
            if(nums[e] == nums[e-1] && e%2 == 0){
                e -= 2;
            } 
            if(s<nums.length -2 && nums[s] != nums[s+1] ){
                num = nums[s];
                break;
            } 
            if(nums[e] != nums[e-1]){
                num = nums[e];
                break;
            }       
        }

        return num;
        }
    }
}