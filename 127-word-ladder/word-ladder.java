class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        boolean startpresent=false;
        boolean endpresent=false;
        for(String s: wordList){
            if(s.equals(begin)) startpresent=true;
            if(s.equals(end)) endpresent=true;
        }
        if(!endpresent) return 0;
        if(!startpresent) wordList.add(begin);

        //making the adjecency list
        int len=wordList.size();
        HashMap<String,List<String>> adj=new HashMap<>();

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){

                if(valid(wordList, i,j)){
                    String a=wordList.get(i);
                    String b=wordList.get(j);
                    if(!adj.containsKey(a)) adj.put(a, new ArrayList<>());
                    if(!adj.containsKey(b)) adj.put(b, new ArrayList<>());
                    adj.get(a).add(b);
                    adj.get(b).add(a);
                }

            }
        }
        if(begin.equals(end)) return 1;

        boolean founded=false;
        int dist=1;
        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();

        q.add(begin);
        visited.add(begin);
        q.add("");

        while(!q.isEmpty()){
            String str=q.poll();
            if(str.equals("")){
                dist+=1;
                if(!q.isEmpty()){
                    q.add(str);
                }
            }
            else{
                //go to all the possible neighbours that are not visited
                if(adj.containsKey(str)){
                    List<String> nei=adj.get(str);
                    for(String n: nei){
                        if(!visited.contains(n)){
                            //if it what we are looking for
                            if(n.equals(end)){
                                founded=true;
                                return dist+1;
                            }
                            else{
                                visited.add(n);
                                q.add(n);
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }
    public boolean valid(List<String> list, int i, int j){
        String s1=list.get(i);
        String s2=list.get(j);
        int diff=0;

        for(int k=0;k<s1.length();k++){
            if(s1.charAt(k)!=s2.charAt(k)){
                diff+=1;
            }
        }

        return diff==1;
    }
}