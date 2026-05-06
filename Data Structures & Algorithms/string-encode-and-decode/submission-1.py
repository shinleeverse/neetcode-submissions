class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""

        for s in strs:
            res += str(len(s))
            res += ","
        
        res += "#"

        for s in strs:
            res += s
    
        return res

    def decode(self, s: str) -> List[str]:
        sizes, res, start = [], [], 0

        while s[start] != "#":
            end = start
            while s[end] != ",":
                end += 1
            sizes.append(int(s[start:end]))
            start = end + 1
        
        start += 1

        for sz in sizes:
            end = start + sz
            res.append(s[start:end])
            start = end
        
        return res