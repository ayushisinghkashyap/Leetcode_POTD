class Solution {
    private void subsetsWithDupUtil(int[] nums,int i,ArrayList<Integer> list,HashSet<List<Integer>> set){
        if(i==nums.length){
            set.add(new ArrayList<>(list));
            return;
        }
        subsetsWithDupUtil(nums,i+1,list,set);
        list.add(nums[i]);
        subsetsWithDupUtil(nums,i+1,list,set);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set=new HashSet<>();
        subsetsWithDupUtil(nums,0,new ArrayList<>(),set);
        return new ArrayList<>(set);
    }
}