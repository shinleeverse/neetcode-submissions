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

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def valid(node, left, right):
            if not node:
                return True
            if not (left < node.val < right):
                return False
            return valid(node.left, left, node.val) and valid(node.right, node.val, right)
        
        return valid(root, float("-inf"), float("inf"))
