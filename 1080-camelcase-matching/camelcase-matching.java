class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> answer=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            answer.add(check(queries[i],pattern));
        }
        return answer;

    }
public boolean check(String test,String pattern){
    int ptr_pattern=0;
    int ptr_test=0;
    boolean status=false;
    while(ptr_test<test.length()){
      if(pattern.charAt(ptr_pattern)==(test.charAt(ptr_test)) ){
         if(ptr_pattern == pattern.length()-1){ 
            ptr_test++;
            status=true;
            }
            else{
                ptr_pattern++;
                ptr_test++;
            }
      }
      else if((int)test.charAt(ptr_test)>=65 && (int)test.charAt(ptr_test)<=90 ){
            return false;
        }
      else{
        ptr_test++;
      }  

    }
    
    if(status==true){
    return true;
    }
    return false;

}
}