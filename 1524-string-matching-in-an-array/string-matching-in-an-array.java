class Solution {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String source=words[i];
            for(int j=0;j<words.length;j++){
                if(words[j].length()<words[i].length()){
                   if(match(source,words[j])){
                     if(!list.contains(words[j])){
                        list.add(words[j]);
                     }
                   }

                }
            }
        }
        return list;
    }
    public boolean match(String source, String tobematched){
        if(tobematched.length()>source.length()){
            return false;
        }
        int[] lps=makelps(tobematched);
         int n = source.length();
        int m = tobematched.length();

        int i = 0;
        int j = 0; 

        while (i < n) {
            if(source.charAt(i) == tobematched.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return true;
            } else if (i < n && source.charAt(i) != tobematched.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; 
                } else {
                    i++; 
                }
            }
        }
        return false;
    }
    
    int[] makelps(String s) {
    int[] arr = new int[s.length()];
    int i = 1;
    int len = 0;
    arr[0] = 0;

    while (i < s.length()) {
        if (s.charAt(i) == s.charAt(len)) {
            len++;
            arr[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = arr[len - 1];
            } else {
                arr[i] = 0;
                i++;
            }
        }
    }
    return arr;
}

}