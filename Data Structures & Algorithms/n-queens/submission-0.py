class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols = set()
        posDiag = set() #(r + c)
        negDiag = set() #(r - c)

        res = []
        board = [["."] * n for i in range(n)]
        
        def _backtrack(row):
            if row == n:
                copy = ["".join(row) for row in board]
                res.append(copy)
                return
            
            for col in range(n):
                if col in cols or (row + col) in posDiag or (row - col) in negDiag:
                    continue
                
                cols.add(col)
                posDiag.add(row + col)
                negDiag.add(row - col)
                board[row][col] = "Q"

                _backtrack(row + 1)

                cols.remove(col)
                posDiag.remove(row + col)
                negDiag.remove(row - col)
                board[row][col] = "."
        
        _backtrack(0)
        return res

