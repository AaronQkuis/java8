package com.aaron.interview.base;

/**
 * @author qikun
 * @date 11/8/2024  3:54 PM
 */
public interface ITestInterface {
    int a = 1;
    public abstract void run();
    void fly();
    default void eat() {
        System.out.println("ok");
    }
}
