class Solution {
    private lateinit var grid : Array<CharArray>
    private val directions = arrayOf(
        intArrayOf(1,0), // Down
        intArrayOf(-1,0), // Up
        intArrayOf(0,1), // Right
        intArrayOf(0,-1) // Left
    )
    private var rows : Int = 0
    private var cols : Int = 0

    fun numIslands(grid: Array<CharArray>): Int {
        this.grid = grid
        rows = grid.size
        cols = grid[0].size

        var islands = 0
        for(r in 0 until rows){
            for(c in 0 until cols){
                if(grid[r][c] == '1'){
                    dfs(r,c)
                    islands++
                }
            }
        }

        return islands
    }

    private fun dfs(r: Int, c: Int){
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0'){
            return
        }

        grid[r][c] = '0'

        for (dir in directions){
            val row = r + dir[0]
            val col = c + dir[1]
            dfs(row, col)
        }
    }
}
