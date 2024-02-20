package atguigu.linked;

import java.util.Stack;

/**
 * @author qikun
 * @date 2/16/2024  8:15 AM
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode5 = new HeroNode(4, "武松", "打虎");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.addTail(heroNode1);
//        singleLinkedList.addTail(heroNode2);
//        singleLinkedList.addTail(heroNode3);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode5);
        singleLinkedList.list();
        System.out.println("有效个数： " + singleLinkedList.getLength());
        HeroNode lastIndex = singleLinkedList.findLastIndex(1);
        System.out.println("倒数第1个： " + lastIndex.toString());
        //修改
        HeroNode heroNode4 = new HeroNode(1, "送姜", "下雨了");
        singleLinkedList.updateById(heroNode4);
        singleLinkedList.list();

        //删除
        singleLinkedList.delete(2);
        singleLinkedList.list();
        System.out.println("有效个数： " + singleLinkedList.getLength());
        System.out.println("翻转列表");
        reverseLinked(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println("反向遍历链表");
        reversePrint(singleLinkedList.getHead());
    }
    /**
     * 反向遍历链表
     *
     */
    public static void reversePrint(HeroNode head) {
        if(head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
    /**
     * 反转链表
     *
     * @param oldHead
     */
    public static void reverseLinked(HeroNode oldHead) {
        if (oldHead.next == null || oldHead.next.next == null) {
            return;
        }
        HeroNode temp = oldHead.next;
        HeroNode oldNext = null;
        HeroNode newHead = new HeroNode(0, "", "");
        while (true) {
            if (temp == null) {
                break;
            }
            oldNext = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = oldNext;
        }
        oldHead.next = newHead.next;
    }
}

/**
 * 链表
 *
 * 1. 头节点
 * 2. 添加节点到尾部
 * 3. 遍历节点
 */
class SingleLinkedList {
    // 头节点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点至末尾
     *
     * @param heroNode
     */
    public void addTail(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 添加节点至指定位置
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == heroNode.id) {
                flag = true;
                break;
            } else if (temp.next.id > heroNode.id) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("无法插入");
        } else {
            // 插入到temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 修改
     *
     * @param heroNode
     */
    public void updateById(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空，无法更新");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.id == heroNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("未找到要更新的节点");
        }
    }

    /**
     * 删除 找到要删除的前一个
     *
     */
    public void delete(int id) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = true;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("无法找到要删除的节点");
        }
    }

    /**
     * 获取链表有效个数
     *
     */
    public int getLength() {
        if (head.next == null) {
            return 0;
        }
        HeroNode temp = head.next;
        int length = 0;
        while (true) {
            length++;
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        return length;
    }

    /**
     * 获取倒数某个元素
     *
     * @param index
     * @return
     */
    public HeroNode findLastIndex(int index) {
        if (head.next == null) {
            return null;
        }
        HeroNode temp = head.next;
        int size = this.getLength();
        if (index <= 0 || index > size) {
            return null;
        }
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    /**
     * 遍历链表
     *
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head;
        while (true) {
            System.out.println(temp.toString());
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }
}

/**
 * 节点
 *
 * 1. data + next
 * 2. 构造器
 * 3. 显示重写 node的 toString()
 */
class HeroNode {
    public int id;
    public String name;
    public String nickName;
    public HeroNode next;

    // 构造器
    public HeroNode (int id, String name, String nickName) {
        super();
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
