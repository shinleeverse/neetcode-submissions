class Solution {
    private lateinit var adj : Array<MutableList<Int>>
    private lateinit var visited: HashSet<Int>

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        // 1. Adj list
        adj = Array(n){mutableListOf<Int>()}
        for((n1, n2) in edges){
            adj[n1].add(n2)
            adj[n2].add(n1)
        }
        visited = HashSet()

        var count : Int = 0
        // 2. DFS through the list
        for(node in 0 until adj.size){
            // 3. As DFS, keep track of visited
            if(node !in visited){
                //dfs(node, -1)
                bfs(node)
                // 4. Count the number of new DFS
                count++
            }
        }
        return count
    }

    private fun dfs(node: Int, parent: Int){
        if(node in visited){
            return
        }

        visited.add(node)
        for(neighbor in adj[node]){
            if(neighbor == parent){
                continue
            }
            dfs(neighbor, node)
        }
    }

    private fun bfs(node: Int){
        val queue = ArrayDeque<Int>()
        queue.addLast(node)
        visited.add(node)

        while(queue.isNotEmpty()){
            var cur = queue.removeFirst()
            for(neighbor in adj[cur]){
                if(neighbor !in visited){
                    queue.addLast(neighbor)
                    visited.add(neighbor)
                }
            }
        }
    }
}
