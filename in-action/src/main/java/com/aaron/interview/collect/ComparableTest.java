package com.aaron.interview.collect;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author qikun
 * @date 11/9/2024  5:18 PM
 */

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(int age, String name) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;  // 按照年龄升序排序
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ComparableTest {
    public static void main(String[] args) {
        ArrayList<Person> al = new ArrayList<Person>();
        al.add(new Person(101,"Vijay"));
        al.add(new Person(106,"Ajay"));
        al.add(new Person(105,"Jai"));
        Collections.sort(al);
        System.out.println(al.toString());
    }
}
