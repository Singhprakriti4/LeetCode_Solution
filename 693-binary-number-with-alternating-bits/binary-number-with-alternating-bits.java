class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary=Integer.toBinaryString(n);
        char prev='.';
        for(int i=0;i<binary.length();i++){
            char ch=binary.charAt(i);
            if(ch==prev) return false;
            prev=ch;
        }
        return true;
    }
}