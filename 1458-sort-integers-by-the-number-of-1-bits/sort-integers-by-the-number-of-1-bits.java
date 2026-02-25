class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map=new TreeMap<>();
        for(int num: arr){
            int key=Integer.bitCount(num);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(num);
        }

        int[] result=new int[arr.length];
        int ptr=-1;
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
            List<Integer> list=e.getValue();
            Collections.sort(list);
            for(int num: list){
                result[++ptr]=num;
            }
        }

        return result;
    }
}