package mid;

public class No24 {
    //连get set方法都没有，怎么取值。。去对象的属性可以直接用实例+.的方式啊，不一定要用get方法。提前是修饰符是可以访问的。
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    /**
     * 递归，时间复杂度低，但是会消耗空间复杂度。
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {


        //递归的结束条件
        if (head==null||head.next==null){
            return head;
        }

        //申请新的节点
        ListNode listNode = head.next;
        head.next = swapPairs(listNode.next);
        //就算这里原本next里面有值，也会被覆盖掉。
        listNode.next = head;
        return listNode;
    }
}
