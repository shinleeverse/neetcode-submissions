# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Hint: Use the property of the Binary Search Tree!!!
# left subtree has smaller values than the root/parent node
# right subtree has greater values than the root/parent node

# Compare the current node with p and q
# find the current node if:
#   1. cur.val == p.val or cur.val == q.val
#   2. cur.val < p.val and cur.val > q.val
#   3. cur.val > p.val and cur.val < q.val

# If the current node satisfies the above condition, that node is the lowest common ancester.
# 1. find the node where the split occurs
# If p and q has greater values than the node, the common ancestor is in the right subtree
# if p and q has smaller values than the node, the common ancestor is in the left subtree
# 2. One edge case is where one of p or q is equal to the node, then the node itself is common ancestor of p and q.
class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        cur = root
        while cur:
            if p.val > cur.val and q.val > cur.val:
                cur = cur.right
            elif p.val < cur.val and q.val < cur.val:
                cur = cur.left
            else :
                return cur