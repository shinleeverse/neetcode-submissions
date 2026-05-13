class Solution {
    fun majorityElement(nums: IntArray): Int {
        var majority = -1
        var maxNumber = Int.MIN_VALUE
        val freqs = HashMap<Int, Int>()
        nums.forEach{ num ->
            freqs[num] = freqs.getOrDefault(num, 0) + 1
        }
        for((num, freq) in freqs){
            if(maxNumber < freq && freq >= nums.size / 2){
                majority = num
            }
            maxNumber = maxOf(freq, maxNumber)
        }
        return majority
    }
}
