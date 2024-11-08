package com.aaron.interview.demo;

/**
 * @author qikun
 * @date 11/7/2024  11:27 PM
 */
public class StaticWithoutmain {
    /**
     * jdk6 之前可以运行，没有main
     */
    static{
        System.out.println("hello world");
        System.exit(0);
    }
}
