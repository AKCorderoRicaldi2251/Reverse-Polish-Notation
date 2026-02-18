import java.lang.Math;

public class Main {
    /**
     * Evaluates a mathematical expression written in Reverse Polish Notation (RPN).
     *
     * The method processes tokens from left to right
     * @param expression The RPN expression as a space-separated string.
     * @return The evaluated result rounded to 9 decimal places.
     *
     * @throws IllegalArgumentException if:
     *         - The expression is null or empty
     *         - There are invalid tokens
     *         - There are insufficient operands
     *         - There are too many operands remaining
     *
     * @throws ArithmeticException if division by zero occurs.
     */

    public double evaluateStr(String expression){
        Stack<Double> stack = new LinkedStack<>();

        if(expression == null || expression.trim().isEmpty()){
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        String[] stringRPN = expression.split(" ");

        for(String s : stringRPN){

            if(isOperator(s)){
                if (stack.size() <2) {
                    throw new IllegalArgumentException("Invalid RPN expression: not enough operands");
                }

                double b = stack.pop();
                double a = stack.pop();

                switch(s){
                    case "+":
                        stack.push(a+b
                        );
                        break;

                    case "-":
                        stack.push(a - b);
                        break;

                    case "^":
                        stack.push(Math.pow(a, b));
                        break;

                    case "*":
                        stack.push(a * b);
                        break;

                    case "/":
                        if(b == 0){
                            throw new ArithmeticException("Division by zero");

                        }
                        stack.push(a / b);
                        break;
                }
            }
            else if(isNumber(s)){
                stack.push(Double.parseDouble(s));
            }
            else{
                throw new IllegalArgumentException("Invalid token: " + s);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression: too many operands");

        }
        double result = stack.pop();
        return Math.round(result * 1000000000.0) / 1000000000.0;  // floating point fix
    }
    /**
     * Determines whether a given string token is a valid operator.
     *
     * @param s The token to check.
     * @return true if the token is one of the supported operators,
     *         otherwise false.
     */

    public boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("^")
                || s.equals("*") || s.equals("/");
    }
    /**
     * Determines whether a given string token represents a valid number.
     *
     * The method attempts to parse the string as a double.
     * If parsing succeeds, the token is considered numeric.
     *
     * @param s The token to check.
     * @return true if the token can be parsed as a double,
     *         otherwise false.
     */

    public static boolean isNumber(String s){
        try{
            Double.parseDouble(s);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    public static void main(String[] args){
        Main m = new Main();


        System.out.println(m.evaluateStr(" 2 3 /"));

    }
}
