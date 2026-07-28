class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagrams = mutableMapOf<List<Int>, MutableList<String>>()
        for(s in strs){
            // Create HashMap using Array
            val counts = MutableList(26){0}
            for(c in s){
                counts[c - 'a']++
            }
            // Add the array to the HashMap<Counts, Group>
            anagrams.getOrPut(counts) {mutableListOf()}.add(s)
        }
        return anagrams.values.toList()
    }
}
