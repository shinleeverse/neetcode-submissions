class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val cols = matrix[0].size

        var top = 0
        var bottom = rows - 1
        while(top <= bottom){
            val mid = top + (bottom - top) / 2
            when {
                target > matrix[mid][0] -> top = mid + 1
                target < matrix[mid][0] -> bottom = mid - 1
                else -> return true
            }
        }
        
        var row = bottom
        if (row < 0) return false
        
        var left = 0
        var right = cols - 1
        while(left <= right){
            val mid = left + (right - left) / 2
            when{
                target > matrix[row][mid] -> left = mid + 1
                target < matrix[row][mid] -> right = mid - 1
                else -> return true
            }
        }
        return false
    }
}
