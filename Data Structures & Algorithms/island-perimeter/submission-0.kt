/*

1. DFS
2. grid[i][j] == 1 -> land
3. grid[i][j] == 0 -> water
4. horizontal or vertically -> require directions
5. out of bound == water
6. only one island
7. side length == 1

perimeter 
r < 0 -> +1
c < 0 -> +1
grid[i][j] == 0 -> +1
visited -> 0

visited.add(r,c)

dfs(r + 1, c) -> 
dfs(r - 1, c) -> 1
dfs(r, c + 1) -> 3
dfs(r, c - 1) -> 1

*/

class Solution {
    private lateinit var grid: Array<IntArray>
    private lateinit var visited: HashSet<Pair<Int, Int>>
    private val directions = arrayOf(
        intArrayOf(0, -1),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(1, 0)
    )
    private var rows = 0
    private var cols = 0

    fun islandPerimeter(grid: Array<IntArray>): Int {
        this.grid = grid
        rows = grid.size
        cols = grid[0].size
        visited = HashSet()
        
        var perimeter = 0

        for(r in 0 until rows){
            for (c in 0 until cols){
                if(grid[r][c] == 1){
                    return dfs(r,c)
                }
            }
        }

        return 0
    }

    private fun dfs(row: Int, col: Int): Int{
        if (visited.contains(row to col)){
            return 0
        } 
        if (row !in 0 until rows || col !in 0 until cols || grid[row][col] == 0){
            return 1
        }

        visited.add(row to col)
        var perimeter = 0

        for(dir in directions){
            val nr = row + dir[0]
            val nc = col + dir[1]
            perimeter += dfs(nr,nc)
        }

        return perimeter
    }
}
