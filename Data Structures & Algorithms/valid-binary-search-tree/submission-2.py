# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#      3
#    /   \
#   2     5
#  /     / \
# 1     4   7


# -inf < 3 < inf -> True
# -inf < 2 < 3 -> True
# -inf < 1 < 2 -> True
# 3 < 5 < inf -> True
# 5 < 4 < inf -> False
# 5 < 7 < inf -> True

# Overall -> False

from collections import deque

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        queue = deque()

        if root:
            queue.append((root, float("-inf"), float("inf")))
        
        while queue:
            node, left, right = queue.popleft()

            if not(left < node.val < right):
                return False
            
            if node.left:
                queue.append((node.left, left, node.val))
            if node.right:
                queue.append((node.right, node.val, right))
        
        return True
