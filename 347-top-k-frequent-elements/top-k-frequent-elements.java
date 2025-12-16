class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> maxheap=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));

        HashMap<Integer,Integer> track=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            track.put(num, track.getOrDefault(num,0)+1);
            maxheap.add(new int[]{num,track.get(num)});
            // System.out.println()
        }
        int[] res=new int[k];
        Set<Integer> visited=new HashSet<>();
        while(k!=0){
            int[] arr=maxheap.poll();
            if(!visited.contains(arr[0])){
                k--;
                visited.add(arr[0]);
                res[k]=arr[0];
            }
        }
        return res;
    }
} 