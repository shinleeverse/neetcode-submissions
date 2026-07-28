class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val expected = mutableMapOf<Int, Int>()
        for(i in 0 until nums.size){
            if(expected.containsKey(nums[i])){
                val index = expected[nums[i]] ?: -1
                return intArrayOf(index, i)
            }
            val diff = target - nums[i]
            expected[diff] = i
        }
        return intArrayOf(-1, -1)
    }
}
