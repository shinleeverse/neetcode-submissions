from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = defaultdict(int)

        for n in nums:
            counts[n] += 1
        
        arr = []
        for key, cnt in counts.items():
            arr.append((cnt, key))
        
        arr.sort()

        res = []
        while len(res) < k:
            res.append(arr.pop()[1])
        
        return res
