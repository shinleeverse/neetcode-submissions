class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        for(i in strs[0].indices){
            for(s in strs){
                if(i == s.length || s[i] != strs[0][i]){
                    return s.substring(0, i)
                }
            }
        }
        return strs[0]
    }
}


/**
v
flower
flow
flight

*/