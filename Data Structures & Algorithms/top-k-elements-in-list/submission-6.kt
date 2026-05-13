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

        val res = IntArray(k)
        for (i in k - 1 downTo 0){
            res[i] = minHeap.poll().second
        }
        
        return res
    }
}
