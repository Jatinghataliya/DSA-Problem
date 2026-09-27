public class PrefixToPostfix {
    
    public String convertPrefixToPostfix(String prefix){
        Stack<String> stack = new Stack<>(prefix.length());
        int i = prefix.length() - 1;
        while (i >= 0){
            char c = prefix.charAt(i);
            if (Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else {
                stack.push(stack.pop() + stack.pop() + c);
            }
            i--;
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        PrefixToPostfix converter = new PrefixToPostfix();
        String prefix = "*+ABC";
        String postfix = converter.convertPrefixToPostfix(prefix);
        System.out.println("Prefix: " + prefix);
        System.out.println("Postfix: " + postfix);
    }

}
