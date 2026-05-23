class Solution {
    fun rotate(nums: IntArray, k: Int) {
        val n = nums.size
        val res = IntArray(n)
        for (i in 0 until n){
            val index = (i + k) % n
            res[index] = nums[i]
        }
        for (i in 0 until res.size){
            nums[i] = res[i]
        }
    }
}
