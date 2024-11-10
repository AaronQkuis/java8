package com.aaron.interview.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qikun
 * @date 11/8/2024  6:02 PM
 */
class Parent<T> {
    public void print(T value) {
        System.out.println("Parent: " + value);
    }
    class Solution {
        public  int test () {
            return 0;
        }
    }
}
class Child extends Parent<Integer> {
    @Override
    public void print(Integer value) {
        System.out.println("Child: " + value);
    }
}

class Animal {
    public void eat(String value) {
        System.out.println("Animal");
    }
}

class Dog extends Animal {
    public void eat(String value) {
        System.out.println("Dog");
    }
}

class BullDog extends Dog {
    public void eat(String value) {
        System.out.println("BullDog");
    }
}

public class Main {
    public static void main(String[] args) {
        List<? extends Dog> extendsList = new ArrayList<>();
        //extendsList.add(new BullDog()); 不能添加
        List<? super Dog> superList = new ArrayList<>();
        superList.add(new Dog());
        superList.add(new BullDog());
        // superList.add(new Animal());
        // Animal animal = (Animal) superList.get(0);
        List<String> strings = new ArrayList<>();
        strings.add("a");
        Parent<BullDog> bullDogParent = new Parent<>();
        bullDogParent.print(new BullDog());
    }
}

