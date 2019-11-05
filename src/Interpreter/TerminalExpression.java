package Interpreter;

//终结表达式
public class TerminalExpression implements IExpression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }
    @Override
    public boolean interpret(String context) {
        if(!context.contains(data)){
            return true;
        }
        return false;
    }
}
