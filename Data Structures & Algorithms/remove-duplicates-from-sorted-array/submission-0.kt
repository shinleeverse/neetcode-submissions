class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var k = 0
        var prev : Int = Int.MIN_VALUE

        for(num in nums){
            if(num != prev){
                nums[k++] = num
                prev = num
            }
        }

        return k
    }
}
