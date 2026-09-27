public class PostfixToInfix {
    /*
     * Logic used to convert postfix to infix:
     * 1. Scan the postfix expression from left to right.
     * 2. If the current symbol is an operand, push it onto the stack.
     * 3. If the current symbol is an operator, pop the top two operands.
     * 4. Combine them as (leftOperand operator rightOperand) and push the result back.
     * 5. At the end, the stack contains the full infix expression.
     *
     * Example:
     * postfix = ab+c*
     * scan: a -> push, b -> push, + -> pop b, a => (a+b), c -> push, * -> pop c, (a+b) => ((a+b)*c)
     */
    public String convertPostfixToInfix(String postfix) {
        // Stack stores partial infix expressions.
        Stack<String> stack = new Stack<>(postfix.length());

        for (char c : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                // Operand: push it as a single expression.
                // Example: a -> stack.push("a")
                stack.push(String.valueOf(c));
            } else { // operator
                // Operator means we need two operands from the stack.
                // Because postfix is left-to-right, the first pop is the right operand,
                // and the second pop is the left operand.
                String right = stack.pop();
                String left = stack.pop();

                // Combine them as (left operator right)
                // Example: left = "a", right = "b", operator = "+" => "(a+b)"
                stack.push("(" + left + c + right + ")");
            }
        }

        // After processing all symbols, the last remaining value is the infix expression.
        return stack.pop();
    }

    public static void main(String[] args) {
        PostfixToInfix converter = new PostfixToInfix();
        String postfix = "ab+c*";
        String infix = converter.convertPostfixToInfix(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + infix);
    }

}