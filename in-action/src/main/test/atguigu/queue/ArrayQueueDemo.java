package atguigu.queue;

import java.util.Scanner;

/**
 * @author qikun
 *
 * 队列只能用一次
 * @date 2/15/2024  4:29 PM
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
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
                case 'e' :
                    scanner.close();
                    loop = false;
                    break;
                case 'a' :
                    try {
                        int addNum = scanner.nextInt();
                        arrayQueue.addQueue(addNum);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        arrayQueue.showHeadQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 't':
                    try {
                        arrayQueue.showTailQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    try {
                        arrayQueue.showQueue();
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

class ArrayQueue {
    private int rear;
    private int front;
    private int maxSize;
    private int[] array;

    // 初始化
    public ArrayQueue(int maxSize) {
        rear = -1;
        front = -1;
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    // 队列满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 队列空
    public boolean isEmpty() {
        return rear == front;
    }
    // 入队列
    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列已满，无法入队");
            return;
        }
        rear++;
        array[rear] = num;
    }
    // 出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无法出队");
        }
        front++;
        return array[front];
    }
    // 显示队头数据
    public void showHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        System.out.println(array[front + 1]);;
    }
    // 显示队尾数据
    public void showTailQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        System.out.println(array[rear]);
    }
    // 显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
