package com.aaron.interview;

import com.aaron.interview.demo.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.SQLException;

/**
 * @author qikun
 * @date 1/25/2024  10:35 PM
 */
public class ActionTest {
    @Test
    public void helloWorld() {
        System.out.printf("hello world");
    }


    @Test
    public void arrayNullTest() {
        int[] intArray = new int[3];
        System.out.println(intArray[0]);
    }
    @Test
    public void arrayNullStringTest () throws FileNotFoundException {
        File file = new File("");
        String[] stringArray = new String[3];
        System.out.println(stringArray[0].length());
    }

    /**
     * 一个 catch 捕获多个异常
     */
    @Test
    public void multiExceptionTest() {
        try {
            if (true) {
                throw new IOException("Error");
            } else {
                throw new SQLException("Error");
            }
        } catch (IOException | SQLException e) {
            System.out.println("Caught exception: " + e);
            //e.getSQLState(); // 编译错误：Exception 类型中不存在此方法
        }
    }

    /**
     * 强制类型转换测试
     */
    @Test
    public void transTest() {
        short a = 200;
        System.out.println(Integer.toBinaryString(a));
        byte b = (byte) a;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(b);
    }
    /**
     * var test
     */
    @Test
    public void varTest() {
        //var a= new Person(); //error
        var a = 1;
        switch (a) {
            case 1:
                System.out.println(1);
                break;
            default:
                System.out.println(2);
                break;
        }
    }

    /**
     * string encode test
     */
    @Test
    public void strEncodeTest() {
        try {
            // 原字符串
            String str = "你好，世界";

            // 将字符串按照 UTF-8 编码转换为字节数组
            byte[] utf8Bytes = str.getBytes("UTF-8");

            // 将字节数组按照 ISO-8859-1 编码重新构造为字符串
            String newStr1 = new String(utf8Bytes, "ISO-8859-1");
            String newStr2 = new String(utf8Bytes, Charset.forName("ISO-8859-1"));

            System.out.println("原字符串: " + str);
            System.out.println("转换后的字符串: " + newStr1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mathRoundTest() {
        System.out.println(Math.round(-1.5));  // 输出 -1
        System.out.println(Math.round(-1.4));  // 输出 -1
        System.out.println(Math.round(-2.5));  // 输出 -2
        System.out.println(Math.round(-2.6));  // 输出 -3
        System.out.println(Math.round(1.5));  // 输出 2
        System.out.println(Math.round(1.4));  // 输出 1
        System.out.println(Math.round(2.5));  // 输出 3
        System.out.println(Math.round(2.6));  // 输出 3
    }


}
