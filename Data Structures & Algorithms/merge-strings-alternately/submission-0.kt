/**
    ab vs. abbxxc
    ^      ^

    a,a,b,b,x,x,c

    two pointers - each pointer starts at word1 and word2

    O(n) time, n is longest string out of two, word1 and word2


**/

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var pointer = 0

        val sb = StringBuilder()

        while(pointer < minOf(word1.length, word2.length)){
            sb.append(word1[pointer])
            sb.append(word2[pointer])
            pointer++
        }

        if(pointer < word1.length){
            sb.append(word1.substring(pointer, word1.length))
        } else if(pointer < word2.length){
            sb.append(word2.substring(pointer, word2.length))
        }

        return sb.toString()
    }
}
