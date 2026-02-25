class Solution {
    List<String> ans;
    public List<String> addOperators(String num, int target) {

        ans=new ArrayList<>();
        expression(num, target, new StringBuilder(), 0, -1);
        return ans;

    }
    public void expression(String num, int target, StringBuilder sb, int i, int ptr){

        if(i==num.length()){
            long match=eval(sb.toString());
            
            if(match==(long)target){
                // System.out.println(sb.toString()+" "+match);
                ans.add(sb.toString());
            }
            return;
        }
        char ch=num.charAt(i);
        if((i==num.length()-1 && num.length()==1) || (i==0)
        ){
            
            //last index or first index

            sb.append(num.charAt(i));
            if(ch=='0'){
            expression(num, target, sb, i+1, ptr);
            }
            else{
            expression(num, target, sb, i+1, i);
            }
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        else{
            // if(ch=='0'){
            //take(3 ways) or leave
            if(ptr!=-1){
            sb.append(num.charAt(i));
            if(ch=='0'){
            expression(num, target, sb, i+1, ptr);
            }
            else{
                expression(num, target, sb, i+1, i);
            }
            sb.deleteCharAt(sb.length()-1);
            }

            sb.append('+');
            sb.append(num.charAt(i));
            if(ch=='0'){
            expression(num, target, sb, i+1, -1);
            }
            else{
            expression(num, target, sb, i+1, i);
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            
            sb.append('-');
            sb.append(num.charAt(i));
            if(ch=='0'){
            expression(num, target, sb, i+1, -1);
            }
            else{
            expression(num, target, sb, i+1, i);
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);

            sb.append('*');
            sb.append(num.charAt(i));
            if(ch=='0'){
            expression(num, target, sb, i+1, -1);
            }
            else{
            expression(num, target, sb, i+1, i);
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            }
        return;
    }
    public long eval(String s){
        Stack<Long> stk=new Stack<>();
        char sign='+';
        long num=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
                if(num<Integer.MIN_VALUE || num>Integer.MAX_VALUE){
                    return Long.MIN_VALUE;
                }
            }
            if(!Character.isDigit(ch) || i==s.length()-1){
                if(sign=='+'){
                    if(num<Integer.MIN_VALUE || num>Integer.MAX_VALUE){
                    return Long.MIN_VALUE;
                }
                    stk.push(num);
                }
                else if(sign=='-'){
                    if(num<Integer.MIN_VALUE || num>Integer.MAX_VALUE){
                    return Long.MIN_VALUE;
                }
                    stk.push(-num);
                }
                else if(sign=='*'){
                    if(num<Integer.MIN_VALUE || num>Integer.MAX_VALUE){
                    return Long.MIN_VALUE;
                }
                    stk.push(stk.pop()*num);
                }
                num=0;
                sign=ch;
            }
        }

        long res=0;
        for(long n: stk){
            res+=n;
        }
        if(res<Integer.MIN_VALUE || res>Integer.MAX_VALUE){
                    return Long.MIN_VALUE;
                }

        return res;
    }
}