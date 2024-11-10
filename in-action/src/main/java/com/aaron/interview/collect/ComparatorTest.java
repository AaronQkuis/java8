package com.aaron.interview.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author qikun
 * @date 11/9/2024  5:19 PM
 */
class Student {
    private String name;
    private int age;

    public Student(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// 按照年龄排序的比较器
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student p1, Student p2) {
        return p1.getAge() - p2.getAge();  // 按照年龄升序排序
    }
}

// 按照名字排序的比较器
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student p1, Student p2) {
        return p1.getName().compareTo(p2.getName());  // 按照名字字母升序排序
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(new Student(101,"Vijay"));
        al.add(new Student(106,"Ajay"));
        al.add(new Student(105,"Jai"));
        Collections.sort(al, new AgeComparator());
        System.out.println(al.toString());
    }
}
