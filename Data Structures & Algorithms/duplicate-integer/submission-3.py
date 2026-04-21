# empty array -> False
# only one array -> False
# Has to be more than 2
# negative number? -> yes
# range? -> -inf to inf?

# two for-loop -> O(n^2) time & O(1) space
# Hashset -> O(n) time & O(n) space 

class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        if len(nums) < 2:
            return False

        appeared = set()

        for n in nums:
            if n in appeared:
                return True
            appeared.add(n)
        
        return False

# set = []
# n = 
