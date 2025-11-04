class Solution {
    public String minWindow(String s, String t) {

        if(t.length()>s.length()) {
        return "";
       }

        int length=Integer.MAX_VALUE;
        String ans="";
        // System.out.println(s.length());
        // System.out.println(t.length());

        Map<Character, Integer> need=new HashMap<>();

        for(int i=0;i<t.length();i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i),0)+1);
        }
        // System.out.println(need.size());

        int found=0;

        Map<Character, Integer> currcount=new HashMap<>();
        int left=0;

        for(int right=0;right<s.length();right++){
         
            char currchar=s.charAt(right);

            currcount.put(currchar, currcount.getOrDefault(currchar,0)+1);

            if(need.containsKey(currchar) && currcount.get(currchar).equals(need.get(currchar))){
                found+=1;
                System.out.println(found);
            }

            while(found==need.size()){
                // System.out.println("hi");
                if(right-left+1<=length){
                    ans=s.substring(left, right+1);
                    length=right-left+1;
                }

                char totest=s.charAt(left);

                if(need.containsKey(totest)){

                    currcount.put(totest, currcount.get(totest)-1);
                    //update the currcount and found if necessary

                    if(currcount.get(totest)<need.get(totest)){
                        found-=1;
                    }
                }

                left++;
            }
        }
        return ans;
    }
}