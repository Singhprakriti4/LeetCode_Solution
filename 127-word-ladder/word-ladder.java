class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        boolean hasbegin=false;
        boolean hasend=false;

        for(int i=0;i<wordList.size();i++){
            if(wordList.get(i).equals(beginWord)) hasbegin=true;
            if(wordList.get(i).equals(endWord)) hasend=true;
        }

        if(hasend==false){
            return 0;
        }

        if(hasbegin==false){
            wordList.add(beginWord);
        }

        // HashMap<String,List<String>> adj=new HashMap<>();

        // for(int i=0;i<wordList.size();i++){            
        //     for(int j=i+1;j<wordList.size();j++){
        //         if(match(i,j, wordList)){
        //             if(adj.containsKey(wordList.get(i))){
        //                 adj.get(wordList.get(i)).add(wordList.get(j));
        //             }
        //             else{
        //                 List<String> list=new ArrayList<>();
        //                 list.add(wordList.get(j));
        //                 adj.put(wordList.get(i), list);
        //             }

        //             if(adj.containsKey(wordList.get(j))){
        //                 adj.get(wordList.get(j)).add(wordList.get(i));
        //             }
        //             else{
        //                 List<String> list=new ArrayList<>();
        //                 list.add(wordList.get(i));
        //                 adj.put(wordList.get(j),list);
        //             }
        //         }
        //     }
        // }

        HashMap<String, Integer> visited=new HashMap<>();
        visited.put(beginWord,0);

        Queue<String> q=new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()){
            String word=q.poll();
        //iterate on adj and non visited ones. if end found -> directly return
        //     if(adj.containsKey(word)){
        //     List<String> neighbours=adj.get(word);
        //     for(int i=0;i<neighbours.size();i++){
        //         if(!visited.containsKey(neighbours.get(i))){
        //             visited.put(neighbours.get(i), visited.get(word)+1);
        //             q.add(neighbours.get(i));
        //             if(neighbours.get(i).equals(endWord)){
        //                 return visited.get(endWord)+1;
        //             }
        //         }
        //     }
        // }
        for(int i=0;i<wordList.size();i++){
            if(match(word,i,wordList) && !visited.containsKey(wordList.get(i))){
                visited.put(wordList.get(i),visited.get(word)+1);
                q.add(wordList.get(i));
                if(wordList.get(i).equals(endWord)){
                    return visited.get(endWord)+1;
                }
            }
        }
        }

        return 0;
    }

    public boolean match(String s1,int j, List<String> wordlist){
        int diff=0;
        // String s1=wordlist.get(i);
        String s2=wordlist.get(j);

        if(s1.length()!=s2.length()) return false;

        for(int k=0;k<s1.length();k++){
            if(s1.charAt(k)!=s2.charAt(k)){
                diff+=1;
            }
        }

        if(diff==1) return true;

        return false;
    }
}