class Solution {
    public int bitwiseComplement(int n) {
        String binary=Integer.toBinaryString(n);
        // Syste
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='0'){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
        }
        // System.out.println(sb.toString());
        return Integer.parseInt(sb.toString(),2);
    }
}