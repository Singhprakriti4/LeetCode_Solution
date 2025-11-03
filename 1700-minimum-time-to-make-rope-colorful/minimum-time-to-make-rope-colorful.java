class Solution {
    public int minCost(String colors, int[] neededTime) {

      int time=0;
      Stack<Integer> stk=new Stack<>();

      for(int i=0;i<colors.length();i++){
        if(!stk.isEmpty() && colors.charAt(stk.peek())==colors.charAt(i)){
            //keep the one with maximum time in stack
            int time1=neededTime[stk.peek()];
            int time2=neededTime[i];

            if(time1<time2){
                time+=time1;
                stk.pop();
                stk.push(i);
            }
            else{
                time+=time2;
            }
        }
        else{
            stk.push(i);
        }
      }

      return time;

    }
}