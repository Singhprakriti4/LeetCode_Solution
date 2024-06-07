class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
         String[] words = sentence.split(" ");
        for( int i=0;i<dictionary.size();i++){
            findandreplace(dictionary.get(i),words);
        }

        StringBuilder ans=new StringBuilder();
        for(int k=0;k<words.length;k++){
            ans.append(words[k]);
            ans.append(" ");
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
    public void findandreplace(String root,String[] words){
        int last_index=root.length();
        for(int j=0;j<words.length;j++){
            if(words[j].length()>=last_index){
            if(words[j].substring(0,last_index).equals(root)){
                words[j]=root;
            }}
        }
    }
}