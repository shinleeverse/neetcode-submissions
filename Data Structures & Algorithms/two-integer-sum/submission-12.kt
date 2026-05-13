class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>() // nums to index

        nums.forEachIndexed { index, element ->
            val diff = target - element
            if(map.contains(diff)){
                return intArrayOf(map[diff]!!, index)
            }
            map.put(element, index)
        }

        return intArrayOf()
    }
}
