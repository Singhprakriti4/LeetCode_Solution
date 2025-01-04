
import java.util.HashSet;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        HashSet<Character> alreadyCounted = new HashSet<>();
        
        // Loop through every pair (i, j) such that i < j
        for (int i = 0; i < s.length() - 2; i++) {
            // Skip if the outer character has already been counted
            if (alreadyCounted.contains(s.charAt(i))) {
                continue;
            }

            // Search for matching outer character s[i] at a later position
            int j = s.length() - 1;
            while (j >= i + 2 && s.charAt(j) != s.charAt(i)) {
                j--;
            }

            // If a match for s[i] at position j is found
            if (s.charAt(j) == s.charAt(i)) {
                alreadyCounted.add(s.charAt(i)); // Mark this outer character as counted

                // Count unique middle characters between i+1 and j-1
                HashSet<Character> middle = new HashSet<>();
                for (int k = i + 1; k < j; k++) {
                    middle.add(s.charAt(k));
                }

                // Add the number of unique middle characters to the answer
                ans += middle.size();
            }
        }

        return ans;
    }
}
