class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
       
      int[][] arr=new int[m][n];//all zeros  by default (we need to mark th ones of not our use as 1)

      Set<String> set=new HashSet<>();
      for(int i=0;i<guards.length;i++){
        set.add(guards[i][0]+" "+guards[i][1]);
      }
      for(int i=0;i<walls.length;i++){
        set.add(walls[i][0]+" "+walls[i][1]);
      }

      Queue<int[]> q=new LinkedList<>();

      for(int i=0;i<guards.length;i++){
        q.offer(new int[]{guards[i][0], guards[i][1], 1, 1});//up and first time
        q.offer(new int[]{guards[i][0], guards[i][1], -1, 1});//down
        q.offer(new int[]{guards[i][0], guards[i][1], 2, 1});//right
        q.offer(new int[]{guards[i][0], guards[i][1], -2, 1});//left
      }

      while(!q.isEmpty()){
        
        int[] popped=q.poll();
        int r=popped[0];
        int c=popped[1];
        int dir=popped[2];
       
        arr[r][c]=1;
        String str=r+" "+c;

        if(popped[3]==1 || !set.contains(str) ){
            // System.out.println("hi");

            if(dir==1 && r-1>=0){
                    q.offer(new int[]{r-1,c,dir,0});
            }
            if(dir==-1 && r+1<m){
                    q.offer(new int[]{r+1,c,dir,0});
            }
            if(dir==2 && c+1<n){
                    
                    q.offer(new int[]{r,c+1,dir,0});
            }
            if(dir==-2 && c-1>=0){
                    q.offer(new int[]{r,c-1,dir,0});
            }
        }

      }

      int count=0;
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j]==0 &&
             !set.contains(i+" "+j)){///vvv important edge case: incase any wall is there that we never reached
                count+=1;
            }
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
      }

      return count;

    }
}