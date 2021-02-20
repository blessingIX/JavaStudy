package com.yzj.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-05-12 15:27
 */
public class RmDir {
    public static void rmdir(Path dir) throws IOException {
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                System.out.println("deleted " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                System.out.println("deleted " + dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args){
        Path dir = Paths.get("E:\\新建文件夹");
        try {
            rmdir(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
