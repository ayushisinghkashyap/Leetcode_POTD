import java.util.*;
class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> num = new ArrayList<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                num.add(nums[i]);
                nums[j] = nums[i];
                j++;
            }
        }

        return num.size();
    }
}