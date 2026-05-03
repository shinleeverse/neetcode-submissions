"""
Approach #1 Brute Force - Sorting
1. Sort two strings
2. 


Approach #2 HashMap
1. iterate through s 
2. create a map and increment the value for duplicate char {char: int}
3. iterate through t
4. check the char if in the map -> if not, return false.
5. decrement the value for the char -> if value < 0, return false
6. lastly, iterate values in map -> if all the values == 0, return True, if not, return false
O(n) time (two passes) & O(n) space for the extra data structure = map

Aproach #3 Bucket
1. initialize an array with size of 26 (lowercase alphabet).
2. iterate through s
3. bucket[ord(c) - ord('a')] += 1
4. iterate through t
5. bucket[ord(c) - ord('a')] -= 1
6. iterate bucket to see if all 26 values are equal to 0
"""
from collections import defaultdict

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        counts = [0] * 26

        for i in range(len(s)):
            counts[ord(s[i]) - ord('a')] += 1
            counts[ord(t[i]) - ord('a')] -= 1
        
        for val in counts:
            if val != 0:
                return False
        return True