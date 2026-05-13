class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length){
            return false
        }

        val counter = IntArray(26){0}

        s.forEach{ char ->
            counter[char.code - 'a'.code] += 1
        }

        t.forEach { char ->
            counter[char.code - 'a'.code] -= 1
        }
        
        counter.forEach { count ->
            if(count != 0){
                return false
            }
        }

        return true

    }
}
