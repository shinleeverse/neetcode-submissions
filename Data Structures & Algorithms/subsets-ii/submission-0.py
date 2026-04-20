class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        subset = []

        def helper(index):
            if index >= len(nums):
                res.append(subset.copy())
                return
            
            subset.append(nums[index])
            helper(index + 1)

            subset.pop()
            while index + 1 < len(nums) and nums[index] == nums[index + 1]:
                index += 1
            helper(index + 1)

        helper(0)
        return res