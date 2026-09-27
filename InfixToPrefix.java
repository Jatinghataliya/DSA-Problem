class InfixToPrefix {
    /*
     * Logic used to convert infix to prefix in this implementation:
     * 1. Reverse the infix expression.
     * 2. Swap '(' and ')' in the reversed expression so the stack logic works correctly.
     *    This is needed because we are converting the reversed expression into postfix.
     * 3. Convert the modified expression to postfix using a stack.
     * 4. Reverse the postfix result to get the prefix expression.
     *
     * Example:
     * Infix: a+b*c
     * Reverse: c*b+a
     * Swapped parentheses: c*b+a
     * Postfix: c b * a +
     * Prefix: + a * b c
     */
    public String convertInfixToPrefix(String infix) {
        // Step 1: Reverse the infix expression.
        // Example: a+b*c becomes c*b+a
        String reversedInfix = new StringBuilder(infix).reverse().toString();

        // Step 2: Swap '(' and ')' in the reversed expression.
        // This is necessary in this method so that bracket matching works correctly
        // when converting the reversed expression to postfix.
        reversedInfix = reversedInfix.replace('(', 'X').replace(')', '(').replace('X', ')');

        // Step 3: Convert the modified infix expression into postfix.
        String postfix = convertInfixToPostfix(reversedInfix);

        // Step 4: Reverse the postfix output to get the final prefix form.
        return new StringBuilder(postfix).reverse().toString();
    }

    /*
     * This method converts a standard infix expression to postfix using a stack.
     * Rules:
     * - Operands are appended directly to the postfix result.
     * - '(' is pushed to the stack.
     * - ')' pops operators until '(' is found.
     * - For operators, higher/equal precedence operators are popped before the current one.
     */
    private String convertInfixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>(infix.length());

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                // Operand: directly add to postfix output
                postfix.append(c);
            } else if (c == '(') {
                // Opening bracket: push to stack
                stack.push(c);
            } else if (c == ')') {
                // Closing bracket: pop until matching opening bracket
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // remove the '('
            } else { // operator
                // For operators, pop previous operators with higher/equal precedence
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Add remaining operators left in stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    /*
     * priority() assigns precedence values to operators.
     * Higher value = higher priority.
     * ^ > * / > + -
     */
    private int priority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        InfixToPrefix converter = new InfixToPrefix();
        String infix = "a+b*c";
        String prefix = converter.convertInfixToPrefix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + prefix);
    }
}