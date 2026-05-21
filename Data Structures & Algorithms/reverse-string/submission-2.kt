class Solution {
    fun reverseString(s: CharArray) {
        val stack = ArrayDeque<Char>()
        for(c in s){
            stack.addLast(c)
        }
        for(i in 0 until s.size){
            s[i] = stack.removeLast()
        }
    }
}
