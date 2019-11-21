package top.hengshare.interview.jse5.enums;

/**
 * @program: Java-Interview
 * @description: OzWitch
 * @author: StivenYang
 * @create: 2019-11-21 16:16
 **/
public enum OzWitch {
    WEST("西"),
    NORTH("北"),
    EAST("东"),
    SOUTH("南");

    private String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }



    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }
}
