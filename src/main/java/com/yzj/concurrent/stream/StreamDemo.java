package com.yzj.concurrent.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-27 20:02
 */
public class StreamDemo {

    public static void main(String[] args) {

        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(5, "e", 25);
        User u6 = new User(6, "f", 26);

        List<User> users = Arrays.asList(u1, u2, u3, u4, u5, u6);

        users.stream()
                .filter(u -> u.getId() % 2 == 0)
                .filter(u -> u.getAge() > 23)
                .map((u -> u.getName().toUpperCase()))
                .sorted(String::compareTo)
                .forEach(System.out::println);

    }

}
 class User {
     private int id;
     private String name;
     private int age;

     public User(int id, String name, int age) {
         this.id = id;
         this.name = name;
         this.age = age;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     @Override
     public String toString() {
         return "User{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }
 }