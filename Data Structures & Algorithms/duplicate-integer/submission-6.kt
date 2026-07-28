class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for(n in nums){
            if(set.contains(n)){
                return true
            }
            set.add(n)
        }
        return false
    }
}
