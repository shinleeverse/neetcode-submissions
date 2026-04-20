class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets, curSet = [], []
        self.helper(0, nums, subsets, curSet)
        return subsets


    def helper(self, index: int, nums:List[int], subsets:List[List[int]], curSet:List[int]):
        if index >= len(nums):
            subsets.append(curSet.copy())
            return
        
        curSet.append(nums[index])
        self.helper(index + 1, nums, subsets, curSet)

        curSet.pop()
        self.helper(index + 1, nums, subsets, curSet)