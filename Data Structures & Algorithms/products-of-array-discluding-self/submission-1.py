class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix = [0] * n
        postfix = [0] * n
        res = [0] * n

        product = 1
        for i in range(n):
            product *= nums[i]
            prefix[i] = product
        
        product = 1
        for j in range(n - 1, -1 , -1):
            product *= nums[j]
            postfix[j] = product
        
        for i in range(n):
            pre = prefix[i - 1] if i != 0 else 1
            post = postfix[i + 1] if i != n - 1 else 1
            res[i] = pre * post

        return res