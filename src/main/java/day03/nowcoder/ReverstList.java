package day03.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZerlindaLi create at 2019/9/4 10:41
 * @version 1.0.0
 * @description ReverstList 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class ReverstList {

    ArrayList<Integer> arrayList = new ArrayList<>();

    /**
     * 递归算法
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(7);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        List list = new ReverstList().printListFromTailToHead(listNode1);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}




