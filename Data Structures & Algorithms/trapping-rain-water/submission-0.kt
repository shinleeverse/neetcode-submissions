class Solution {
    fun trap(height: IntArray): Int {
        var n = height.size
        if(n == 0){
            return 0
        }
        var leftMax = IntArray(n){0}
        var rightMax = IntArray(n){0}
        
        leftMax[0] = height[0]
        for(i in 1 until n){
            leftMax[i] = maxOf(leftMax[i - 1], height[i])
        }

        rightMax[n - 1] = height[n - 1]
        for(i in  n - 2 downTo 0){
            rightMax[i] = maxOf(rightMax[i + 1], height[i])
        }

        var area = 0
        for(i in 0 until n){
            area += minOf(leftMax[i], rightMax[i]) - height[i]
        }

        return area
    }
}
