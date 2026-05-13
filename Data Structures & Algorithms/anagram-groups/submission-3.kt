class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val res = HashMap<List<Int>, MutableList<String>>()

        for(word in strs){
            val count = MutableList(26){0}
            for (char in word){
                count[char - 'a']++
            }
            res.getOrPut(count){mutableListOf()}.add(word)
        }

        return res.values.toList()
    }
}
