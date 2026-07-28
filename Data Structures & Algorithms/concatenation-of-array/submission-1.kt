class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val length = nums.size
        val result = IntArray(length * 2)
        for((i, n) in nums.withIndex()){
            result[i] = n
            result[i + length] = n
        }
        return result
    }
}
