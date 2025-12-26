//all precedence function will be added subsequently
// this block is just for inspiration
//use only as logic reference currently and edit comment after execution

package io.calculus.evaluate;
class Eval
{
public static double eval(String expr) {
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
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {
            while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c))
                values.push(apply(ops.pop(), values.pop(), values.pop()));
            ops.push(c);
        }
    }
    while (!ops.isEmpty())
        values.push(apply(ops.pop(), values.pop(), values.pop()));

    return values.pop();
}

}
