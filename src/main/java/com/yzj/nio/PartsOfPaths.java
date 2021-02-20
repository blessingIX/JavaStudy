package com.yzj.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-05-12 12:15
 */
public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("D:\\IDEA projects\\JavaStudy\\src\\cn\\edu\\jsu\\nio\\PartsOfPaths.java");
        for(int i = 0; i < p.getNameCount(); i++)
            System.out.println(p.getName(i));
        System.out.println("ends with '.java': " + p.endsWith(".java"));
        for(Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }
        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
        try {
            System.out.println(Files.getOwner(p));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
