from collections import deque

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])

        if grid[0][0] or grid[ROWS - 1][COLS - 1]:
            return -1

        queue = deque([(0,0,1)])
        visited = set((0,0))
        dirs = [(-1 , 0), (0, -1), (1, 0), (0, 1), (-1, -1), (1,1), (-1, 1), (1, -1)]

        while queue:
            for i in range(len(queue)):
                r,c, length = queue.popleft()
                if r == ROWS - 1 and c == COLS - 1:
                    return length
                
                for dr, dc in dirs:
                    row, col = r + dr, c + dc
                    if min(row, col) < 0 or row == ROWS or col == COLS or (row, col) in visited or grid[row][col] == 1:
                        continue
                    queue.append((row, col, length + 1))
                    visited.add((row, col))
        
        return -1 
