package Interpreter;

//或表达式
public class OrExpression implements IExpression {
    private IExpression expr1 = null;
    private IExpression expr2 = null;
    public OrExpression(IExpression expr1, IExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
