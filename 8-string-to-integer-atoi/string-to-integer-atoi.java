import java.util.*;
class Solution {
    public int myAtoi(String s) {
        int n = 0;
        ArrayList<Character> arrc = new ArrayList<>();
        char[] arr = {'1','2','3','4','5','6','7','8','9','0'};
        for(char c : arr){
            arrc.add(c);
        }

        int count = 1;
        boolean neg = false;
        int j = 0;
        s = s.trim();
        // for(int i=0;i<s.length();i++){
        //     //if(s.charAt(i) == ' ') continue;
        //     if(s.charAt(i) == '-') {
        //         count = -1;
        //         j=i;
        //         break;
        //     }
        // }

        // if(j != 0 && s.charAt(j-1)==' '){
        //     j++;
        // }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '-' && i ==0) {
                count = -1;
                neg = true;
                continue;
            }
            else if(s.charAt(i) == '+' && i ==0) {
                count = 1;
                neg = false;
                continue;
            }

            if(arrc.contains(s.charAt(i))){
                int c = Character.getNumericValue(s.charAt(i));
                
                if (n > Integer.MAX_VALUE / 10 || n == Integer.MAX_VALUE / 10 && c > Integer.MAX_VALUE % 10) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                n = n*10 + c;
            }
            else{
                   break;
            }
            
        }
        return n*count;
    }
}