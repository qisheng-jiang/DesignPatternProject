package Interpreter;

// 动物表达式
public class AnimalInterpreterPattern {
    //Robert 和 John 都不是小狗
    public static IExpression getDogExpression() {
        IExpression robert = new TerminalExpression("Robert");
        IExpression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //Julie 不是一只母鸡
    public static IExpression getHenExpression() {
        IExpression julie = new TerminalExpression("Julie");
        IExpression hen = new TerminalExpression("Hen");
        return new AndExpression(julie, hen);
    }
}
