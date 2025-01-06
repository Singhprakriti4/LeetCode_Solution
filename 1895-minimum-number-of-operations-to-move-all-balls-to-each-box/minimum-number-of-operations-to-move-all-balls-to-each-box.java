class Solution {
    public int[] minOperations(String boxes) {
        char[] arr=boxes.toCharArray();

        int[] answer=new int[boxes.length()];
        TreeSet<Integer> set=new TreeSet<>();
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1'){
                set.add(i);
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j:set){
                answer[i]+=Math.abs(i-j);
            }
        }
        return answer;
    }
}