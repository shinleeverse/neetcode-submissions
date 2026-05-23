class Solution {
    fun mySqrt(x: Int): Int {
        var left = 0
        var right = x
        var res = 0
        while(left <= right){
            val mid = left + (right - left) / 2
            val value = mid.toLong() * mid

            if(x > value){
                left = mid + 1
                res = mid
            } else if (x < value){
                right = mid - 1
            } else {
                return mid
            }
        }

        return res
    }
}
