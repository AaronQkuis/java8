package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author qikun
 * @date 2/15/2024  5:19 PM
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        CircleQueue circleQueue = new CircleQueue(3);
        boolean loop = true;
        while (loop) {
            System.out.println("e: 退出");
            System.out.println("a: add queue");
            System.out.println("g: get queue");
            System.out.println("h: show head queue");
            System.out.println("t: show tail queue");
            System.out.println("s: show all queue");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    try {
                        int addNum = scanner.nextInt();
                        circleQueue.addQueue(addNum);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(circleQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    try {
                        circleQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

/**
 * 思路如下:
 * 1.  front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
 * front 的初始值 = 0
 * 2.  rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
 * rear 的初始值 = 0
 * 3. 当队列满时，条件是  (rear  + 1) % maxSize == front 【满】
 * 4. 对队列为空的条件， rear == front 空
 * 5. 当我们这样分析， 队列中有效的数据的个数   (rear + maxSize - front) % maxSize   // rear = 1 front = 0
 * 6. 综上，就可以在原来的队列上修改得到，一个环形队列。
 */
class CircleQueue {
    private int rear;
    private int front;
    private int maxSize;
    private int[] array;

    public CircleQueue(int maxSize) {
        rear = 0;
        front = 0;
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public boolean isFull () {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列满了，无法入队");
            return;
        }
        array[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法出队");
        }
        int value = array[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue () {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println(array[i % maxSize]);
        }
    }
}