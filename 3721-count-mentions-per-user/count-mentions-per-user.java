class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int[] mentions=new int[numberOfUsers];//user:index of the user
        int allitems=0;//when all will be mentioned
        int[] offlinetimestamp=new int[numberOfUsers];
        Arrays.fill(offlinetimestamp, -1);
        // events.sort((a,b)-> Integer.compare(Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1)) ));
        events.sort((a, b) -> {
         int cmp = Integer.compare(Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1)));
         if (cmp != 0) return cmp;           // if second index is different, use it
         return b.get(0).compareTo(a.get(0)); // else compare first index
        });

        for(int i=0;i<events.size();i++){
            List<String> event=events.get(i);
            String e=event.get(0);
            if(e.equals("OFFLINE")){
                //latest time at which the 
                int ts=Integer.parseInt(event.get(1));
                int user=Integer.parseInt(event.get(2));
                if(offlinetimestamp[user]<ts){
                    offlinetimestamp[user]=ts;
                }
            }
            else{
                String ids=event.get(2);
                int ts=Integer.parseInt(event.get(1));
                if(ids.equals("ALL")){
                    allitems+=1;
                }
                else if(ids.equals("HERE")){
                    //count all online numbers and +=their mentions
                    onlineplus(mentions,offlinetimestamp,ts);
                }
                else{
                    //get all the mentions and do +1 to their mentions
                    String[] allid=ids.split(" ");
                    for(int j=0;j<allid.length;j++){
                        int currid=Integer.parseInt(allid[j].substring(2));
                        mentions[currid]+=1;
                    }
                }
            }

            // for(int j=0;j<offlinetimestamp.length;j++){
            //     System.out.print(offlinetimestamp[j]+" ");
            // }
            // System.out.println();
        }
        for(int i=0;i<mentions.length;i++){
            mentions[i]+=allitems;
        }
        return mentions;
    }
    public void onlineplus(int[] mentions, int[] offlinetimestamp, int currts){
        for(int i=0;i<offlinetimestamp.length;i++){
            int ts=offlinetimestamp[i];
            if(ts==-1){
                //already online
                mentions[i]+=1;
            }
            else if(ts+60<=currts){
                //came back online
                // System.out.println("ts: "+ts+" ts+60:" + (ts+60));
                // System.out.println(currts);
                // if(ts+60>=currts){
                //     System.out.println("true");
                // }
                offlinetimestamp[i]=-1;
                mentions[i]+=1;
            }
        }
    }
}