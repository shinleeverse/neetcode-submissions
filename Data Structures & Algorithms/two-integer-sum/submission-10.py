from collections import defaultdict

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sorted_nums = []
        for i in range(len(nums)):
            sorted_nums.append((nums[i], i))
        
        sorted_nums.sort()

        left, right = 0, len(nums) - 1
        while left < right:
            twoSum = sorted_nums[left][0] + sorted_nums[right][0]
            if twoSum == target:
                return [min(sorted_nums[left][1], sorted_nums[right][1]), max(sorted_nums[left][1], sorted_nums[right][1])]
            elif twoSum < target:
                left += 1
            else :
                right -= 1
        return []