package com.aaron.interview.collect;

import org.junit.Test;

import java.util.*;

/**
 * @author qikun
 * @date 11/10/2024  3:32 PM
 */
public class HashMapTest {
    @Test
    public void hasmapRemove() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // 删除键为 "B" 的元素
        map.remove("B");

        System.out.println("After removal: " + map);
    }

    @Test
    public void hashmapSafeRemoveTest() {
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);

        // 多线程删除操作
        Runnable removeTask = () -> {
            synchronized (map) {
                Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator.next();
                    if (entry.getValue() < 3) {
                        iterator.remove();
                    }
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " finished removal");
            }
        };

        // 创建并启动线程
        Thread thread1 = new Thread(removeTask);
        Thread thread2 = new Thread(removeTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final map content: " + map);
    }
    @Test
    public void treeMapTest() {
        Comparator<String> customComparator = (key1, key2) -> key1.length() - key2.length();

        Map<String, String> map = new TreeMap<>(customComparator);

        map.put(null, "test");
        map.get(null);
    }
}

