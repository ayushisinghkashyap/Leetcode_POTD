import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> dup = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(dup.contains(nums[i]) == false){
                dup.add(nums[i]);
            }
            
        }
        int j = 0;
        for(int i=0;i<nums.length;i++){
            if(j>dup.size()-1){
                break;
            }
            else{
                nums[i] = dup.get(j);
                j++;
            }
        }

        //Arrays.sort(nums);
        return dup.size();
    }
}