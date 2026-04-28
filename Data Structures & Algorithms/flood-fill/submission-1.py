class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        originalValue = image[sr][sc]
        ROWS, COLS = len(image), len(image[0])

        def _dfs(r, c, visited):
            nonlocal originalValue
            if min(r,c) < 0 or r == ROWS or c == COLS or (r,c) in visited or image[r][c] != originalValue:
                return
            
            image[r][c] = color
            visited.add((r,c))

            _dfs(r+1,c,visited)
            _dfs(r-1,c,visited)
            _dfs(r,c+1,visited)
            _dfs(r,c-1,visited)
        
        _dfs(sr,sc,set())
        return image


