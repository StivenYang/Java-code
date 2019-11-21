package top.hengshare.interview.jse5.enums;

/**
 * @program: Java-Interview
 * @description: 使用接口组织枚举
 * @author: StivenYang
 * @create: 2019-11-21 21:44
 **/
public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUMMOUS, VINDALOO
    }

    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE,
        FRUIT, CREME_CARAMEL;
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
        LATTE, CAPPUCCINO, TEA, HERB_TEA
    }

    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = MainCourse.BURRITO;
        food = Dessert.CREME_CARAMEL;
        food = Coffee.DECAF_COFFEE;
    }
}
