package com.yzj.io;

import java.io.*;
import java.nio.file.*;

/**
 * @description: 某个文件夹下的所有.java文件复制到另一个文件夹并后缀名改为.txt
 * @author: 易子建
 * @create: 2020-10-30 16:47
 */
public class CopyAllJavaFile {

    public static void main(String[] args) throws IOException {

//        io();
        nio();

    }

    public static void nio() throws IOException {
        String originFolder = "D:\\TestFolder\\java\\"; // 源文件夹
        String targetFolder = "D:\\TestFolder\\jad\\";  // 目标文件夹
        String suffix = ".txt";                         // 复制后后缀名
        Path originPath = Paths.get(originFolder);      // 通过Paths类获取源文件夹的Path

        // Files.newDirectoryStream(Path path)  打开一个目录，返回一个DirectoryStream以遍历目录中的所有条目。
        DirectoryStream<Path> paths = Files.newDirectoryStream(originPath);
        for (Path next : paths) {   // DirectoryStream继承了Iterator接口，可以使用forEach遍历
            System.out.println(next);
            Path fileName = next.getFileName(); // 文件名（不包括目录）
            String originSuffix = fileName.toString().substring(fileName.toString().indexOf("."));  // 源文件名的后缀
            if (!".java".equals(originSuffix)) continue;    // 过滤非 .java 后缀文件
            String prefix = fileName.toString().substring(0, fileName.toString().indexOf("."));     // 源文件名的前缀
            Path targetPath = Paths.get(targetFolder, prefix + suffix); // 拼接 目标目录、源文件名的前缀、新后缀
            Files.copy(next, targetPath);       // 复制
        }
    }

    public static void io() throws FileNotFoundException {
        String originFolder = "D:\\TestFolder\\java\\";
        String targetFolder = "D:\\TestFolder\\jad\\";
        String suffix = ".txt";

        File origin = new File(originFolder);

        File[] files = origin.listFiles();
        if (files == null) files = new File[0];
        System.out.println(files.length);

        for (File file : files) {
            System.out.println(file);
            String f = file.toString();

            String fileName = f.substring(f.lastIndexOf("\\"));
            String prefix = fileName.substring(0, fileName.indexOf("."));

            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream fos = new BufferedOutputStream((new FileOutputStream(targetFolder + prefix + suffix)));

            byte[] b = new byte[1024];
            int len = 0;
            try {
                while ((len = fis.read(b)) > 0) {
                    fos.write(b, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
