package aggregate;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-04-16 21:03
 */
public class Hero {
    public String name;
    public int damage;
    public int hp;

    public Hero() {
    }

    public Hero(String name, int damage, int hp) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", hp=" + hp +
                '}';
    }
}
