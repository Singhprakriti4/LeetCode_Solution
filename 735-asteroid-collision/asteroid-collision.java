class Solution {
    public int[] asteroidCollision(int[] asteroids) {
          
          Stack<Integer> s=new Stack<>();

          for(int i=0;i<asteroids.length;i++){
            if(!s.isEmpty() && (s.peek()>=0 && asteroids[i]<0)){
                PushOrPop(s,asteroids[i]);
            }
            else{
                s.push(asteroids[i]);
            }
          }

          int[] arr= new int[s.size()];

          int index=arr.length-1;
          while(!s.isEmpty()){
            arr[index]=s.pop();
            index--;
          }
          return arr;
        
    }
    public void PushOrPop(Stack<Integer> s, int value){
         if(s.isEmpty()){
            s.push(value);
         }
         else{
            if(s.peek()<0 && value<0){
                s.push(value);
            }
            else if(s.peek()==Math.abs(value)){
                s.pop();
            }
            else if(s.peek()>Math.abs(value)){

            }
            else{
                s.pop();
                PushOrPop(s,value);
            }
         }
    }
}