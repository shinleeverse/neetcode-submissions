class Solution {
    private lateinit var heights : Array<IntArray>
    private lateinit var pac : HashSet<Pair<Int,Int>>
    private lateinit var atl : HashSet<Pair<Int,Int>>
    private val directions = arrayOf(
        intArrayOf(0, -1),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
    )
    private var rows : Int = 0
    private var cols : Int = 0

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        this.heights = heights
        pac = HashSet()
        atl = HashSet()
        rows = heights.size
        cols = heights[0].size

        for(r in 0 until rows){
            // Pacific rows
            dfs(r, 0, pac, heights[r][0])
            // Atlantic rows
            dfs(r, cols - 1, atl, heights[r][cols - 1])
        }

        for(c in 0 until cols){
            // Pacific cols
            dfs(0, c, pac, heights[0][c])
            // Atlantic cols
            dfs(rows - 1, c, atl, heights[rows - 1][c])
        }

        val output = mutableListOf<List<Int>>()

        for(r in 0 until rows){
            for(c in 0 until cols){
                val coord = Pair(r,c)
                if(coord in pac && coord in atl){
                    output.add(listOf(coord.first, coord.second))
                }
            }
        }

        return output

    }

    private fun dfs(row: Int, col: Int, visited : HashSet<Pair<Int, Int>>, prevHeight : Int) {
        if(isOutOfBound(row, col) || Pair(row, col) in visited || heights[row][col] < prevHeight){
            return
        }

        visited.add(row to col)

        for(dir in directions){
            val nr = row + dir[0]
            val nc = col + dir[1]
            dfs(nr, nc, visited, heights[row][col])
        }
    }

    private fun isOutOfBound(row: Int,  col: Int): Boolean {
        return (row !in 0 until rows || col !in 0 until cols)
    }
}
