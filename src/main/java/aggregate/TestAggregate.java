package aggregate;

import java.util.ArrayList;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-04-16 20:44
 */
public class TestAggregate {
    public static void main(String[] args) {
        ArrayList<Hero> ls = new ArrayList<>();
        ls.add(new Hero("阿卡丽", 40, 700));
        ls.add(new Hero("阿狸", 35, 500));
        ls.add(new Hero("伊芙琳", 30, 600));
        ls.add(new Hero("卡莎", 25, 400));
        ls.add(ls.get(2));
        ls.add(ls.get(2));
        ls.add(ls.get(2));

        ls.stream().distinct().filter(hero -> hero.hp > 400).sorted((o1, o2) -> o1.damage >= o2.damage ? 1 : -1).forEach(i -> System.out.println("i = " + i));
    }
}
