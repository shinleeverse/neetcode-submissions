# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# get maxvalue of left subtree
# get minvalue of right subtree
# if root node is greater than maxvalue and smaller than minValue, BST is valid
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def valid(node, left, right):
            if not node:
                return True
            
            if not (node.val > left and node.val < right):
                return False

            return valid(node.left, left, node.val) and valid(node.right, node.val, right)
        
        return valid(root, float("-inf"), float("inf"))
