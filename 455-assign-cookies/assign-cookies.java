class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child=0;
        int size=0;
        int ans=0;

        while(size<s.length && child<g.length){
            if(s[size]>=g[child]){
                ans+=1;
                size++;
                child++;
            }
            else{
                size++;
            }
        }

        return ans;
    }
}