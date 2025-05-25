class Solution {
    public int longestPalindrome(String[] words) {
        int len = 0;
        Map<String, Integer> pal = new HashMap<>();
        Map<String, Integer> notpal = new HashMap<>();

        // Separate palindromic and non-palindromic words
        for (String word : words) {
            if (word.charAt(0) == word.charAt(1)) {
                pal.put(word, pal.getOrDefault(word, 0) + 1);
            } else {
                notpal.put(word, notpal.getOrDefault(word, 0) + 1);
            }
        }

        // Solving for the palindromic words
        boolean center = false;
        for (Map.Entry<String, Integer> entry : pal.entrySet()) {
            int count = entry.getValue();
            if (count % 2 == 0) {
                len += count * 2;
            } else {
                len += (count - 1) * 2;
                center = true;
            }
        }

        if (center) {
            len += 2; 
        }

        // Solving for the non-palindromic word pairs
        for (Map.Entry<String, Integer> entry : notpal.entrySet()) {
            String word = entry.getKey();
            String reversed = new StringBuilder(word).reverse().toString();

            if (notpal.containsKey(reversed) && entry.getValue() != 0) {
                int pairs = Math.min(notpal.get(word), notpal.get(reversed));
                len += pairs * 4;
                notpal.put(word, 0);       
                notpal.put(reversed, 0);
            }
        }

        return len;
    }
}