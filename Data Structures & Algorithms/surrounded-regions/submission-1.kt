/**
1. Search the edges for the 'O's and dfs/bfs : 'O' -> 'T'
2. Traverse the board : 'O' -> 'X'
3. Traverse the board : 'T' -> 'O'
*/

class Solution {
    private lateinit var board: Array<CharArray>
    private val directions = arrayOf(
        intArrayOf(-1, 0), // Up
        intArrayOf(1, 0),  // Down
        intArrayOf(0, -1), // Left
        intArrayOf(0, 1),  // Right 
    )
    private var rows : Int = 0
    private var cols : Int = 0

    fun solve(board: Array<CharArray>) {
        this.board = board
        rows = board.size
        cols = board[0].size

        // 'O' -> 'T'
        for(r in 0 until rows){
            if(board[r][0] == 'O'){
                bfs(r, 0)
            }
            if (board[r][cols - 1] == 'O'){
                bfs(r, cols - 1)
            }
        }

        for(c in 0 until cols){
            if(board[0][c] == 'O'){
                bfs(0, c)
            }
            if(board[rows - 1][c] == 'O'){
                bfs(rows - 1, c)
            }
        }

        // 'O' -> 'X' & 'T' -> 'O'
        for(r in 0 until rows){
            for(c in 0 until cols){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X'
                } else if (board[r][c] == 'T'){
                    board[r][c] = 'O'
                }
            }
        }
    }

    private fun dfs(row: Int, col: Int){
        if(row !in 0 until rows || col !in 0 until cols || board[row][col] != 'O'){
            return
        }

        board[row][col] = 'T'

        for(dir in directions){
            val nr = row + dir[0]
            val nc = col + dir[1]
            dfs(nr, nc)
        }
    }

    private fun bfs(row: Int, col: Int){
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(row to col)
        board[row][col] = 'T'

        while(queue.isNotEmpty()){
            repeat(queue.size){
                val (r, c) = queue.removeFirst()
                for(dir in directions){
                    val nr = r + dir[0]
                    val nc = c + dir[1]

                    if(nr !in 0 until rows || nc !in 0 until cols || board[nr][nc] != 'O'){
                        continue
                    }
                    queue.addLast(nr to nc)
                    board[nr][nc] = 'T'
                }
            }
        }
    }
}
