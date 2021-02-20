package com.yzj.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 在某文本文件的某个特定行的前/后插入几行文字
 * @author: 易子建
 * @create: 2020-10-30 20:09
 */
public class InsertRowsIntoTextFile {
    public static final int BEFORE = 0; // 在指定行前插入
    public static final int AFTER = 1;  // 在指定行后插入

    public static void main(String[] args) throws IOException {
        addControllerHeader();
    }

    public static void insert(String p, List<String> rows, String keyRow, int position) throws IOException {
        // 读取文件的所有行存入list，需要插入的行add至list，最后将list写回文件
        // Files.readAllLines(Path path, Charset cs):List<String>
        // Files.write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options):Path
        Path path = Paths.get(p);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        int col = -1;
        for (String line : lines) {
            col++;
            if (keyRow.equals(line) || (keyRow + "\n").equals(line)) {
                break;
            }
        }
        int i = position == 0 ? col : col + 1;
        for (String row : rows) {
            lines.add(i++, row);
        }
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public static void insert(String p, List<String> rows, String keyRow) throws IOException {
        insert(p, rows, keyRow, AFTER);
    }

    public static void addControllerHeader() throws IOException {
        String p = "D:\\TestFolder\\insetRowsIntoTextFile\\TestController.java";
        List<String> rows = new ArrayList<>();
        rows.add("/**");
        rows.add(" * @description:");
        rows.add(" * @author: 易子建");
        rows.add(" * @create: " + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) + "");
        rows.add(" */");
        String keyRow = "@Controller";
//        insert(p, rows, keyRow, BEFORE);
        insert(p, rows, keyRow, AFTER);
        System.out.println("finished");
    }

}
