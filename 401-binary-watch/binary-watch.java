class Solution {
    public List<String> readBinaryWatch(int turnedon) {
        
        Set<String> list=new HashSet<>();

        if(turnedon>=9) return new ArrayList<>(list);
        HashMap<Integer, List<Integer>> hour=new HashMap<>();
        HashMap<Integer, List<Integer>> min=new HashMap<>();

        hour.put(1, new ArrayList<>());
        hour.put(0, new ArrayList<>());
        hour.get(0).add(0);
        hour.put(2, new ArrayList<>());
        hour.put(3, new ArrayList<>());
        // hour.put(4, new ArrayList<>());

        min.put(0, new ArrayList<>());
        min.get(0).add(0);
        min.put(1, new ArrayList<>());
        min.put(2, new ArrayList<>());
        min.put(3, new ArrayList<>());
        min.put(4, new ArrayList<>());
        min.put(5, new ArrayList<>());
        // min.put(6, new ArrayList<>());

        int[] h=new int[4];
        h[0]=1;
        h[1]=2;
        h[2]=4;
        h[3]=8;

        for(int i=0;i<h.length;i++){
            hour.get(1).add(h[i]);
            int first=h[i];
            for(int j=0;j<h.length;j++){
                if(j==i) continue;
                int second=first+h[j];
                hour.get(2).add(second);
                for(int k=0;k<h.length;k++){
                    if(k==i || k==j) continue;
                    int third=second+h[k];
                    hour.get(3).add(third);
                }
            }
        }

        int[] m=new int[6];
        m[0]=1;
        m[1]=2;
        m[2]=4;
        m[3]=8;
        m[4]=16;
        m[5]=32;

        for(int i=0;i<6;i++){
            int first=m[i];
            min.get(1).add(m[i]);
            for(int j=0;j<6;j++){
                if(j==i) continue;
                int sec=first+m[j];
                min.get(2).add(sec);
                for(int k=0;k<6;k++){
                    if(k==j || k==i) continue;

                    int third=sec+m[k];
                    min.get(3).add(third);
                    for(int l=0;l<6;l++){
                        if(l==i || l==j || l==k) continue;

                        int fourth=third+m[l];
                        min.get(4).add(fourth);

                        for(int n=0;n<6;n++){
                            if(n==i || n==j || n==k || n==l) continue;

                            int fifth=fourth+m[n];
                            min.get(5).add(fifth);
                        }
                    }
                }
            }
        }

        for(int i=0;i<4;i++){
            //hour ke liye
            for(int valueh: hour.get(i)){
           
            if(turnedon-i<0 || turnedon-i>5){
                continue;
                //invalid combo
            }
            else{
                // we goto each counterpart
                for(int valuem: min.get(turnedon-i)){
                    if(valueh>=12 || valuem>=60) continue;
                    StringBuilder sb=new StringBuilder();
                    sb.append(valueh);
                    sb.append(':');

                    if(valuem<10){
                    sb.append('0');
                    }
                    sb.append(valuem);

                    list.add(sb.toString());
                }
            }

            // list.add(sb.toString());
            }
        }
        return new ArrayList<>(list);
    }
}