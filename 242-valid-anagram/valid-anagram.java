class Solution {
    public boolean isAnagram(String s, String t) {
        char[] scharArray = s.toCharArray();
        Arrays.sort(scharArray);
        char[] tcharArray = t.toCharArray();
        Arrays.sort(tcharArray);

        if(s.length() != t.length()){
            return false;
        }

        else{
            boolean count = true;
            for(int i = 0;i<scharArray.length;i++){
                if(scharArray[i] != tcharArray[i]){
                    count = false;
                    break;
                }
            }
            return count;
        }
    }
}