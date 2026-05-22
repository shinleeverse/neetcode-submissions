class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var pointer = 0
        val sb = StringBuilder()
        for(i in 0 until maxOf(word1.length, word2.length)){
            if(pointer < word1.length){
                sb.append(word1[pointer])
            }
            if(pointer < word2.length){
                sb.append(word2[pointer])
            }
            pointer++
        }
        return sb.toString()
    }
}
