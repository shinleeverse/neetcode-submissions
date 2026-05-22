/**
nums1 = [10,20,20,40,0,0]
                   ^
m = 4 
nums2 = [1,2]
n = 2




**/

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var index = m
        for(num in nums2){
            nums1[index++] = num
        }
        return nums1.sort()
    }
}
