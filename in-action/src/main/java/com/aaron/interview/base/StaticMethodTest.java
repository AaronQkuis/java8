package com.aaron.interview.base;

/**
 * @author qikun
 * @date 11/8/2024  3:07 PM
 */
public class StaticMethodTest {

    int normalVariable;

    static int staticVariable = 3;

    public StaticMethodTest() {
        //staticVariable = 2;
        normalVariable = 3;
    }

    /**
     * 非静态方法
     */
    public void normalMethod(String data) {
        // 非静态方法调用静态方法
        staticMethod(data);
    }

    /**
     * 静态方法
     */
    public static void staticMethod(String data) {
        staticVariable = 4;
        System.out.println("static:" + data);
    }


    public static void main(String[] args) {
        // 静态方法调用
        StaticMethodTest.staticMethod("hello");
        // 实例化
        final StaticMethodTest palindrome = new StaticMethodTest();
        // 非静态方法调用
        palindrome.normalMethod("xf");
        // 通过实例对象调用非静态方法调用
        palindrome.staticMethod("chen");
    }

}
