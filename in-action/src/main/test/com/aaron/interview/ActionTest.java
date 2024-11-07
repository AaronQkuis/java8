package com.aaron.interview;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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


}
