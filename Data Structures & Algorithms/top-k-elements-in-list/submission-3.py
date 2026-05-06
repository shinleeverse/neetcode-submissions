from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = defaultdict(int)

        for num in nums:
            counts[num] += 1
        
        freqs = []
        for key, cnt in counts.items():
            freqs.append((cnt, key))
        
        freqs.sort()

        res = []
        for i in range(k):
            res.append(freqs.pop()[1])
        
        return res