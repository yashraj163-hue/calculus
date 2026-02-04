//all precedence function will be added subsequently
// this block is just for inspiration
//use only as logic reference currently and edit comment after execution

package io.calculus.evaluate;
import java.util.Stack;

class Eval
{
public double eval(String expr) {
    Stack<Double> values = new Stack<>();
    Stack<Character> ops = new Stack<>();

    for (int i = 0; i < expr.length(); i++) {
        char c = expr.charAt(i);

        if (Character.isDigit(c)) {
            double val = 0;
            while (i < expr.length() && Character.isDigit(expr.charAt(i)))
                val = val * 10 + (expr.charAt(i++) - '0');
            if (i < expr.length() && expr.charAt(i) == '.') {
                double factor = 0.1;
                while (++i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    val += (expr.charAt(i) - '0') * factor;
                    factor *= 0.1;
                }
            }
            values.push(val);
            i--;
        } else  {
            while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c))
                values.push(apply(ops.pop(), values.pop(), values.pop()));
            ops.push(c);
        }
    }
    while (!ops.isEmpty())
        values.push(apply(ops.pop(), values.pop(), values.pop()));

    return values.pop();
}

    public int precedence(char c) {
        switch (c) {
            case '(':
            case ')':
            case '[':
            case ']':
            case '{':
            case '}':
                return 8; // 1 (Highest) - Grouping Symbols
            // Functions (2) are typically handled during parsing
            case '!':
                return 6; // 3 - Factorials
            case '^':
                return 5; // 4 - Exponentiation
            case '√':
                return 4; // 5 - Roots
            // Unary (6) + and - are context-dependent
            case '*':
            case '/':
            case '×':
            case '⋅':
            case '÷':
                return 2; // 7 - Multiplication and Division
            case '+':
            case '-':
                return 1; // 8 (Lowest) - Addition and Subtraction
            default:
                return -1;
        }
}

    public  double apply(char op, double b, double a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*':
            case '×':
            case '⋅':return a * b;
            case '÷':
            case '/': return a / b;
            //case '^': return Math.pow(a, b); //need to handle the r to l precedence
            case '√':return Math.sqrt(b);

            default: return 0;
        }
    }
}
