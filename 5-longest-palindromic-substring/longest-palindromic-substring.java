class Solution {
    String s;
    Boolean[][] dp;
    String res = "";

    public String longestPalindrome(String s) {
        this.s = s;
        int n = s.length();
        dp = new Boolean[n][n];
        
        // check all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j)) {
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(int i, int j) {
        // base case
        if (i >= j) return true;

        // memoized result
        if (dp[i][j] != null) return dp[i][j];

        // recursive check
        if (s.charAt(i) != s.charAt(j)) 
            return dp[i][j] = false;

        return dp[i][j] = isPalindrome(i + 1, j - 1);
    }
}
