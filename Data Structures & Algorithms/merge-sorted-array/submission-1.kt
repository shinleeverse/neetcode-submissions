
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var mIdx = m - 1
        var nIdx = n - 1
        var last = m + n - 1

        while(nIdx >= 0){
            if(mIdx >= 0 && nums1[mIdx] > nums2[nIdx]){
                nums1[last--] = nums1[mIdx--]
            } else {
                nums1[last--] = nums2[nIdx--]
            }
        }        
    }
}
