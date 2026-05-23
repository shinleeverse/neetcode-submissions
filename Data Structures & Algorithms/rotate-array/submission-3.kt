class Solution {

    fun rotate(nums: IntArray, k: Int) {
        if(nums.isEmpty()){
            return
        }
        val n = nums.size
        val kMod = k % n

        reverse(nums, 0, n - 1)
        reverse(nums, 0, kMod - 1)
        reverse(nums, kMod, n - 1)
    }

    private fun reverse(arr: IntArray, start: Int, end: Int){
        var l = start
        var r = end
        while (l < r){
            val temp = arr[l]
            arr[l] = arr[r]
            arr[r] = temp
            l++
            r--
        }
    }
}
