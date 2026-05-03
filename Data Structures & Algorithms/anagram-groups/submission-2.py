from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)
        for word in strs:
            sorted_str = "".join(sorted(word))
            res[sorted_str].append(word)
        return list(res.values())