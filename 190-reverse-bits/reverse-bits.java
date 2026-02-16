class Solution {
    public int reverseBits(int n) {
        String binary=Integer.toBinaryString(n);
        binary = String.format("%32s", binary).replace(' ', '0');
        String newbinary=new StringBuilder(binary).reverse().toString();

        int ans=Integer.parseInt(newbinary, 2);
        return ans;
    }
}