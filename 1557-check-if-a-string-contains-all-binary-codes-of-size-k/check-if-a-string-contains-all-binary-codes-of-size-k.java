class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        int n=s.length();
        int res_len= (int) Math.pow(2,k);
        for(int i=0;i<n-k+1;i++){
            String sub=s.substring(i,i+k);
            set.add(sub);
        }
        return (set.size()==res_len);
    }
}