class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // if(n>meetings.length){
        //     System.out.println("hi");
        //     return 0;//at max 1 meeting hogi kisi bhi room me
        // }
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<long[]> minheap=new PriorityQueue<>((a,b)->{
            int tie=Long.compare(a[1],b[1]);
            if(tie!=0){
                return tie;
            }
            return Long.compare(a[0],b[0]);
        });

        int maxbookings=1;
        int room=0;
        int lastused=0;
        minheap.offer(new long[]{0,meetings[0][1],1});//room no, endtime, nooftimesused
        TreeSet<int[]> set=new TreeSet<>((a,b)-> Integer.compare(a[0],b[0]));//oreviously used but currently free rooms
        // rooms, their no of times used

        for(int i=1;i<meetings.length;i++){

            long[] arr=minheap.peek();
            int start=meetings[i][0];
            int end=meetings[i][1];

            if(start>=arr[1] || (set.size()!=0)){
                //an already used room can be used
                // maxbookings=Math.max(maxbookings, arr[2]+1);
                int[] free=freerooms(start,minheap,set);
                if(free[1]+1>maxbookings){
                    maxbookings=free[1]+1;
                    room=free[0];
                }
                else if(free[1]+1==maxbookings){
                    room=Math.min(room, free[0]);
                }
                // minheap.poll();
                minheap.offer(new long[]{free[0],end,free[1]+1});
            }
            else{
                //case one: we can asiign a new room(lastused<n)
                if(lastused<n-1){
                    lastused+=1;
                    minheap.offer(new long[]{lastused,end,1});//nayaroom being used for the first time
                }
                else{
                //case two: we habe to wait for the room with lowest end time
                    long gap=end-start;
                    long newend=arr[1]+gap;//because the end in exclusive
                    // System.out.println(newend);
                    minheap.poll();//remove previous one
                    minheap.add(new long[]{arr[0], newend, arr[2]+1});
                    // maxbookings=Math.max(maxbookings, arr[2]+1);
                    if(arr[2]+1>maxbookings){
                        maxbookings=(int)arr[2]+1;
                        room=(int)arr[0];
                    }
                    else if(arr[2]+1==maxbookings){
                        room=Math.min(room, (int)arr[0]);
                    }
                }
            }
            // print whole 
        }
        // System.out.println(maxbookings);
        return room;
    }
    public int[] freerooms(int start, PriorityQueue<long[]> minheap,
     TreeSet<int[]> set){
        // int[] ans=new int[2];
        while(minheap.size()!=0 && minheap.peek()[1]<=start){
            long[] arr=minheap.poll();
            set.add(new int[]{(int)arr[0],(int)arr[2]});
        }
        //get the first room that is free
        int[] ans=set.first();
        set.remove(ans);
        return ans;
     }
}