from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = defaultdict(int)
        for n in nums:
            counts[n] += 1

        heap = []
        for key, cnts in counts.items():
            heapq.heappush(heap, (cnts, key))
            if len(heap) > k:
                heapq.heappop(heap)
        
        res = []
        while len(res) < k:
            res.append(heapq.heappop(heap)[1])
        return res