class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans=new ArrayList<>();
        List<String> current=new ArrayList<>();
        queens(0, current, n);
        return ans;
    }
    public void queens(int row, List<String> current, int n){
        if(row==n){
            //we reached the end
            List<String> last=new ArrayList<>(current);
            ans.add(last);
            return;
        }

        for(int i=0;i<n;i++){
            if(possible(current, i)){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<i;j++){
                    sb.append('.');
                }
                sb.append('Q');
                for(int j=i+1;j<n;j++){
                    sb.append('.');
                }
                current.add(sb.toString());
                queens(row+1, current, n);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean possible(List<String> current, int r){
        int colleft=r-1;
        int colright=r+1;
        int colcurr=r;
        for(int i=current.size()-1;i>=0;i--){
            String s=current.get(i);
            if(colleft>=0 && s.charAt(colleft)=='Q'){
                return false;
            }
            else{
                colleft-=1;
            }
            if(colright<s.length() && s.charAt(colright)=='Q'){
                return false;
            }
            else{
                colright+=1;
            }
            if(s.charAt(colcurr)=='Q'){
                return false;
            }
        }
        return true;
    }
}