public class PostfixToPrefix {
    
    public String convertPostfixToPrefix(String postfix){
        Stack<String> stack = new Stack<>(postfix.length());
        int i = 0;
        while (i < postfix.length()){
            char c = postfix.charAt(i);
            if (Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else {
                stack.push(c + stack.pop() + stack.pop());
            }
            i++;
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        PostfixToPrefix converter = new PostfixToPrefix();
        String postfix = "AB+C*";
        String prefix = converter.convertPostfixToPrefix(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + prefix);
    }

}
