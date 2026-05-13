class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val visited = hashSetOf<Int>()
        for (i in 0 until nums.size){
            if(visited.contains(nums[i])){
                return true
            }
            visited.add(nums[i])
        }
        return false
    }
}
