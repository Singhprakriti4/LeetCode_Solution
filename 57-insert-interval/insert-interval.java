class Solution {
    public int[][] insert(int[][] interval, int[] newInterval) {
        if(interval.length==0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }
        List<int[]> list=new ArrayList<>();
        int s=newInterval[0];
        int e=newInterval[1];
        boolean addasitis=false;
        //find the first start that is greater than new interval end
        for(int i=interval.length-1;i>=0;i--){
            // System.out.println(interval[i][0]+" "+e);
            if(interval[i][0]>e || addasitis){
                // System.out.println("ji");
                //safe: add to the list as it is
                list.add(new int[]{interval[i][0],interval[i][1]});
            }
            else{
                int start=interval[i][0];
                int end=interval[i][1];
                System.out.println(end+" "+s);
                if(s<start){
                    e=Math.max(e,end);
                    if(i-1<0){
                        list.add(new int[]{s,e});
                    }
                }
                else if(s>end){
                    System.out.println(end+" "+s);
                    addasitis=true;
                    list.add(new int[]{s,e});
                    list.add(new int[]{start,end});
                }
                else if(s>=start){
                    System.out.println("hello");
                    addasitis=true;
                    list.add (new int[]{Math.min(s,start), Math.max(e, end)});
                }
    
            }
        }
        if(e<list.get(list.size()-1)[0]){
            list.add(new int[]{s,e});
        }
        int idx=0;
        int[][] ans=new int[list.size()][2];
        for(int i=list.size()-1;i>=0;i--){
            ans[idx][0]=list.get(i)[0];
            ans[idx][1]=list.get(i)[1];
            idx++;
        }
        return ans;
    }
}