package top.hengshare.interview.el;

import com.google.common.collect.Maps;
import de.odysseus.el.util.SimpleContext;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import java.util.HashMap;

public class ELExpression {
    public static void main(String[] args) {

        ExpressionFactory factory = ExpressionFactory.newInstance();
        SimpleContext context = new SimpleContext();
        ValueExpression expr = factory.createValueExpression(context, "${!\"bc\".contains(\"a\")}", Object.class);
        boolean a = (boolean)expr.getValue(context);
        System.out.println(a);
    }
}
