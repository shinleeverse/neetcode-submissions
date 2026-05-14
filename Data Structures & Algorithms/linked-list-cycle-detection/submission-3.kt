/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val seen = HashSet<ListNode>()
        var cur = head
        while (cur != null){
            if(seen.contains(cur)){
                return true
            }
            seen.add(cur)
            cur = cur.next
        }
        return false
    }
}
