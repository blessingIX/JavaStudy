package com.yzj.lang;

import java.util.StringJoiner;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-06-21 14:48
 */
public class StringJoinerTest {
    public static void main(String[] args) {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }

    static String buildSelectSql(String table, String[] fields) {
        // TODO:
        StringJoiner sj = new StringJoiner(", ", "SELECT ", " FROM " + table);
        for (String field : fields) {
            sj.add(field);
        }
        return sj.toString();
    }

}
