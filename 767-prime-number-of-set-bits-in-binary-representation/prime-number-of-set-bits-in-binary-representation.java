class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primenums=new HashSet<>();
        primenums.add(2);
        primenums.add(3);
        primenums.add(5);
        primenums.add(7);
        primenums.add(11);
        primenums.add(13);
        primenums.add(17);
        primenums.add(19);
        
        int ans=0;

        for(int i=left;i<=right;i++){
            if(primenums.contains(Integer.bitCount(i))){
                ans+=1;
            }
        }
        return ans;
    }
}