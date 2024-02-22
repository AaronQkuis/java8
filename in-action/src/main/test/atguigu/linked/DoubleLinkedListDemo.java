package atguigu.linked;

/**
 * @author qikun
 * @date 2/21/2024  3:55 PM
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleHeroNode doubleHeroNode1 = new DoubleHeroNode(1, "电池1", "电池12");
        DoubleHeroNode doubleHeroNode2 = new DoubleHeroNode(2, "电池2", "电池22");
        DoubleHeroNode doubleHeroNode3 = new DoubleHeroNode(3, "电池3", "电池33");
        DoubleHeroNode doubleHeroNode4 = new DoubleHeroNode(4, "电池4", "电池33");
        DoubleHeroNode doubleHeroNode5 = new DoubleHeroNode(5, "电池5", "电池44");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        /*doubleLinkedList.add(doubleHeroNode1);
        doubleLinkedList.add(doubleHeroNode2);
        doubleLinkedList.add(doubleHeroNode3);
        doubleLinkedList.add(doubleHeroNode4);
        doubleLinkedList.add(doubleHeroNode5);*/
        doubleLinkedList.addByOrder(doubleHeroNode5);
        doubleLinkedList.addByOrder(doubleHeroNode3);
        doubleLinkedList.addByOrder(doubleHeroNode2);
        doubleLinkedList.addByOrder(doubleHeroNode4);
        doubleLinkedList.addByOrder(doubleHeroNode1);
        doubleLinkedList.list();
        DoubleHeroNode doubleHeroNode6 = new DoubleHeroNode(5, "传感器5", "电池44");
        doubleLinkedList.update(doubleHeroNode6);
        doubleLinkedList.list();
        doubleLinkedList.del(3);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");
    public DoubleLinkedList (DoubleHeroNode head) {
        this.head = head;
    }
    public DoubleLinkedList () {
    }

    /**
     * 遍历
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    /**
     * 有序添加
     */
    public void addByOrder(DoubleHeroNode doubleHeroNode) {
        DoubleHeroNode temp = head;
        boolean flag = true;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > doubleHeroNode.id) {
                break;
            }
            if (temp.next.id == doubleHeroNode.id) {
                flag = false;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            doubleHeroNode.pre = temp;
            if (temp.next != null) {
                doubleHeroNode.next = temp.next;
                temp.next.pre = doubleHeroNode;
            }
            temp.next = doubleHeroNode;
        }
    }

    /**
     * 添加到尾部
     */
    public void add(DoubleHeroNode doubleHeroNode) {
        DoubleHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        doubleHeroNode.pre = temp;
        temp.next = doubleHeroNode;
    }
    /**
     * 修改
     */
    public void update(DoubleHeroNode doubleHeroNode) {
        if (head.next == null) {
            return;
        }
        DoubleHeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == doubleHeroNode.id) {
                temp.name = doubleHeroNode.name;
                temp.nickName = doubleHeroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除
     */
    public void del(int id) {
        if (head.next == null) {
            return;
        }
        DoubleHeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == id) {
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                break;
            }
            temp = temp.next;
        }
    }
}

class DoubleHeroNode {
    public String name;
    public String nickName;
    public int id;
    public DoubleHeroNode pre;
    public DoubleHeroNode next;


    public DoubleHeroNode(int id, String name, String nickName) {
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
