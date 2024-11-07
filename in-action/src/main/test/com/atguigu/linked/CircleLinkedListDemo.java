package com.atguigu.linked;

/**
 * @author qikun
 * @date 2/22/2024  1:34 PM
 */
public class CircleLinkedListDemo {
    public static void main(String[] args) {
        int n = 5,k = 1, m = 2;
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.add(n);
        circleLinkedList.list();
        circleLinkedList.josephu(n, k, m);
    }
}

class CircleLinkedList {
    private CircleNode first = null;

    /**
     * 添加一定数量的节点
     * @param nums
     */
    public void add(int nums) {
        if (nums < 1) {
            return;
        }
        CircleNode temp = null;
        for (int i = 1; i <= nums; i++) {
            CircleNode circleNode = new CircleNode(i);
            if (i == 1) {
                first = circleNode;
                first.setNext(first);
                temp = first;
            } else {
                circleNode.setNext(first);
                temp.setNext(circleNode);
                temp = circleNode;
            }
        }
    }

    /**
     * 遍历节点
     */
    public void list() {
        if (first == null) {
            return;
        }
        CircleNode temp = first;
        while (true) {
            System.out.println(temp);
            if (temp.next.equals(first)) {
                break;
            }
            temp = temp.next;
        }
    }

    public void josephu(int nums, int startId, int jumpCount) {
        if (first == null || startId < 1 || startId > nums) {
            System.out.println("数据有误");
            return;
        }
        CircleNode helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 移动 startId - 1次
        for (int i = 0; i < startId -1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while(true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < jumpCount - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println(first);
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(first.getId());
    }
}

class CircleNode {
    public int id;
    public CircleNode next;

    public CircleNode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CircleNode getNext() {
        return next;
    }

    public void setNext(CircleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "id=" + id +
                '}';
    }
}
