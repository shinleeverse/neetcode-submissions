class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var light = 0
        var heavy = people.size - 1
        var boats = 0

        while(light <= heavy){
            val remain = limit - people[heavy]
            heavy--
            boats++

            if(light <= heavy && remain >= people[light]){
                light++
            }
        }

        return boats
    }
}
