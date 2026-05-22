class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1
        while(left < right){
            val total = numbers[left] + numbers[right]
            if(total < target){
                left++
            } else if (total > target){
                right--
            } else {
                return intArrayOf(left + 1, right + 1)
            }
        }
        return intArrayOf()
    }
}
