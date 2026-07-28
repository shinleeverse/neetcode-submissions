class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length){
            return false
        }

        val counts = IntArray(26) { 0 }
        for(i in 0 until s.length){
            counts[s[i] - 'a']++
            counts[t[i] - 'a']--
        }

        for(value in counts){
            if(value != 0){
                return false
            }
        }

        return true
    }
}
