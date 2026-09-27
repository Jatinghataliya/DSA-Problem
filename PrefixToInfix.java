public class PrefixToInfix {
    
    public String convertPrefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>(prefix.length());

        // Scan the prefix expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                // Operand: push it as a single expression
                stack.push(String.valueOf(c));
            } else { // operator
                // Operator means we need two operands from the stack
                String left = stack.pop();
                String right = stack.pop();

                // Combine them as (left operator right)
                stack.push("(" + left + c + right + ")");
            }
        }

        // After processing all symbols, the last remaining value is the infix expression
        return stack.pop();
    }

    public static void main(String[] args) {
        PrefixToInfix converter = new PrefixToInfix();
        String prefix = "*+ab+c";
        String infix = converter.convertPrefixToInfix(prefix);
        System.out.println("Prefix: " + prefix);
        System.out.println("Infix: " + infix);
    }

}
