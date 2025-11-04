class Solution {
    public int numberOfSubstrings(String s) {
        int ans=0;

        int currcount=0;

        int left=0;
        int[] freq=new int[3];
        //0: a, 1:b, 2:c

        for(int right=0;right<s.length();right++){

            char c=s.charAt(right);
            
            if(c=='a' || c=='b' || c=='c'){
                freq[c-'a']+=1;
            }

                if(freq[0]==0 || freq[1]==0 || freq[2]==0){
                    //condition not met;
                    currcount=0;
                }
                else{
                    //condiiton is met
                    //pichle currme add krna hai
                    while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                        //loop till condition is valid
                        char test=s.charAt(left);

                        if(test=='a'){
                            if(freq[0]-1==0) break;
                            freq[0]-=1;
                        }
                        if(test=='b'){
                           if( freq[1]-1==0) break;
                           freq[1]-=1;
                        }
                        if(test=='c'){
                           if( freq[2]-1==0) break;
                           freq[2]-=1;
                        }
                        left+=1;
                        currcount+=1;
                    }

                    ans+=currcount+1;

                }
            
        }
        return ans;
    }
}