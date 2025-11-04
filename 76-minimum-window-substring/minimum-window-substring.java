class Solution {
    public String minWindow(String s, String t) {

        int length=Integer.MAX_VALUE;
        String ans="";

        Map<Character, Integer> need=new HashMap<>();

        for(int i=0;i<t.length();i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i),0)+1);
        }
        int found=0;

        Map<Character, Integer> currcount=new HashMap<>();
        int left=0;

        for(int right=0;right<s.length();right++){
            
            char currchar=s.charAt(right);

            if(need.containsKey(currchar)){
            currcount.put(currchar, currcount.getOrDefault(currchar,0)+1);
            if(currcount.get(currchar).equals(need.get(currchar))){
                found+=1;
            }
            //condition matched
            while(found==need.size()){

                if(right-left+1<length){
                    length=right-left+1;
                    ans=s.substring(left, right+1);
                }

                char totest=s.charAt(left);

                if(currcount.containsKey(totest)){

                    currcount.put(totest, currcount.get(totest)-1);
                    //update the currcount and found if necessary
                    if(currcount.get(totest)<need.get(totest)){
                        found-=1;
                        if(currcount.get(totest)==0){
                        currcount.remove(totest);
                    }
                    }
                }

                left++;
            }
            }
        }
        return ans;
    }
}