/**
Notes:
- sorted
- 1-indexed of two nums


**/

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {        
        val hashMap = HashMap<Int, Int>()
        for(i in numbers.indices){
            var diff = target - numbers[i]
            if(diff in hashMap){
                return intArrayOf(hashMap[diff]!! + 1, i + 1)
            }
            hashMap[numbers[i]] = i
        }
        return intArrayOf()
    }
}
