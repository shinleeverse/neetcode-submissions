class Solution {
    private lateinit var adjList : HashMap<Int, MutableList<Int>>
    private lateinit var cycle : HashSet<Int>
    private lateinit var visited : HashSet<Int>

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        adjList = HashMap()
        for(crs in 0 until numCourses){
            adjList[crs] = mutableListOf()
        }
        for(prereq in prerequisites){
            val (crs, pre) = prereq
            adjList[crs]!!.add(pre)
        }

        cycle = HashSet()
        visited = HashSet()

        for(crs in 0 until numCourses){
            if(dfs(crs) == false){
                return false
            }
        }
        return true
    }

    private fun dfs(crs: Int) : Boolean{
        if(crs in cycle){
            return false
        }
        if(crs in visited){
            return true
        }

        cycle.add(crs)
        for(pre in adjList[crs]!!){
            if(dfs(pre) == false){
                return false
            }
        }

        cycle.remove(crs)
        visited.add(crs)
        return true
    }
}
