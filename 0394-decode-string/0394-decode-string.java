class Solution {
    public String decodeString(String s) {
        Stack<Integer> countstack=new Stack<>();
        Stack<StringBuilder> stringstack=new Stack<>();
        StringBuilder currentstring=new StringBuilder();
        int k=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
            k=k*10+(ch-'0');
            }
             else if(ch=='['){
            countstack.push(k);
            stringstack.push(currentstring);
            k=0;
            currentstring=new StringBuilder();
            }
            else if(ch==']'){
            StringBuilder decodedstring=stringstack.pop();
            int count=countstack.pop();
            for(int i=0;i<count;i++){
                decodedstring.append(currentstring);
            }
            currentstring=decodedstring;
            }
             else{
            currentstring.append(ch);
             }
        }
        return currentstring.toString();
    }
    
}
