class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        part = []

        def _backtrack(index):
            if index >= len(s):
                res.append(part.copy())
                return
            
            for j in range(index, len(s)):
                if self.isPalindrome(s, index, j):
                    part.append(s[index:j+1])
                    _backtrack(j+1)
                    part.pop()
        
        _backtrack(0)
        return res

    def isPalindrome(self, s:str, i:int, j:int) -> bool:
        while i < j:
            if s[i] != s[j]:
                return False
            i, j = i + 1, j - 1
        return True