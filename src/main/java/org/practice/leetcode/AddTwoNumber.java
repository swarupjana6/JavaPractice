package org.practice.leetcode;

import org.practice.leetcode.model.ListNode;

import java.util.List;

//2. Add Two Numbers
public class AddTwoNumber {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p=l1, q=l2, curr;
        ListNode dummyHead = new ListNode(0);
        curr = dummyHead;
        int carry = 0;

        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (carry > 0 ){
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;

    };
    public static void main(String[] args) {

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);

        do{
            System.out.println(result.val + ",");
            result = result.next;
        } while (result != null);
    }
}
