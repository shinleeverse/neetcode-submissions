# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        queue = deque()

        if root:
            queue.append(root)

        while len(queue) > 0:
            arr = []
            for i in range(len(queue)):
                cur = queue.popleft()
                arr.append(cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            res.append(arr)
        
        return res

# res = [[1], [2,3], [4,5,6,7]]
# queue = []
# arr = [4,5,6,7]