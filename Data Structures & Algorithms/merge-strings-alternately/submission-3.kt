class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val sb = StringBuilder()
        
        for(i in 0 until maxOf(word1.length, word2.length)){
            if(i < word1.length) {
                sb.append(word1[i])
            }
            if(i < word2.length) {
                sb.append(word2[i])
            }
        }
        return sb.toString()
    }
}
