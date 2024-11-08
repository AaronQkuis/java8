package com.aaron.interview.base;

/**
 * @author qikun
 * @date 11/8/2024  3:57 PM
 */
public  class TestInterfaceImpl implements ITestInterface{
    @Override
    public void run() {

    }

    @Override
    public void fly() {
        //ITestInterface.a = 3;
        System.out.println(ITestInterface.a);
    }

    @Override
    public void eat() {
        //ITestInterface.super.Eat();
        System.out.println("sorry");
    }

    public static void main(String[] args) {
        TestInterfaceImpl testInterface = new TestInterfaceImpl();
        testInterface.eat();
    }
}
