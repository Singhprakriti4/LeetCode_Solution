class Solution {
    public int maximizeSquareArea(int m, int n, 
    int[] hfences, int[] vfences) {
        int mod=1000000007;
        Arrays.sort(hfences);
        Arrays.sort(vfences);

        Set<Integer> vset=new TreeSet<>();
        Set<Integer> hset=new TreeSet<>();

        //filling thr horixontal set firslty
    
        for(int i=-1;i<vfences.length;i++){
            for(int j=i+1;j<vfences.length;j++){
                if(i==-1){
                    hset.add(vfences[j]-1);
                }
                else{
            
                 int fix=vfences[i];//ab compare karna hai
                 int val=vfences[j]-fix;
            // System.out.println(vfences[i]+" - "+fix+" ="+val);
                 hset.add(val);
            }
            }
        }
        //ab last wale ke saath sbka comparison
        for(int i=0;i<vfences.length;i++){
            hset.add(n-vfences[i]);
            // System.out.println(n+" - "+vfences[i]+" ="+(n-vfences[i]));
        }
        hset.add(n-1);//since ye array me nahi tha

        //vertical wala
        for(int i=-1;i<hfences.length;i++){
            for(int j=i+1;j<hfences.length;j++){
                if(i==-1){
                    vset.add(hfences[j]-1);
                }
                else{
                  int fix=hfences[i];
                   //ab compare karna hai
                   int val=hfences[j]-fix;
                   vset.add(val);
                }
            }
        }
        //ab last wale ke saath sbka comparison
        for(int i=0;i<hfences.length;i++){
            vset.add(m-hfences[i]);
        }
        vset.add(m-1);//since ye array me nahi tha
        // System.out.println(hset.contains(8404));
        // System.out.println(vset.contains(8404));
        //put them in two seperate lists and do the comparison
        List<Integer> vlist=new ArrayList<>();
        List<Integer> hlist=new ArrayList<>();

        for(int v: vset){
            vlist.add(v);
            // System.out.print(v+" ");
        }
        System.out.println();
        for(int h: hset){
            // System.out.print(h+" ");
            hlist.add(h);
        }

        int ptrh=hlist.size()-1;
        int ptrv=vlist.size()-1;
         
        while(ptrh>=0 && ptrv>=0){
            if(hlist.get(ptrh).equals(vlist.get(ptrv))){
                int len=hlist.get(ptrh);

                return (int)((1L*len*len)%mod);
            }
            else if(hlist.get(ptrh)>vlist.get(ptrv)){
                ptrh--;
            }
            else{
                ptrv--;
            }
        }
        return -1;
    }
}