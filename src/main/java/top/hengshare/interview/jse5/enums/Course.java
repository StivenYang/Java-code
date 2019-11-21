package top.hengshare.interview.jse5.enums;

import top.hengshare.interview.pattern.command.backCall.version0.Printer;

/**
 * @program: Java-Interview
 * @description: Course
 * @author: StivenYang
 * @create: 2019-11-21 21:51
 **/
public enum Course {
    APPETIZER (Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    private Course(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }

    public Food randomSelection(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i<5; i++){
            for (Course value : Course.values()) {
                Food food = value.randomSelection();
                System.out.println(food);
            }
            System.out.println("--------");
        }
    }
}
