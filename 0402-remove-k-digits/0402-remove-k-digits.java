class Solution {
    public String removeKdigits(String num, int k) {
    Stack<Character> stack = new Stack<>();
    
    for (char digit : num.toCharArray()) {
        while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
            stack.pop();
            k--;
        }
        stack.push(digit);
    }
    
    // Agar k abhi bhi bacha hai (jaise "123" mein k=1)
    while (k > 0 && !stack.isEmpty()) {
        stack.pop();
        k--;
    }
    
    // Stack ko string mein badalna
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) sb.append(stack.pop());
    sb.reverse();
    
    // Leading zeros hatao
    while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
    
    return sb.toString().isEmpty() ? "0" : sb.toString();
    }
}