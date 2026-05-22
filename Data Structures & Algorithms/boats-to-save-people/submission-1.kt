class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var count = 0
        var left = 0
        var right = people.size - 1

        while(left <= right){
            val remain = limit - people[right]
            right--
            count++
            if(left <= right && remain >= people[left]){
                left++
            }
        }

        return count
    }
}
