class Solution {
    public int maxHeight(int[][] cuboid) {
        int maximumheight=0;
        //STEP 1: sorting on the basis of volume
        Arrays.sort(cuboid,(a,b)->{
                   long vola=1L*a[0]*a[1]*a[2];
                   long volb=1L*b[0]*b[1]*b[2];
                   return Long.compare(volb,vola);
                   }
                   );
        // for(int i=0;i<cuboid.length;i++){
        //     System.out.println(cuboid[i][0]);
        // }

        //making the lis dp array

        int[][] lis=new int[cuboid.length][3];
        //col 0: l*b (h)   1: l*h (b)   2: b*h (l)
        //() wali value height hogi

        for(int i=0;i<lis.length;i++){
            //initialisation of the current value
            int l=cuboid[i][0];
            int b=cuboid[i][1];
            int h=cuboid[i][2];
            //because in the worst case senario,this indivisual box can be kept anyway without stacking 
            lis[i][0]=h;
            maximumheight=Math.max(maximumheight,lis[i][0]);
            lis[i][1]=b;
            maximumheight=Math.max(maximumheight,lis[i][1]);
            lis[i][2]=l;
            maximumheight=Math.max(maximumheight,lis[i][2]);

            for(int j=i-1;j>=0;j--){
                
                for(int k=0;k<=2;k++){
                    int lprev=-1;
                    int bprev=-1;
                    int hprev=-1;
                    if(k==0){
                        lprev=cuboid[j][0];
                        bprev=cuboid[j][1];
                        hprev=cuboid[j][2];
                    }
                    else if(k==1){
                        lprev=cuboid[j][0];
                        bprev=cuboid[j][2];
                        hprev=cuboid[j][1];
                    }
                    else{
                        lprev=cuboid[j][1];
                        bprev=cuboid[j][2];
                        hprev=cuboid[j][0];
                    }

                    int length=Math.min(lprev,bprev);
                    int bredth=Math.max(lprev,bprev);
                    int height=hprev;

                    //for lis[i][0]
                    int currlen=Math.min(l,b);
                    int currbred=Math.max(l,b);
                    int currheight=h;

                    if(currlen<=length && currbred<=bredth
                    && currheight<=height){
                        lis[i][0]=Math.max(lis[i][0],currheight+lis[j][k]);
                        maximumheight=Math.max(maximumheight,lis[i][0]);
                    }

                    //for lis[i][1]
                    currlen=Math.min(l,h);
                    currbred=Math.max(l,h);
                    currheight=b;

                    if(currlen<=length && currbred<=bredth
                    && currheight<=height){
                        lis[i][1]=Math.max(lis[i][1], lis[j][k]+currheight);
                        maximumheight=Math.max(maximumheight,lis[i][1]);
                    }

                    //for(lis[i][2])
                    currlen=Math.min(b,h);
                    currbred=Math.max(b,h);
                    currheight=l;

                    if(currlen<=length && currbred<=bredth
                    && currheight<=height){
                        lis[i][2]=Math.max(lis[i][2], lis[j][k]+currheight);
                        maximumheight=Math.max(maximumheight,lis[i][2]);
                    }

                }

            }
        }

        return maximumheight;

    }
}