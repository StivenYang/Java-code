package top.hengshare.interview.pattern.interpreter.parse;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: 用来封装每个解析出来的元素对应的属性
 * @author: StivenYang
 * @create: 2019-10-29 20:04
 **/
@Data
public class ParserModel {

    /**
     * 是否单个值
     */
    private boolean singleValue;

    /**
     * 是否属性，不是属性就是元素
     */
    private boolean propertyValue;

    /**
     * 是否终结符
     */
    private boolean end;
}
