class Solution {
    private lateinit var adjList : HashMap<Int, MutableList<Int>>
    private lateinit var cycle : HashSet<Int>

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // Step 1: Create an adjacency list
        adjList = HashMap()
        for(i in 0 until numCourses){
            adjList[i] = mutableListOf()
        }
        for(prereq in prerequisites){
            val (crs, pre) = prereq
            adjList[crs]!!.add(pre)
        }

        cycle = HashSet()

        // Step 2: DFS at every course
        for(crs in 0 until numCourses){
            if(dfs(crs) == false){
                return false
            }
        }
        return true
    }

    private fun dfs(course: Int) : Boolean {
        if(course in cycle){
            return false
        }
        if(adjList[course]!!.isEmpty()){
            return true
        }

        cycle.add(course)

        for(prereq in adjList[course]!!){
            if(dfs(prereq) == false){
                return false
            }
        }

        cycle.remove(course)
        adjList[course] = mutableListOf()
        return true
    }
}
