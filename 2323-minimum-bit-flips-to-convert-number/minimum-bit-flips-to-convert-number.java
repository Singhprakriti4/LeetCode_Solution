class Solution {
    public int minBitFlips(int start, int goal) {
        int XOR=start^goal;
        return Integer.bitCount(XOR);
    }
}