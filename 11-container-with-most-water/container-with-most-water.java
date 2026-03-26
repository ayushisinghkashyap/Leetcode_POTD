class Solution {
    public int maxArea(int[] h) {
        int i = 0;
        int j = h.length -1;
        int maxWater = 0;
        while(i<j){
            int minto = Math.min(h[i], h[j]);
            int mindis = j-i;
            maxWater = Math.max(maxWater , minto*mindis);
            if(h[i]>h[j]){
                j--;
            }else{
                i++;
            }
        }

        return maxWater;
    }
}