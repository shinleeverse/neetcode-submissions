class Solution {
    private lateinit var grid : Array<IntArray>
    private lateinit var queue : ArrayDeque<Pair<Int,Int>>

    private val directions = arrayOf(
        intArrayOf(0,-1), // left
        intArrayOf(0,1),  // right
        intArrayOf(-1,0), // up
        intArrayOf(1,0),  // down
    )
    private var rows : Int = 0
    private var cols : Int = 0

    fun islandsAndTreasure(grid: Array<IntArray>) {
        this.grid = grid
        rows = grid.size
        cols = grid[0].size
        queue = ArrayDeque()

        for(r in 0 until rows){
            for(c in 0 until cols){
                if(grid[r][c] == 0){
                    queue.addLast(r to c)
                }
            }
        }
    
        bfs()
    }

    private fun bfs(){
        while(queue.isNotEmpty()){
            for(i in 0 until queue.size){
                val (row,col) = queue.removeFirst()
                for(dir in directions){
                    val nRow = row + dir[0]
                    val nCol = col + dir[1]
                    if(nRow !in 0 until rows || nCol !in 0 until cols || grid[nRow][nCol] != Int.MAX_VALUE){
                        continue
                    }
                    // if(nRow < 0 || nRow >= rows || nCol < 0 || nCol >= cols || grid[nRow][nCol] == 0 || grid[nRow][nCol] == -1){
                    //     continue
                    // }
                    queue.addLast(nRow to nCol)
                    grid[nRow][nCol] = grid[row][col] + 1
                }
            }
        }
    }
}
