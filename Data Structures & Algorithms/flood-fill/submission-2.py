class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color:
            return image

        ROWS, COLS = len(image), len(image[0])
        dirs = [1,0,-1,0,1]

        def _dfs(r, c, orgValue):
            if min(r,c) < 0 or r == ROWS or c == COLS or image[r][c] != orgValue:
                return
            
            image[r][c] = color

            for i in range(4):
                _dfs(r + dirs[i], c + dirs[i+1], orgValue)
        
        _dfs(sr,sc,image[sr][sc])
        return image


