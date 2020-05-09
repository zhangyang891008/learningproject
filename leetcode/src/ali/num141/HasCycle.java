package ali.num141;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
141. 环形链表

给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：false
解释：链表中没有环。


进阶：

你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class HasCycle {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    /*
    解法1：hash法，把遍历过的节点都存起来，逐个比对
     */

    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode cur = head;
        while(cur!=null){
            if(visited.contains(cur)){
                return true;
            }else{
                visited.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }

    /*
    双指针法：用快慢两个指针遍历，指针相遇，则存在环，走到末尾也没有相遇表示无环
     */
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next ==null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;

    }

}
