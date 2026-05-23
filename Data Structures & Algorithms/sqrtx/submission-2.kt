class Solution {
    fun mySqrt(x: Int): Int {
        var left = 0
        var right = x
        while(left <= right){
            val mid = left + (right - left) / 2
            val sqrt = mid.toLong() * mid

            if(x > sqrt){
                left = mid + 1
            } else if (x < sqrt){
                right = mid - 1
            } else {
                return mid
            }
        }

        return right
    }
}
