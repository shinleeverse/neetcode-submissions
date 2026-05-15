class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val directions = arrayOf(
            intArrayOf(0,-1),
            intArrayOf(0,1),
            intArrayOf(-1,0),
            intArrayOf(1,0),
        )
        val rows : Int = grid.size
        val cols : Int = grid[0].size

        var fresh : Int = 0
        var time : Int = 0

        for(r in 0 until rows){
            for(c in 0 until cols){
                if(grid[r][c] == 2){
                    queue.addLast(r to c)
                }
                if(grid[r][c] == 1){
                    fresh++
                }
            }
        }

        while(queue.isNotEmpty() && fresh > 0){
            for(i in 0 until queue.size){
                val (row, col) = queue.removeFirst()
                for(dir in directions){
                    val nr = row + dir[0]
                    val nc = col + dir[1]
                    if(nr !in 0 until rows || nc !in 0 until cols || grid[nr][nc] != 1){
                        continue
                    }
                    queue.addLast(nr to nc)
                    grid[nr][nc] = 2
                    fresh--
                }
            }
            time++
        }

        return if(fresh == 0) time else -1

    }
}
