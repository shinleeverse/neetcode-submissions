class Solution {
    private lateinit var adjList: Array<MutableList<Int>>
    private lateinit var visited : HashSet<Int>
    
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if(edges.size > n - 1){
            return false
        }

        adjList = Array(n) {mutableListOf<Int>()}
        for((n1, n2) in edges){
            adjList[n1].add(n2)
            adjList[n2].add(n1)
        }

        visited = HashSet()

        //return hasLoopOrCycle(0, -1) && isGraphAllConnected(n)
        return bfs(n)
    }

    private fun hasLoopOrCycle(node: Int, parent: Int) : Boolean {
        if(node in visited){
            // Node has a cycle or a loop
            return false
        }
        visited.add(node)
        for(neighbor in adjList[node]){
            if(neighbor == parent){
                continue
            }
            if(hasLoopOrCycle(neighbor, node) == false){
                // One of Neighbors has a cycle or a loop
                return false
            }
        }
        return true
    }

    private fun isGraphAllConnected(n: Int): Boolean{
        return visited.size == n
    }

    private fun bfs(n : Int): Boolean{
        val queue = ArrayDeque<Pair<Int, Int>>() // Pair(Node, Parent)
        queue.addLast(0 to -1)
        visited.add(0)

        while(queue.isNotEmpty()){
            repeat(queue.size){
                val (node, parent) = queue.removeFirst()

                for(neighbor in adjList[node]){
                    if(neighbor == parent){
                        continue
                    }
                    if(neighbor in visited){
                        return false
                    }
                    queue.addLast(neighbor to node)
                    visited.add(neighbor)
                }
            }
        }

        return visited.size == n
    }
}
