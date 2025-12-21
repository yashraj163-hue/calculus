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