class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean count = false;
        int c =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2 != 0){
                c++;
            }
            else if(arr[i]%2 == 0){
                c=0;
            }
            if(c==3){
                count = true;
                break;
            }
        }

        return count;
    }
}