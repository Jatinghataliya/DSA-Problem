class ValidParantheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>(s.length());

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        ValidParantheses validParantheses = new ValidParantheses();

        String s = "()[]{}";

        System.out.println(validParantheses.isValid(s));

    }

}