class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length){
            return false
        }

        val countS = hashMapOf<Char, Int>()
        val countT = hashMapOf<Char, Int>()

        s.forEach { char ->
            countS[char] = countS.getOrDefault(char, 0) + 1
        }   

        t.forEach { char ->
            countT[char] = countT.getOrDefault(char, 0) + 1
        }

        return countS == countT
    }
}
