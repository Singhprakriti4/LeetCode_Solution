class Solution {
    public int characterReplacement(String s, int k) {
       
       //for the frequency of each character in a given window
       HashMap<Character, Integer> map=new HashMap<>();

       int i=0;
       int j=0;
       
       int len=0;

      while(j<s.length()){
        //putting the frequency of the new cahracter so found
        map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

        //see if this is a valid block
        boolean validblock=false;

        for(Map.Entry<Character,Integer> e: map.entrySet()){
            //go through each chaarcter frequency in the curr window and see it this window is valid
            char c=e.getKey();
            int freq=e.getValue();
            int currwindowsize=j-i+1;

            //if the frequency of the character+k is >= current window size
            if(freq+k>=currwindowsize){
                //possible answer found
                validblock=true;
                len=Math.max(len,currwindowsize);

                break;//since no need to check furthur
            }
        }

        if(validblock){

            //try increasing the length for longer possible answer
            j++;

        }
        else{

            //decrease the freq of ith character as we will not see any more answer starting from i
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
            map.put(s.charAt(j),map.get(s.charAt(j))-1);//cuz this will be automatically added in the next iteration
            i++;
        }
      }
      return len;
    }
}