class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return exp(expression);
    }
    static List<Integer> exp(String s){
         List<Integer> ans=new ArrayList<>();

        if(s.length()==1){
          List<Integer> a=new ArrayList<>();
          a.add(Integer.valueOf(s));
          return a; 
        }
        if(s.length()==2 ){
          List<Integer> b=new ArrayList<>();
          b.add(Integer.valueOf(s));
          return b;
        }
       
       List<Integer> left=new ArrayList<>();
       List<Integer> right=new ArrayList<>();
       for(int i=0;i<s.length();i++){
        if(Character.isDigit(s.charAt(i)))continue;
           char opr=s.charAt(i);
            left=exp(s.substring(0,i));
            right=exp(s.substring(i+1));

        for(int k=0;k<left.size();k++){
            for(int j=0;j<right.size();j++){
                if(opr=='+')
                ans.add(left.get(k)+right.get(j));
                else if(opr=='-')
                 ans.add(left.get(k)-right.get(j));
                 else if(opr=='*')
                  ans.add(left.get(k)*right.get(j));
                  else
                   ans.add(left.get(k)/right.get(j));
            }
        }
       }
        return ans;
    }
}