class InfixToPostfix {
    /*
     * Logic summary:
     * 1. Scan the infix expression from left to right.
     * 2. If the current character is an operand (letter/digit), append it to postfix.
     * 3. If it is '(', push it to the stack.
     * 4. If it is ')', pop all operators until '(' is found.
     * 5. If it is an operator, pop operators from the stack while they have
     *    higher or equal precedence, then push the current operator.
     * 6. After scanning the whole expression, pop all remaining operators.
     *
     * Precedence:
     * +, -   -> 1
     * *, /   -> 2
     * ^      -> 3
     *
     * Example:
     * infix: a+b*c
     * postfix: abc*+
     */
    
    public String convertInfixToPostfix(String infix){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>(infix.length());

        for (char c : infix.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                // Operand: directly add to postfix output
                postfix.append(c);
            } else if (c == '('){
                // Opening bracket: push to stack
                stack.push(c);
            } else if (c == ')'){
                // Closing bracket: pop until matching opening bracket
                while (!stack.isEmpty() && stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                stack.pop(); // remove the '('
            } else { // operator
                // For operators, pop previous operators with higher/equal precedence
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())){
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

    public int priority(char operator) {
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
        InfixToPostfix converter = new InfixToPostfix();
        String infix = "a+b*c";
        String postfix = converter.convertInfixToPostfix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
    }

}
