# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        stack = []
        visits = []

        if root:
            stack.append(root)
            visits.append(False)
        
        while stack:
            cur, visited = stack.pop(), visits.pop()
            if not cur:
                continue
            if visited:
                res.append(cur.val)
            else :
                stack.append(cur)
                visits.append(True)
                stack.append(cur.right)
                visits.append(False)
                stack.append(cur.left)
                visits.append(False)
                
        return res