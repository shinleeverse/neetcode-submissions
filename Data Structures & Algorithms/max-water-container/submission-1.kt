class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var area = 0
        while(left < right){
            val height = minOf(heights[left], heights[right])
            val width = right - left
            area = maxOf(area, height * width)
         
            if(heights[left] <= heights[right]){
                left++
            } else {
                right--
            }
        }

        return area
    }
}
