class ValidParantheses {
    /*
     * Logic:
     * 1. Traverse the string character by character.
     * 2. If the character is an opening bracket, push it into the stack.
     * 3. If it is a closing bracket, then:
     *    - stack must not be empty - invalid parentheses
     *    - the top of stack must be the matching opening bracket
     *    - if not, the string is invalid
     * 4. After processing all characters, the stack must be empty.
     *
     * Example:
     * "()[]{}" -> valid
     * "([)]"   -> invalid
     */

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>(s.length());

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                // Opening bracket: push to stack
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    // Closing bracket appears without a matching opening one
                    return false;
                }

                char top = stack.pop();

                // Check if the top opening bracket matches this closing bracket
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // All brackets are matched only if stack is empty at the end
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        ValidParantheses validParantheses = new ValidParantheses();

        String s = "()[]{}";

        System.out.println(validParantheses.isValid(s));

    }

}