import java.lang.Math;

public class Main {

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
        return Math.round(result * 1000000000.0) / 1000000000.0;
    }

    public boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("^")
                || s.equals("*") || s.equals("/");
    }

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

        System.out.println(m.evaluateStr(" 2 /"));
        System.out.println(m.evaluateStr("baaa"));
        System.out.println(m.evaluateStr("0.2 0.1 +")); // floating point problem because IEEE-754
        System.out.println(m.evaluateStr("2 3 "));
        System.out.println(m.evaluateStr("2 0 /"));

    }
}
