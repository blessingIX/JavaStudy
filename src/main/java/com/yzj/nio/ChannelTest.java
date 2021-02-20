package com.yzj.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-05-12 17:17
 */
public class ChannelTest {
    public static  void test1() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("E:\\新建文件夹\\ChannelTest.txt", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = 0;
        try {
            bytesRead = inChannel.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            try {
                bytesRead = inChannel.read(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cp(String s, String t) {
        File src = new File(s);
        File tar = new File(t);

        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(tar);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        byteBuffer.clear();
        try {
            while (inChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        test1();
        String[] cpg = new String[] {
                "E:\\新建文件夹\\ChannelTest.txt",
                "E:\\新建文件夹\\ChannelTest-copy.txt"
        };
        cp(cpg[0], cpg[1]);
    }
}
