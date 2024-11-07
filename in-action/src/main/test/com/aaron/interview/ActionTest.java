package com.aaron.interview;

import org.junit.Test;

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


}
