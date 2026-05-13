class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        
        val counts = HashMap<Int, Int>() // element, count

        for (num in nums){
            counts[num] = counts.getOrDefault(num, 0) + 1
        }

        val minHeap = PriorityQueue<Pair<Int,Int>>(compareBy {it.first})
        for ((num, counts) in counts){
            minHeap.offer(Pair(counts, num))
            if (minHeap.size > k){
                minHeap.poll()
            }
        }

        val res = mutableListOf<Int>()
        while(minHeap.isNotEmpty()){
            res.add(minHeap.poll().second)
        }
        
        return res.toIntArray()
    }
}
