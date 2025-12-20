class Solution {
    public int minDeletionSize(String[] strs) {
       int idx=0;
       int delete=0;

       while(idx<strs[0].length()){
        for(int i=0;i<strs.length;i++){
            if(i>0){
                if(strs[i].charAt(idx)-'0'<strs[i-1].charAt(idx)-'0'){
                    delete+=1;
                    break;
                }
            }
        }
        idx++;
       }  
       return delete; 
    }
}