class Solution {
    public int numSub(String s) {
        long count = 0;
        long currentOnes = 0;
        int mod = 1000000007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                currentOnes++;
                count = (count + currentOnes) % mod; // Add all substrings ending here
            } else {
                currentOnes = 0; // Reset when encountering '0'
            }
        }

        return (int) count;
    }
}
