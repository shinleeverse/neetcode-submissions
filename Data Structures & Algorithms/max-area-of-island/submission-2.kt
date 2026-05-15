class Solution {
    private lateinit var grid : Array<IntArray>
    private val directions = arrayOf(
        intArrayOf(0,-1), //left
        intArrayOf(0,1),  //right
        intArrayOf(-1,0), //top
        intArrayOf(1,0), //bottom
    )
    private var rows: Int = 0
    private var cols: Int = 0

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        this.grid = grid
        rows = grid.size
        cols = grid[0].size

        var maxArea = 0

        for(r in 0 until rows){
            for(c in 0 until cols){
                if(grid[r][c] == 1){
                    //val area = dfs(r,c)
                    val area = bfs(r,c)
                    maxArea = maxOf(maxArea, area)
                }
            }
        }

        return maxArea
    }

    private fun dfs(row: Int, col: Int): Int {
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0){
            return 0
        }

        grid[row][col] = 0

        var area : Int = 1
        for(dir in directions){
            val newRow = row + dir[0]
            val newCol = col + dir[1]
            area += dfs(newRow, newCol)
        }

        return area
    }

    private fun bfs(row: Int, col: Int): Int {
        val queue = ArrayDeque<IntArray>()
        grid[row][col] = 0
        queue.addLast(intArrayOf(row, col))

        var area : Int = 0
        while(queue.isNotEmpty()){
            for(i in 0 until queue.size){
                val (r, c) = queue.removeFirst()
                area++
                for(dir in directions){
                    val newRow = r + dir[0]
                    val newCol = c + dir[1]
                    if(newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols || grid[newRow][newCol] == 0){
                        continue
                    }
                    queue.addLast(intArrayOf(newRow, newCol))
                    grid[newRow][newCol] = 0
                }
            }
        }
        return area
    }


}
