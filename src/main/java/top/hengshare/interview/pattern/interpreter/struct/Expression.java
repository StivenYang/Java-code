package top.hengshare.interview.pattern.interpreter.struct;

/**
 * @program: Java-Interview
 * @description: Expression
 * @author: StivenYang
 * @create: 2019-10-24 20:31
 **/
public abstract class Expression {
    /**
     * 解释动作
     * @param ctx
     */
    public abstract void interpret(Context ctx);
}
