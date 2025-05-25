class Solution {
    public int longestPalindrome(String[] words) {

        int ans=0;

        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])){
                map.put(words[i],1);
            }
            else{
                map.put(words[i],map.get(words[i])+1);
            }
        }
        
        boolean usedonce=false;
        for(int i=0;i<words.length;i++){

            if(map.get(words[i])>0){

            if(words[i].charAt(0)==words[i].charAt(1)){
                    //number check krte decrement karo
                    int occurance=map.get(words[i]);

                    if(occurance%2==0){
                        ans+=occurance*2;
                        map.put(words[i],0);
                    }
                    else{
                        //oddnumber hai
                        ans+=(occurance-1)*2;//saare even consider kar liye
                        map.put(words[i],1);
                        
                        if(!usedonce){
                            usedonce=true;
                            ans+=2;
                            map.put(words[i],0);
                        }
                    }
                
            }
            else{

            String rev=""+ words[i].charAt(1) + words[i].charAt(0);

            if(map.containsKey(rev) && map.get(rev)>0){
                ans+=4;
                map.put(words[i],map.get(words[i])-1);
                map.put(rev,map.get(rev)-1);
            }
            }
          }
        }

        return ans;
    }
}