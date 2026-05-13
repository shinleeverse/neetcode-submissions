class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = HashMap<List<Int>, MutableList<String>>()
        
        strs.forEach { word ->
            val counts = MutableList(26){0}
            word.forEach{ char ->
                counts[char - 'a']++
            }
            groups.getOrPut(counts){
                mutableListOf()
            }.add(word)
        }

        return groups.values.toList()
    }
}
