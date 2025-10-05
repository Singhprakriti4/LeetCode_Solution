class Solution {
    public boolean isScramble(String s1, String s2) {
        HashMap<String,Boolean> map=new HashMap<>();
        return solve(s1,0,s1.length()-1,s2,map,0,s2.length()-1);
    }
    public boolean solve(String s1, int i, int j, String s2,HashMap<String,Boolean> map,int i2, int j2){
        if(i2>j2 || i>j || j-i != j2-i2){
            return false;
        }
        if(i==j){
            if(s1.charAt(i)==s2.charAt(i2)){
                return true;
            }
            return false;
        }
       
        // if(s1.substring(i,j+1).equals(s2.substring(i2,j2+1))){
        //     return true;
        // }
        // NOTE: 
        
        if(equals(s1,i,j,s2,i2,j2)){
            return true;
        }
        
        if(map.containsKey(i+" "+j+" "+i2+" "+j2)){

            return map.get(i+" "+j+" "+i2+" "+j2);

        }
        if(!samechars(s1,i,j,s2,i2,j2)){
            map.put(i+" "+j+" "+i2+" "+j2,false);
            return false;
        }
        boolean tempans=false;
        for(int k=i;k<j;k++){

            boolean left,right,swappedleft,swappedright;
            
            if(map.containsKey(i+" "+k+" "+i2+" "+(i2+(k-i)))){
                left=map.get(i+" "+k+" "+i2+" "+(i2+(k-i)));
            }
            else{
                left=solve(s1,i,k, s2,map,i2,i2+(k-i));
            }

            if(map.containsKey((k+1)+" "+j+" "+(i2+(k-i)+1)+" "+j2)){
                right=map.get((k+1)+" "+j+" "+(i2+(k-i)+1)+" "+j2);
            }
            else{
                right= solve(s1,k+1,j,s2,map,i2+(k-i)+1,j2);
            }
            
            boolean tempansleft=left && right;
            if(tempansleft){
                tempans=true;
                break;
            }

            if(map.containsKey((k+1)+" "+j+" "+i2+" "+(i2+j-(k+1)))){
                swappedleft=map.get((k+1)+" "+j+" "+i2+" "+(i2+j-(k+1)));
            }
            else{
            swappedleft=solve(s1,k+1,j,s2,map,i2,i2+j-(k+1)) ;
            }
            if(map.containsKey(i+" "+j+" "+(i2+j-(k+1)+1)+" "+j2)){
                swappedright=map.get(i+" "+j+" "+(i2+j-(k+1)+1)+" "+j2);
            }
            else{
                swappedright=solve(s1,i,k,s2,map,i2+j-(k+1)+1,j2);
            }
            

           boolean tempansright=swappedleft && swappedright;
           tempans= tempans || tempansleft || tempansright;

           if(tempans) break;

        }
        map.put(i+" "+j+" "+i2+" "+j2,tempans);
        return tempans;
    }

    public boolean equals(String s1, int i, int j, String s2,int i2, int j2){
        while(i<=j && i2<=j2){
            if(s1.charAt(i)!=s2.charAt(i2)){
                return false;
            }
            i++;
            i2++;
        }
        if(i<=j || i2<=j2){
            return false;
        }
        return true;
    }
    // Helper function to check if two substrings have the same character counts
public boolean samechars(String s1, int i, int j, String s2, int i2, int j2) {
    int[] count = new int[26]; // assuming lowercase letters
    for (int k = 0; k <= j - i; k++) {
        count[s1.charAt(i + k) - 'a']++;
        count[s2.charAt(i2 + k) - 'a']--;
    }
    for (int c : count) {
        if (c != 0) return false; // different character counts
    }
    return true;
}

}