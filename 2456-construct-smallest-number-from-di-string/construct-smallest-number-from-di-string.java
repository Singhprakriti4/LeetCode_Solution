class Solution {
            String solution="";

    public String smallestNumber(String pattern) {
        //making set for possibilities
        boolean[] set=new boolean[10];
        set[0]=true;
        StringBuilder str=new StringBuilder();
        small(0,'a',-1,pattern,set,str);
        return solution;
    }
    public void small(int index,char ch,int parent,String pattern,
    boolean[] set,StringBuilder str){

        //base case
        if(index==pattern.length()+1){
            if(solution=="" || Long.valueOf(solution)>Long.valueOf(str.toString())){
                StringBuilder s=new StringBuilder(str.toString());
                solution=s.toString();
            }
            return;
        }
        boolean valid=false;
        //current character
         char curr='a';
          if(index<pattern.length()){
            curr=pattern.charAt(index);
          }
        // iterating on available options 
        for(int i=1;i<10;i++){

            if(set[i]==false){
                int num=i;
                if((ch=='I' && parent<num)||(ch=='D' && parent>num)){
                valid=true;
                str.append(num);
                //removing num from set(possibilities) for next call
                set[num]=true;
                //next call
                small(index+1,curr,num,pattern,set,str);
                
                
                //backtracking
                set[num]=false;
                str.deleteCharAt(str.length()-1);
            }
            else if(parent==-1){
                valid=true;
              //all possibility is there
              str.append(num);
              set[num]=true;
              small(index+1,curr,num,pattern,set,str);
              set[num]=false;
              str.deleteCharAt(str.length()-1);
            }
            }
           
        }
        if(!valid){
            return;
        }
    }
}